package com.sfxie.extension.aliyun.oss.fileupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.event.ProgressEvent;
import com.aliyun.oss.event.ProgressEventType;
import com.aliyun.oss.event.ProgressListener;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;

/**
 * 上传下载进度示例
 *
 */
public class GetProgressSample {
    
    /**
     * 获取上传进度回调
     *
     */
    static class PutObjectProgressListener implements ProgressListener {

        private long bytesWritten = 0;
        private long totalBytes = -1;
        private boolean succeed = false;
        
        @Override
        public void progressChanged(ProgressEvent progressEvent) {
            long bytes = progressEvent.getBytes();
            ProgressEventType eventType = progressEvent.getEventType();
            switch (eventType) {
            case TRANSFER_STARTED_EVENT:
                System.out.println("Start to upload......");
                break;
            
            case REQUEST_CONTENT_LENGTH_EVENT:
                this.totalBytes = bytes;
                System.out.println(this.totalBytes + " bytes in total will be uploaded to OSS");
                break;
            
            case REQUEST_BYTE_TRANSFER_EVENT:
                this.bytesWritten += bytes;
                if (this.totalBytes != -1) {
                    int percent = (int)(this.bytesWritten * 100.0 / this.totalBytes);
                    System.out.println(bytes + " bytes have been written at this time, upload progress: " +
                            percent + "%(" + this.bytesWritten + "/" + this.totalBytes + ")");
                } else {
                    System.out.println(bytes + " bytes have been written at this time, upload ratio: unknown" +
                            "(" + this.bytesWritten + "/...)");
                }
                break;
                
            case TRANSFER_COMPLETED_EVENT:
                this.succeed = true;
                System.out.println("Succeed to upload, " + this.bytesWritten + " bytes have been transferred in total");
                break;
                
            case TRANSFER_FAILED_EVENT:
                System.out.println("Failed to upload, " + this.bytesWritten + " bytes have been transferred");
                break;
                
            default:
                break;
            }
        }

        public boolean isSucceed() {
            return succeed;
        }
    }
    
    /**
     * 获取下载进度回调
     *
     */
    static class GetObjectProgressListener implements ProgressListener {
        
        private long bytesRead = 0;
        private long totalBytes = -1;
        private boolean succeed = false;
        
        @Override
        public void progressChanged(ProgressEvent progressEvent) {
            long bytes = progressEvent.getBytes();
            ProgressEventType eventType = progressEvent.getEventType();
            switch (eventType) {
            case TRANSFER_STARTED_EVENT:
                System.out.println("Start to download......");
                break;
            
            case RESPONSE_CONTENT_LENGTH_EVENT:
                this.totalBytes = bytes;
                System.out.println(this.totalBytes + " bytes in total will be downloaded to a local file");
                break;
            
            case RESPONSE_BYTE_TRANSFER_EVENT:
                this.bytesRead += bytes;
                if (this.totalBytes != -1) {
                    int percent = (int)(this.bytesRead * 100.0 / this.totalBytes);
                    System.out.println(bytes + " bytes have been read at this time, download progress: " +
                            percent + "%(" + this.bytesRead + "/" + this.totalBytes + ")");
                } else {
                    System.out.println(bytes + " bytes have been read at this time, download ratio: unknown" +
                            "(" + this.bytesRead + "/...)");
                }
                break;
                
            case TRANSFER_COMPLETED_EVENT:
                this.succeed = true;
                System.out.println("Succeed to download, " + this.bytesRead + " bytes have been transferred in total");
                break;
                
            case TRANSFER_FAILED_EVENT:
                System.out.println("Failed to download, " + this.bytesRead + " bytes have been transferred");
                break;
                
            default:
                break;
            }
        }
        
        public boolean isSucceed() {
            return succeed;
        }
    }
    
    public static void main(String[] args) { 
    	uploadFile();
//    	donwloadFile();
    }
    private static void donwloadFile(){
    	String endpoint = "oss-cn-shenzhen.aliyuncs.com";
      String accessKeyId = "p7Cs5zrHIoTWsvYW";
      String accessKeySecret = "9qjRWRQhxoIWpBVz5C0iwzLjVa5rYX";
      String bucketName = "wycrm";
      
      String key = "decoratioin/object-get-progress-sample.jpg";
      
      OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);

      try {
          File fh = new File("C:\\Users\\xiesf\\Desktop\\indexDownload.jpg");
          
          // 带进度条的下载
          client.getObject(new GetObjectRequest(bucketName, key).
                  <GetObjectRequest>withProgressListener(new GetObjectProgressListener()), fh);
          System.out.println(1111);
      } catch (Exception e) {
          e.printStackTrace();
      }
    }
    private static void uploadFile(){
    	String endpoint = "oss-cn-shenzhen.aliyuncs.com";
  	
      String accessKeyId = "p7Cs5zrHIoTWsvYW";
      String accessKeySecret = "9qjRWRQhxoIWpBVz5C0iwzLjVa5rYX";
      String bucketName = "wycrm";
      
      String key = "decoratioin/object-get-progress-sample.jpg";
      
      OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);

      try {
          File fh  = new File("C:\\Users\\xiesf\\Desktop\\index.jpg");
          ObjectMetadata meta = new ObjectMetadata();
          meta.setContentType("image/jpeg");
          // 带进度条的上传 
          client.putObject(new PutObjectRequest(bucketName, key, fh,meta).
                  <PutObjectRequest>withProgressListener(new PutObjectProgressListener()));
          
          System.out.println(1111);
      } catch (Exception e) {
          e.printStackTrace();
      }
    }
    

}

