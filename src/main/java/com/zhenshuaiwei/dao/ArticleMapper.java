/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: ArticleMapper.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.dao 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月14日 下午1:46:21 
 * @version: V1.0   
 */
package com.zhenshuaiwei.dao;

import java.util.List;

import com.zhenshuaiwei.entity.Article;

/** 
 * @ClassName: ArticleMapper 
 * @Description: 文章Dao层
 * @author:zsw 
 * @date: 2019年11月14日 下午1:46:21  
 */
public interface ArticleMapper {

	/** 
	 * @Title: getNewArticleList 
	 * @Description: TODO
	 * @param count
	 * @return: void
	 * @date: 2019年11月14日下午1:50:43
	 */
	List<Article> getNewArticleList(int count);

	/** 
	 * @Title: getHotArticleList 
	 * @Description: TODO
	 * @return
	 * @return: List<Article>
	 * @date: 2019年11月14日下午2:09:34
	 */
	List<Article> getHotArticleList();

	/** 
	 * @Title: getArticleById 
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: Article
	 * @date: 2019年11月14日下午6:54:27
	 */
	Article getArticleById(Integer id);

}
