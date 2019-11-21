/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: CmsAssert.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.common 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月15日 下午1:17:53 
 * @version: V1.0   
 */
package com.zhenshuaiwei.common;

/** 
 * @ClassName: CmsAssert 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月15日 下午1:17:53  
 */
public class CmsAssert {

	public static void  AssertTrue(boolean express,String msg){
		if (!express) {
			throw new CmsException(msg);
		}
	}
	
	/**
	 * 
	 * @Title: AssertTrueHtml 
	 * @Description: 在页面显示的异常
	 * @param express
	 * @param msg
	 * @return: void
	 * @date: 2019年11月19日下午1:15:40
	 */
	public static void  AssertTrueHtml(boolean express,String msg){
		if (!express) {
			throw new CmsExceptionHtml(msg);
		}
	}
}
