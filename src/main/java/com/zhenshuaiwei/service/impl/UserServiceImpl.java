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
import com.zhenshuaiwei.common.ConstantClass;
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

}
