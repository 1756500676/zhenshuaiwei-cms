/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: CategoryService.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.service 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月14日 下午7:43:59 
 * @version: V1.0   
 */
package com.zhenshuaiwei.service;

import java.util.List;

import com.zhenshuaiwei.entity.Category;

/** 
 * @ClassName: CategoryService 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月14日 下午7:43:59  
 */
public interface CategoryService {

	/** 
	 * @Title: getCateListByChannelId 
	 * @Description: TODO
	 * @param chId
	 * @return: void
	 * @date: 2019年11月14日下午7:44:43
	 */
	List<Category> getCateListByChannelId(int chId);

}
