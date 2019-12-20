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
import com.zhenshuaiwei.entity.Reply;

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
	 * @throws Exception 
	 * @date: 2019年11月21日上午9:54:36
	 */
	PageInfo<Comment> getArticleCommentById(Integer articleId,int pageNum) throws Exception;

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

	/** 
	 * @Title: pushReply 
	 * @Description: TODO
	 * @param reply
	 * @return: void
	 * @date: 2019年11月26日上午9:10:55
	 */
	void pushReply(Reply reply);

	/** 
	 * @Title: getReplayById 
	 * @Description: 获取评论回复
	 * @param replyId
	 * @return: void
	 * @date: 2019年12月18日下午2:28:46
	 */
	Reply getReplayById(int replyId);

}
