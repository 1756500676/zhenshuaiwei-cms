/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: LinkController.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.controller 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月23日 下午6:33:00 
 * @version: V1.0  
 */
package com.zhenshuaiwei.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhenshuaiwei.common.JsonMsg;
import com.zhenshuaiwei.entity.Link;
import com.zhenshuaiwei.service.LinkService;

/** 
 * @ClassName: LinkController 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月23日 下午6:33:00  
 */
@RequestMapping("link")
@Controller
public class LinkController {
	
	@Autowired
	private LinkService linkService;
	
	
	/**
	 * 
	 * @Title: addLink 
	 * @Description: 去往添加友情链接页面
	 * @param m
	 * @return
	 * @return: String
	 * @date: 2019年11月23日下午7:09:08
	 */
	@GetMapping("/addLink")
	public String addLink(Model m) {
		m.addAttribute("link", new Link());
		return "system/addLink2";
	}
	
	/**
	 * 
	 * @Title: addLink 
	 * @Description: 添加友情链接
	 * @param link
	 * @param result
	 * @return
	 * @return: String
	 * @date: 2019年11月23日下午7:09:26
	 */
	@PostMapping("/addLink")
	public String addLink(@Valid @ModelAttribute("link")Link link,BindingResult result) {
		if (result.hasErrors()) {
				return "system/addLink2";
			
		}
		linkService.addLink(link);
		return "system/index";
	}
	
	@GetMapping("/linkList")
	public String linkList(Model m,@RequestParam(defaultValue = "1")int page) {
		PageInfo<Link> info = linkService.getLinks(page);
		m.addAttribute("info", info);
		return "system/links";
	}
	
	

}
