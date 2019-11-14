/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: CategoryMappper.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.dao 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月14日 下午7:45:49 
 * @version: V1.0   
 */
package com.zhenshuaiwei.dao;

import java.util.List;

import com.zhenshuaiwei.entity.Category;

/** 
 * @ClassName: CategoryMappper 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月14日 下午7:45:49  
 */
public interface CategoryMapper {

	/** 
	 * @Title: getCateListByChannelId 
	 * @Description: TODO
	 * @param chId
	 * @return: void
	 * @date: 2019年11月14日下午7:45:59
	 */
	List<Category> getCateListByChannelId(int chId);

}
