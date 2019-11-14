/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: ChannelTest.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.test 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月14日 下午1:28:40 
 * @version: V1.0   
 */
package com.zhenshuaiwei.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhenshuaiwei.service.ChannelService;

/** 
 * @ClassName: ChannelTest 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月14日 下午1:28:40  
 */
public class ChannelTest extends BaseTest{
	
	@Autowired
	private ChannelService service;
	
	@Test
	public void ListTest() {
		service.getChannelList().forEach(System.out::println);
	}

}
