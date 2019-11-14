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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhenshuaiwei.entity.Article;
import com.zhenshuaiwei.service.ArticleService;

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
	private ArticleService service;
	
	
	@GetMapping("/getArticleById")
	public String getArticleById(Model m,Integer id) {
		Article article = service.getArticleById(id);
		System.out.println(article);
		m.addAttribute("article", article);
		return "article/articleDetails";
	}
	
	

}
