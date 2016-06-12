package com.sfxie.extension.spring4.datasource.multy;

/**
 * 数据源转化设置类
 * @TODO 
 * @author xsf
 * 2015年7月22日下午2:59:08
 * {@link com.sfxie.advert.common.spring.datasource.multy.DBContextHolder}
 */
public class DBContextHolder {
	/**	线程变量	*/
	private static final ThreadLocal<DBType> holder = new ThreadLocal<DBType>();

	/**
	 * 设置数据源名称
	 * xsf
	 * 2015年7月22日下午2:59:54
	 * TODO
	 * void
	 */
    public static void setDbType(DBType dbType) {
        holder.set(dbType);
    }

    public static DBType getDbType() {
        return (DBType) holder.get();
    }

    public static void clearDbType() {
        holder.remove();
    }
}
