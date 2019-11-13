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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	 * 
	 * @Title: toIndex 
	 * @Description: 去主页面
	 * @return
	 * @return: String
	 * @date: 2019年11月13日上午11:47:19
	 */
	@GetMapping("/index")
	public String toIndex() {
		return "system/index";
	}

}
