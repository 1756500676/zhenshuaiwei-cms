/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: Demo01.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.test 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月13日 下午2:07:13 
 * @version: V1.0   
 */
package com.zhenshuaiwei.test;

import org.junit.Test;

import com.zhenshuaiwei.common.JsonMsg;

/** 
 * @ClassName: Demo01 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月13日 下午2:07:13  
 */
public class Demo01 {

	@Test
	public void testJsonMsg() {
		JsonMsg addInfo = JsonMsg.error().addInfo("error_emp", "员工失败");
		
		System.out.println(addInfo.getMsg());
		System.out.println(addInfo.getInfo().get("error_emp"));
		
	}
}
