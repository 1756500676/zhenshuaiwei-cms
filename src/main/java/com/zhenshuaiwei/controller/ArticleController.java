/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: ArticleController.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.controller 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月14日 下午6:51:15 
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
import com.zhenshuaiwei.entity.Category;
import com.zhenshuaiwei.service.ArticleService;
import com.zhenshuaiwei.service.CategoryService;
import com.zhenshuaiwei.service.ChannelService;

/** 
 * @ClassName: ArticleController 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月14日 下午6:51:15  
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private CategoryService categoryService; 
	
	
	/**
	 * 
	 * @Title: getArticleById 
	 * @Description: 根据id获取文章
	 * @param m
	 * @param id
	 * @return
	 * @return: String
	 * @date: 2019年11月14日下午7:28:58
	 */
	@GetMapping("/getArticleById")
	public String getArticleById(Model m,Integer id) {
		Article article = articleService.getArticleById(id);
		System.out.println(article);
		m.addAttribute("article", article);
		return "article/articleDetails";
	}
	
	
	@GetMapping("/getArticleByCG")
	public String getArticleByCG(Model m,
								 @RequestParam(defaultValue = "1")int chId,
								 @RequestParam(defaultValue = "0")int caId,
								 @RequestParam(defaultValue = "1")int page) {
		
		List<Category> cateList = categoryService.getCateListByChannelId(chId);
		m.addAttribute("cateList",cateList);
		/**
		 * 获取文章
		 */
		PageInfo<Article> info = articleService.getArticleByCG(chId,caId,page);
		
		m.addAttribute("caId",caId);
		m.addAttribute("chId",chId);
		m.addAttribute("info",info);
		return "article/channelCate";
	}

}
