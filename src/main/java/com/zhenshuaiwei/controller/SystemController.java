/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: SystemController.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.controller 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月13日 上午11:32:56 
 * @version: V1.0   
 */
package com.zhenshuaiwei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.zhenshuaiwei.entity.Article;
import com.zhenshuaiwei.entity.Channel;
import com.zhenshuaiwei.service.ArticleService;
import com.zhenshuaiwei.service.ChannelService;

/** 
 * @ClassName: SystemController 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月13日 上午11:32:56  
 */
@Controller
@RequestMapping("/system")
public class SystemController {
	
	/**
	 * 频道接口
	 */
	@Autowired
	private ChannelService channelService;
	@Autowired
	private ArticleService articleService;
	
	/**
	 * 
	 * @Title: toIndex 
	 * @Description: 去管理员页面
	 * @return
	 * @return: String
	 * @date: 2019年11月13日上午11:47:19
	 */
	@GetMapping("/mangerIndex")
	public String toMangerIndex() {
		return "system/index";
	}
	
	/**
	 * 
	 * @Title: toIndex 
	 * @Description: 去主页面
	 * @return
	 * @return: String
	 * @date: 2019年11月13日上午11:47:19
	 */
	@GetMapping({"/index","/"})
	public String toIndex(Model m,
			@RequestParam(defaultValue = "1")int page) {
		//导航频道栏目的集合
		List<Channel> channelList = channelService.getChannelList();
		//获取最新的文章
		List<Article> newArticleList = articleService.getNewArticleList(5);
//		 * 获取热门的文章
		PageInfo<Article> hotArticleList = articleService.getHotArticleList(page);
		m.addAttribute("channelList", channelList);
		m.addAttribute("newArticleList", newArticleList);
		m.addAttribute("info", hotArticleList);
		return "/index";
	}

	
	
}
