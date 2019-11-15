/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: Md5.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.common 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月15日 下午1:41:38 
 * @version: V1.0   
 */
package com.zhenshuaiwei.common;

import org.apache.commons.codec.digest.DigestUtils;

/** 
 * @ClassName: Md5 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月15日 下午1:41:38  
 */
public class Md5 {

	public static String password(String password,String salt) {
		return DigestUtils.md5Hex(password+"ZSW"+salt);
	}
	
}
