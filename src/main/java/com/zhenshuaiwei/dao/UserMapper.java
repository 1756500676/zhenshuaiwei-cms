/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: UserMapper.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.dao 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月13日 上午11:17:43 
 * @version: V1.0   
 */
package com.zhenshuaiwei.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.zhenshuaiwei.entity.User;

/** 
 * @ClassName: UserMapper 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月13日 上午11:17:43  
 */
public interface UserMapper {

	/** 
	 * @Title: getUserList 
	 * @Description: TODO
	 * @param name
	 * @return: void
	 * @date: 2019年11月13日上午11:22:59
	 */
	List<User> getUserList(String name);

	/** 
	 * @Title: getUserById 
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: User
	 * @date: 2019年11月13日下午2:17:48
	 */
	User getUserById(int id);

	/** 
	 * @Title: updateUserLocked 
	 * @Description: TODO
	 * @param id
	 * @param locked
	 * @return
	 * @return: boolean
	 * @date: 2019年11月13日下午2:27:02
	 */
	@Update("UPDATE cms_user SET locked=${locked} WHERE id =${id}")
	int updateUserLocked(@Param("id")int id, @Param("locked")int locked);

}
