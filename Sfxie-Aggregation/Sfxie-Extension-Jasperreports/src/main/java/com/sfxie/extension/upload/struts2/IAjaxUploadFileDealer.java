package com.sfxie.extension.upload.struts2;

import java.io.File;



/**
 * ajax 上传文件的处理定义接口
 * @author xieshengfeng
 * @since 2014-07-09
 *
 */
public interface IAjaxUploadFileDealer {
	/** 处理方法   */
	public void deal(AjaxFileUploadAction baseAction,File file)throws Exception;
	/**	文件上传前验证	*/
	public boolean supports(AjaxFileUploadAction baseAction,File file);
}
