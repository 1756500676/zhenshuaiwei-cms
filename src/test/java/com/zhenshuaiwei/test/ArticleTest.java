/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: ArticleTest.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.test 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月14日 下午2:19:51 
 * @version: V1.0   
 */
package com.zhenshuaiwei.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhenshuaiwei.service.ArticleService;

/** 
 * @ClassName: ArticleTest 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月14日 下午2:19:51  
 */
public class ArticleTest extends BaseTest{

	@Autowired
	private ArticleService service;
	
	@Test
	public void newArticleTest() {
		service.getNewArticleList(5).forEach(System.out::println);
	}
	
	@Test
	public void hotArticleTest() {
		service.getHotArticleList(4).getList().forEach(System.out::println);
	}
}
