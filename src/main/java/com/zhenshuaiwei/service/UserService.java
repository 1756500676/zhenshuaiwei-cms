/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: UserService.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.service 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月13日 上午11:17:57 
 * @version: V1.0   
 */
package com.zhenshuaiwei.service;

import com.github.pagehelper.PageInfo;
import com.zhenshuaiwei.entity.User;

/** 
 * @ClassName: UserService 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月13日 上午11:17:57  
 */
public interface UserService {

	/** 
	 * @Title: getUserList 
	 * @Description: 获取用户集合
	 * @param name
	 * @param page
	 * @return: void
	 * @date: 2019年11月13日上午11:21:04
	 */
	PageInfo<User> getUserList(String name, String page);

	/** 
	 * @Title: geteUserById 
	 * @Description: 根据id查找用户
	 * @param id
	 * @return: void
	 * @date: 2019年11月13日下午2:16:56
	 */
	User geteUserById(int id);

	/** 
	 * @Title: updateUserLocked 
	 * @Description: TODO
	 * @param id
	 * @param locked
	 * @return: void
	 * @date: 2019年11月13日下午2:24:25
	 */
	boolean updateUserLocked(int id, int locked);

}
