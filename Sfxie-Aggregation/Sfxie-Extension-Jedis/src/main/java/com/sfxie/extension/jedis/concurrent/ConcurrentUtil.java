package com.sfxie.extension.jedis.concurrent;

import static com.google.common.base.Preconditions.checkNotNull;

import org.jetbrains.annotations.NotNull;

import com.happyelements.odin.jedis.JedisClient;
import com.happyelements.rdcenter.commons.util.DateTimeUtil;

/**
 * User: jude.wang
 * Date: 14-1-16
 * Time: 上午9:43
 */
public class ConcurrentUtil {

 public static final String USER_LOCK_KEY_FORMAT = "user_lock_%d_%s";
 public static final String CUSTOM_LOCK_FORMAT = "custom_lock_%s";
 public static final JedisClient redisClient = JedisClient.getInstance();
 public static final String UNLOCKED = "0";
 public static final String LOCKED = "1";
 private static final int MAX_REPEAT_TIMES = 10;

 @NotNull
 public static String buildUserLockKey(long userId, @NotNull String key) {
  checkNotNull(key);
  return String.format(USER_LOCK_KEY_FORMAT, userId, key);
 }

 @NotNull
 public static String buildCustomLockKey(@NotNull String key) {
  checkNotNull(key);
  return String.format(CUSTOM_LOCK_FORMAT, key);
 }

 /**
  * 此方法可以因为拿不到锁而导致operation没有执行
  *
  * @param key
  * @see com.happyelements.odin.util.ConcurrentUtil#buildCustomLockKey(String)
  * @see com.happyelements.odin.util.ConcurrentUtil#buildUserLockKey(long, String)
  *
  * @param operation
  * @throws com.happyelements.odin.util.ConcurrentUtil.OperationNotExecException
  *             operation没有被执行
  */
 public static void doJobWithLock(@NotNull String key, @NotNull ILockOperation operation) throws OperationNotExecException {

  boolean locked = false;
  try {
   checkNotNull(key);
   checkNotNull(operation);
   locked = lock(key);

  } catch (Throwable t) {
   throw new OperationNotExecException(key, t);
  }

  try {
   if (locked) {
    // System.out.println(Thread.currentThread() + "\t" + "lock");
    operation.doJob();
   } else {
    throw new OperationNotExecException(key);
   }
  } finally {
   if (locked) {
    unlock(key);
   }
  }
 }

 private static void unlock(String key) {
  try {
   checkNotNull(key);
   String oldStatus = redisClient.getSet(key, UNLOCKED);
   if (isUnlocked(oldStatus)) {
    // lock->doJob->过期->unlock
    // TODO LOG
   }
  } catch (Throwable t) {
   // TODO LOG
  }
  // System.out.println(Thread.currentThread() + "\t" + "unlock");
 }

 private static boolean isUnlocked(String status) {
  return status == null || status.equals(UNLOCKED);
 }

 private static boolean lock(String key) {

  boolean locked = false;

  for (int i = 0; i < MAX_REPEAT_TIMES; i++) {
   String oldStatus = redisClient.getSet(key, LOCKED);

   if (isUnlocked(oldStatus)) {
    if (oldStatus == null) {
     redisClient.expire(key, DateTimeUtil.MINUTE_SECOND * 5);
     locked = true;
     break;
    }
    locked = true;
    break;
   }
  }

  return locked;
 }

 public static interface ILockOperation {
  void doJob();
 }

 /**
  * {@link com.happyelements.odin.util.ConcurrentUtil.ILockOperation#doJob()}没有被执行
  * 上层必须处理该异常，捕获到该异常可以retry本次操作，或者包装成{@link com.happyelements.rdcenter.commons.throwable.HeException} 抛出去
  */
 public static class OperationNotExecException extends Exception {
  public OperationNotExecException() {
  }

  public OperationNotExecException(String s) {
   super(s);
  }

  public OperationNotExecException(String s, Throwable throwable) {
   super(s, throwable);
  }

  public OperationNotExecException(Throwable throwable) {
   super(throwable);
  }
 }
}