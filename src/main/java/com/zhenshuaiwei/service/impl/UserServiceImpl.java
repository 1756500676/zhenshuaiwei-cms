/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: UserServiceImpl.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.service.impl 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月13日 上午11:18:20 
 * @version: V1.0   
 */
package com.zhenshuaiwei.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhenshuaiwei.common.CmsAssert;
import com.zhenshuaiwei.common.ConstantClass;
import com.zhenshuaiwei.common.JsonMsg;
import com.zhenshuaiwei.common.Md5;
import com.zhenshuaiwei.dao.UserMapper;
import com.zhenshuaiwei.entity.User;
import com.zhenshuaiwei.service.UserService;

/** 
 * @ClassName: UserServiceImpl 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月13日 上午11:18:20  
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;

	@Override
	public PageInfo<User> getUserList(String name, String page) {
		//分页
		PageHelper.startPage(Integer.parseInt(page), ConstantClass.PAGE_Size);
//		获取结合,返回
		return new PageInfo<User>(mapper.getUserList(name));
	}

	@Override
	public User geteUserById(int id) {
		return mapper.getUserById(id);
	}

	@Override
	public boolean updateUserLocked(int id, int locked) {
		try {
			mapper.updateUserLocked(id,locked);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public JsonMsg register(User user) {
			User userByName = mapper.getUserByName(user.getUsername());
			if (userByName != null) {
				return JsonMsg.error().addInfo("register_error", "该用户已存在");
			}
			CmsAssert.AssertTrue(userByName == null, "该用户已存在");
			user.setPassword(Md5.password(user.getPassword(), user.getPassword().substring(0,3)));
			int register = mapper.register(user);
			if (register <= 0) {
				return JsonMsg.error().addInfo("register_error", "服务端发生异常请联系管理员");
			}
			CmsAssert.AssertTrue(register > 0, "注册失败");
			return JsonMsg.success();
	}

	@Override
	public User goLogin(User user) {
		if (user.getPassword() != null) {
			user.setPassword(Md5.password(user.getPassword(), user.getPassword().substring(0, 3)));
		}
		User user2 = mapper.goLogin(user);
//		CmsAssert.AssertTrue(user2 != null, "用户名或密码输入错误");
		return user2;
	}

	@Override
	public boolean getUserByName(User user) {
		User userByName = mapper.getUserByName(user.getUsername());
		return userByName == null;
	}

}
