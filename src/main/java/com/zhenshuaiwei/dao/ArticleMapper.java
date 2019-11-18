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

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

	/** 
	 * @Title: getArticleByCG 
	 * @Description: TODO
	 * @param chId
	 * @param caId
	 * @return: void
	 * @date: 2019年11月14日下午7:32:56
	 */
	List<Article> getArticleByCG(@Param("chId")int chId, @Param("caId")int caId);

	/** 
	 * @Title: getMyArticle 
	 * @Description: TODO
	 * @param id
	 * @return: void
	 * @date: 2019年11月18日下午7:12:26
	 */
	List<Article> getMyArticle(Integer id);

	/** 
	 * @Title: deleteArticle 
	 * @Description: TODO
	 * @param id
	 * @return: void
	 * @date: 2019年11月18日下午7:49:22
	 */
	@Update("update cms_article set deleted = 1 where id = ${value}")
	int deleteArticle(int id);

	/** 
	 * @Title: articleIsNull 
	 * @Description: TODO
	 * @param id
	 * @return: void
	 * @date: 2019年11月18日下午7:57:59
	 */
	Article articleIsNull(int id);


}
