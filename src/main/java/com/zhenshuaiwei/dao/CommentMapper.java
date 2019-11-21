/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: CommentService.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.dao 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月21日 上午9:47:51 
 * @version: V1.0  
 */
package com.zhenshuaiwei.dao;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import com.zhenshuaiwei.entity.Comment;

/** 
 * @ClassName: CommentService 
 * @Description: 评论
 * @author:zsw 
 * @date: 2019年11月21日 上午9:47:51  
 */
public interface CommentMapper{

	/** 
	 * @Title: getArticleCommentById 
	 * @Description: 查询文章的评论
	 * @param articleId
	 * @return: void
	 * @date: 2019年11月21日上午9:55:21
	 */
	List<Comment> getArticleCommentById(Integer articleId);

	/** 
	 * @Title: pushComment 
	 * @Description: TODO
	 * @param comment
	 * @return
	 * @return: int
	 * @date: 2019年11月21日上午11:02:27
	 */
	int pushComment(Comment comment);

	/** 
	 * @Title: likeComment 
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: int
	 * @date: 2019年11月21日下午3:03:11
	 */
	@Update("update cms_comment set likeNum = likeNum + 1 where id = ${value}")
	int likeComment(int id);

	/** 
	 * @Title: getMyComment 
	 * @Description: TODO
	 * @param id
	 * @return: void
	 * @date: 2019年11月21日下午4:11:56
	 */
	List<Comment> getMyComment(Integer id);

}
