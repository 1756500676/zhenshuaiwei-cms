/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: UserRigister.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.test 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月15日 下午1:45:05 
 * @version: V1.0   
 */
package com.zhenshuaiwei.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhenshuaiwei.common.JsonMsg;
import com.zhenshuaiwei.entity.User;
import com.zhenshuaiwei.service.UserService;

/** 
 * @ClassName: UserRigister 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月15日 下午1:45:05  
 */
public class UserRigisterTest extends BaseTest{
	
	@Autowired
	private UserService service;
	
	
	@Test
	public void userRigister() {
		User user = new User();
		user.setUsername("zhenshuaiwei");
		user.setPassword("zsw123");
		JsonMsg msg = service.register(user);
		System.out.println(msg.getMsg());
	}
	
	

}
