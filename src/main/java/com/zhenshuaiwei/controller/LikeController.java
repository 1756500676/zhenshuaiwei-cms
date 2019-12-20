/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: LikeController.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.controller 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月26日 下午1:09:42 
 * @version: V1.0  
 */
package com.zhenshuaiwei.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenshuaiwei.common.ConstantClass;
import com.zhenshuaiwei.common.JsonMsg;
import com.zhenshuaiwei.service.LikeService;
import com.zhenshuaiwei.entity.Like;
import com.zhenshuaiwei.entity.User;

/** 
 * @ClassName: LikeController 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月26日 下午1:09:42  
 */
@Controller
@RequestMapping("/like")
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	
	@ResponseBody
	@PostMapping("/insertLike")
	public JsonMsg likeArticle(HttpSession session,Like like) {
		User user = (User) session.getAttribute(ConstantClass.USER_KEY);
		like.setUserId(user.getId());
		likeService.insertLike(like);
		return JsonMsg.success();
	}

}
