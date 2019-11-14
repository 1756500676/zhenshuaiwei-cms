/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: CategoryService.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.service.impl 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月14日 下午7:44:15 
 * @version: V1.0   
 */
package com.zhenshuaiwei.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenshuaiwei.dao.CategoryMapper;
import com.zhenshuaiwei.entity.Category;
import com.zhenshuaiwei.service.CategoryService;

/** 
 * @ClassName: CategoryService 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月14日 下午7:44:15  
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryMapper mapper;

	@Override
	public List<Category> getCateListByChannelId(int chId) {
		return mapper.getCateListByChannelId(chId);
	}

}
