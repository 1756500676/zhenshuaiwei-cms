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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhenshuaiwei.dao.ArticleMapper;
import com.zhenshuaiwei.dao.CommentMapper;
import com.zhenshuaiwei.dao.ReplyMapper;
import com.zhenshuaiwei.dateutils.DateDesc;
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
	public PageInfo<Comment> getArticleCommentById(Integer articleId,int pageNum) throws Exception {
		PageHelper.startPage(pageNum, 5);
		List<Comment> list = mapper.getArticleCommentById(articleId);
		//改变评论的恢复时间,使用倒计时
		for (Comment comment : list) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:m:s");
			Date date = format.parse(comment.getDateDesc());
			comment.setDateDesc(DateDesc.format(date));
			System.out.println(comment);
		}
		for (Comment comment : list) {
			for (Reply repl : comment.getReplys()) {
				String descDate = DateDesc.format(repl.getCreated());
				repl.setDescDate(descDate);
			}
		}
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

	@Override
	public Reply getReplayById(int replyId) {
		return replyMapper.getReplayById(replyId);
	}
	
}
