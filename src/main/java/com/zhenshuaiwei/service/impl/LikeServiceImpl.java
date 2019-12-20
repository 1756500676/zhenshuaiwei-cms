/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: LikeServiceImpl.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.service.impl 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月26日 下午1:11:16 
 * @version: V1.0  
 */
package com.zhenshuaiwei.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenshuaiwei.dao.LikeMapper;
import com.zhenshuaiwei.entity.Like;
import com.zhenshuaiwei.service.LikeService;

/** 
 * @ClassName: LikeServiceImpl 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月26日 下午1:11:16  
 */
@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	private LikeMapper likeMapper;
	
	@Override
	public void insertLike(Like like) {
		likeMapper.insertLike(like);
	}

}
