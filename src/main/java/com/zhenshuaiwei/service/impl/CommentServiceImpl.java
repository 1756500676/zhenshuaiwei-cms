/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: CommentServiceImpl.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.service.impl 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月21日 上午9:49:02 
 * @version: V1.0  
 */
package com.zhenshuaiwei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhenshuaiwei.dao.ArticleMapper;
import com.zhenshuaiwei.dao.CommentMapper;
import com.zhenshuaiwei.dao.ReplyMapper;
import com.zhenshuaiwei.entity.Comment;
import com.zhenshuaiwei.entity.Reply;
import com.zhenshuaiwei.service.CommentService;

/** 
 * @ClassName: CommentServiceImpl 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月21日 上午9:49:02  
 */
@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentMapper mapper;

	@Autowired
	private ArticleMapper articleMapper;
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public PageInfo<Comment> getArticleCommentById(Integer articleId,int pageNum) {
		PageHelper.startPage(pageNum, 5);
		List<Comment> list = mapper.getArticleCommentById(articleId);
		return new PageInfo<Comment>(list);
	}

	@Override
	public int pushComment(Comment comment) {
		//文章的评论数量加1
		articleMapper.updateArticleCommentCntUp(comment);
		return mapper.pushComment(comment);
	}

	@Override
	public int likeComment(int id) {
		return mapper.likeComment(id);
	}

	@Override
	public PageInfo<Comment> getMyComment(int page,Integer id) {
		PageHelper.startPage(page, 10);
		List<Comment> list = mapper.getMyComment(id);
		return new PageInfo<Comment>(list);
	}

	@Override
	public void pushReply(Reply reply) {
		replyMapper.pushReply(reply);
	}
	
}
