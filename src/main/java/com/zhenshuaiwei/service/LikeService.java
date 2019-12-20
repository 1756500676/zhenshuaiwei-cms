/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: LikeService.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.dao 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月26日 下午1:10:42 
 * @version: V1.0  
 */
package com.zhenshuaiwei.service;

import com.zhenshuaiwei.entity.Like;

/** 
 * @ClassName: LikeService 
 * @Description: 点赞
 * @author:zsw 
 * @date: 2019年11月26日 下午1:10:42  
 */
public interface LikeService {

	/** 
	 * @Title: likeArticle 
	 * @Description: TODO
	 * @param id
	 * @param id2
	 * @return: void
	 * @date: 2019年11月26日下午1:12:31
	 */
	void insertLike(Like like);

}
