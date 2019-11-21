/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: CmsExceptionHtml.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.common 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月19日 下午1:11:57 
 * @version: V1.0  
 */
package com.zhenshuaiwei.common;

/** 
 * @ClassName: CmsExceptionHtml 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月19日 下午1:11:57  
 */
public class CmsExceptionHtml extends RuntimeException {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 9058894306335032368L;

	public CmsExceptionHtml(String msg) {
		super(msg);
	}
	
	
}
