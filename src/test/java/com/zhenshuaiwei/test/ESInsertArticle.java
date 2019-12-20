/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: ESInsertArticle.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.test 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年12月17日 下午1:21:08 
 * @version: V1.0  
 */
package com.zhenshuaiwei.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.zhenshuaiwei.common.ESHLUtil;
import com.zhenshuaiwei.dao.ArticleRepository;
import com.zhenshuaiwei.entity.Article;
import com.zhenshuaiwei.service.ArticleService;

/** 
 * @ClassName: ESInsertArticle 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年12月17日 下午1:21:08  
 */
public class ESInsertArticle extends BaseTest {

	@Autowired
	private ArticleService articleService;
	
	@Autowired 
	private ArticleRepository articleRepository;
	
	
	@Test
	public void addArticle() {
		List<Article> list = articleService.getAddToESArticles();
		articleRepository.saveAll(list);
	}
	
	@Test
	public void deleteArticle() {
		articleRepository.deleteAll();
	}
	
	@Test
	public void selectArticle() {
		PageInfo<Article> pageInfo = ESHLUtil.selectPageObjects(Article.class, 1, 10,"id", new String[]{"title"},  "湖北").getPageInfo();
		pageInfo.getList().forEach(x -> {
			System.out.println(x.getId()+"==="+x.getTitle());
		});
	}
	
	@Test
	public void selectPageArticle() {
	}
	
	
}
