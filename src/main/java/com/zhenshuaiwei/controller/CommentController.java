/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: CommentController.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.controller 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月21日 下午3:02:01 
 * @version: V1.0  
 */
package com.zhenshuaiwei.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhenshuaiwei.common.CmsAssert;
import com.zhenshuaiwei.common.ConstantClass;
import com.zhenshuaiwei.common.JsonMsg;
import com.zhenshuaiwei.entity.Article;
import com.zhenshuaiwei.entity.Comment;
import com.zhenshuaiwei.entity.User;
import com.zhenshuaiwei.service.ArticleService;
import com.zhenshuaiwei.service.CommentService;

/** 
 * @ClassName: CommentController 
 * @Description: 处理评论
 * @author:zsw 
 * @date: 2019年11月21日 下午3:02:01  
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	//文章
	@Autowired
	private ArticleService articleService;
	
	Logger log = Logger.getLogger(CommentController.class);


	/**
	 * 
	 * @Title: likeComment 
	 * @Description: 用户点赞这个评论
	 * @param id
	 * @return
	 * @return: JsonMsg
	 * @date: 2019年11月21日下午3:04:07
	 */
	@ResponseBody
	@PostMapping("/likeComment")
	public JsonMsg likeComment(int id) {
		if(commentService.likeComment(id) > 0)
			return JsonMsg.success();
		else
			return JsonMsg.error();
	}
	
	/**
	 * 
	 * @Title: pushComment 
	 * @Description: 发布文章评论
	 * @param session
	 * @param comment
	 * @return
	 * @return: JsonMsg
	 * @date: 2019年11月21日下午4:09:50
	 */
	@ResponseBody
	@PostMapping("/pushComment")
	public JsonMsg pushComment(HttpSession session,Comment comment) {
		User user = (User) session.getAttribute(ConstantClass.USER_KEY);
		comment.setUserId(user.getId());
		
		Article article = articleService.articleIsNull(comment.getArticleId());
		CmsAssert.AssertTrue(article != null , "文章不存在");
		int result = commentService.pushComment(comment);
		if (result > 0) return JsonMsg.success();
		else return JsonMsg.error();
	}
	
	@GetMapping("/myComment")
	public String myComment(Model m,HttpSession session,
							@RequestParam(defaultValue = "1")int page) {
		User user = (User)session.getAttribute(ConstantClass.USER_KEY);
		if (user != null) {
			PageInfo<Comment> info = commentService.getMyComment(page,user.getId());
			m.addAttribute("info", info);
		}
		return "user/myComment";
	}

}
