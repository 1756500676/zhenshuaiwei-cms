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
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.zhenshuaiwei.common.ESHLUtil;
import com.zhenshuaiwei.common.HLUtils;
import com.zhenshuaiwei.dao.ArticleRepository;
import com.zhenshuaiwei.entity.Article;
import com.zhenshuaiwei.entity.Channel;
import com.zhenshuaiwei.entity.Link;
import com.zhenshuaiwei.service.ArticleService;
import com.zhenshuaiwei.service.ChannelService;
import com.zhenshuaiwei.service.LinkService;

/** 
 * @ClassName: SystemController 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月13日 上午11:32:56  
 */
@Controller
public class SystemController {
	
	/**
	 * 频道接口
	 */
	@Autowired
	private ChannelService channelService;
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private LinkService linkService;
	
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	
	/**
	 * 
	 * @Title: toIndex 
	 * @Description: 去管理员页面
	 * @return
	 * @return: String
	 * @date: 2019年11月13日上午11:47:19
	 */
	@GetMapping("/admin")
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
//		后去友情lianjie
		PageInfo<Link> links = linkService.getLinks(1);
		m.addAttribute("channelList", channelList);
		m.addAttribute("newArticleList", newArticleList);
		m.addAttribute("info", hotArticleList);
		m.addAttribute("links", links.getList());
		return "/index";
	}
	
	@GetMapping("/search")
	public String search(Model m,
						String searchV,
						@RequestParam(defaultValue = "1")int page) {
		PageInfo<Article> info = ESHLUtil.selectPageObjects(Article.class, page, 5, "id", new String[] {"title"}, searchV).getPageInfo();
		m.addAttribute("info", info);
		m.addAttribute("searchV", searchV);
		return "/searchIndex";
	}

	@GetMapping("/error")
	public String toError() {
		return "error";
	}
	
	/**
	 * 
	 * @Title: toLogin 
	 * @Description: 去登入页面
	 * @return
	 * @return: String
	 * @date: 2019年11月17日下午8:00:09
	 */
	@GetMapping("/login")
	public String toLogin(Model m,String choose,String gotoArticle) {
		m.addAttribute("choose", choose);
		if (gotoArticle != null && !"".equals(gotoArticle)) {
			m.addAttribute("gotoArticle", gotoArticle);
		}
		return "user/newLogin";
	}
}
