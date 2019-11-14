/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: ArticleService.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.service 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月14日 下午1:44:30 
 * @version: V1.0   
 */
package com.zhenshuaiwei.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhenshuaiwei.entity.Article;
import com.zhenshuaiwei.entity.Channel;

/** 
 * @ClassName: ArticleService 
 * @Descriptio 文章接口
 * @author:zsw 
 * @date: 2019年11月14日 下午1:44:30  
 */
public interface ArticleService {

	/** 
	 * @Title: getNewArticleList 
	 * @Description: 获取最新的文章
	 * @param i
	 * @return: void
	 * @date: 2019年11月14日下午1:49:44
	 */
	List<Article> getNewArticleList(int count);

	/** 
	 * @Title: getHotArticleList 
	 * @Description: TODO
	 * @return: void
	 * @date: 2019年11月14日下午2:09:06
	 */
	PageInfo<Article> getHotArticleList(int page);

	/** 
	 * @Title: getArticleById 
	 * @Description: TODO
	 * @param id
	 * @return: void
	 * @date: 2019年11月14日下午6:53:57
	 */
	Article getArticleById(Integer id);

	/** 
	 * @Title: getArticleByCG 
	 * @Description: TODO
	 * @param chId
	 * @param caId
	 * @param page
	 * @return: void
	 * @date: 2019年11月14日下午7:32:09
	 */
	PageInfo<Article> getArticleByCG(int chId, int caId, int page);


}
