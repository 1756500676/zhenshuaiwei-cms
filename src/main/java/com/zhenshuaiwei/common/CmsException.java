/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: CmsException.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.common 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月15日 下午1:32:35 
 * @version: V1.0   
 */
package com.zhenshuaiwei.common;

/** 
 * @ClassName: CmsException 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月15日 下午1:32:35  
 */
public class CmsException extends RuntimeException {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -4199042466260679275L;

	
	public CmsException(String msg) {
		super(msg);
	}
	
	
}
