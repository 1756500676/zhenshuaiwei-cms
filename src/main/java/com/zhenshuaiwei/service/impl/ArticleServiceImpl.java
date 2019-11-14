/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: ArticleServiceImpl.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.service.impl 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月14日 下午1:44:49 
 * @version: V1.0   
 */
package com.zhenshuaiwei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhenshuaiwei.dao.ArticleMapper;
import com.zhenshuaiwei.entity.Article;
import com.zhenshuaiwei.service.ArticleService;

/** 
 * @ClassName: ArticleServiceImpl 
 * @Description: 文章接口实现
 * @author:zsw 
 * @date: 2019年11月14日 下午1:44:49  
 */
@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleMapper mapper;

	@Override
	public List<Article> getNewArticleList(int count) {
		// TODO 获取最新的文章
		return mapper.getNewArticleList(count);
	}

	@Override
	public  PageInfo<Article> getHotArticleList(int page) {
		PageHelper.startPage(page, 3);
		return new PageInfo<Article>(mapper.getHotArticleList());
	}

	@Override
	public Article getArticleById(Integer id) {
		return mapper.getArticleById(id);
	}

	@Override
	public PageInfo<Article> getArticleByCG(int chId, int caId, int page) {
		PageHelper.startPage(page, 5);
		List<Article> articleByCG = mapper.getArticleByCG(chId,caId);
		return new PageInfo<Article>(articleByCG);
	}

}
