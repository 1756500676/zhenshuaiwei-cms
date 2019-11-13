/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: UserController.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.controller 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月13日 上午10:38:33 
 * @version: V1.0   
 */
package com.zhenshuaiwei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhenshuaiwei.common.JsonMsg;
import com.zhenshuaiwei.entity.User;
import com.zhenshuaiwei.service.UserService;

/** 
 * @ClassName: UserController 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月13日 上午10:38:33  
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	/**
	 * 
	 * @Title: getUserList 
	 * @Description: 获取用户集合,分页,按照姓名模糊查询
	 * @param m
	 * @param page
	 * @param name
	 * @return
	 * @return: String
	 * @date: 2019年11月13日上午11:29:46
	 */
	@RequestMapping("users")
	public String getUserList(Model m,
			@RequestParam(defaultValue = "1")String page,
			@RequestParam(defaultValue = "")String name) {
		PageInfo<User> info = service.getUserList(name,page);
		m.addAttribute("info", info);
		return "user/userList";
	}
	
	@ResponseBody
	@PostMapping("/updateUserLocked")
	public JsonMsg updateUserLocked(int id,int locked) {
		if (locked != 1 && locked != 0) {
			return JsonMsg.error().addInfo("update_status_error", "状态参数无效");
		}
		User user = service.geteUserById(id);
		if (user == null) {
			return JsonMsg.error().addInfo("update_status_error", "该用户不存在");
		}else if(user.getLocked() == locked){
			return JsonMsg.error().addInfo("update_status_error", "状态无需更改");
		}
		
		boolean updateUserLocked = service.updateUserLocked(id,locked);
		if (updateUserLocked) {
			return JsonMsg.success();
		}else {
			return JsonMsg.error().addInfo("update_status_error", "服务端发生异常,修改失败,请联系管理员");
		}
	}
	

}
