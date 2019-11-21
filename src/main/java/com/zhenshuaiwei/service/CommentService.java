/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: CommentService.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.service 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月21日 上午9:49:27 
 * @version: V1.0  
 */
package com.zhenshuaiwei.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhenshuaiwei.entity.Comment;

/** 
 * @ClassName: CommentService 
 * @Description: 评论
 * @author:zsw 
 * @date: 2019年11月21日 上午9:49:27  
 */
public interface CommentService {

	/** 
	 * @Title: getArticleCommentById 
	 * @Description: 获取文章的评论
	 * @param articleId
	 * @return: void
	 * @date: 2019年11月21日上午9:54:36
	 */
	List<Comment> getArticleCommentById(Integer articleId);

	/** 
	 * @Title: pushComment 
	 * @Description: 发布评论
	 * @param comment
	 * @return: void
	 * @date: 2019年11月21日上午11:01:50
	 */
	int pushComment(Comment comment);

	/** 
	 * @Title: likeComment 
	 * @Description: 点赞评论
	 * @param id
	 * @return: void
	 * @date: 2019年11月21日下午3:02:50
	 */
	int likeComment(int id);

	/** 
	 * @Title: getMyComment 
	 * @Description: 获取我的评论
	 * @param id
	 * @return: void
	 * @date: 2019年11月21日下午4:08:12
	 */
	PageInfo<Comment> getMyComment(int page,Integer id);

}
