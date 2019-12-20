/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: ArticleRepository.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.dao 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年12月17日 下午1:09:44 
 * @version: V1.0  
 */
package com.zhenshuaiwei.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.zhenshuaiwei.entity.Article;

/** 
 * @ClassName: ArticleRepository 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年12月17日 下午1:09:44  
 */
public interface ArticleRepository extends ElasticsearchRepository<Article, Integer>{

	public List<Article> findByTitleOrContent(String title,String content);
	
}
