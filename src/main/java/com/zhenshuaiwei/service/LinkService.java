/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: LinkService.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.service 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月23日 下午6:34:44 
 * @version: V1.0  
 */
package com.zhenshuaiwei.service;

import com.github.pagehelper.PageInfo;
import com.zhenshuaiwei.entity.Link;

/** 
 * @ClassName: LinkService 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月23日 下午6:34:44  
 */
public interface LinkService {

	/** 
	 * @Title: addLink 
	 * @Description: TODO
	 * @param link
	 * @return: void
	 * @date: 2019年11月23日下午6:52:25
	 */
	int addLink(Link link);

	/** 
	 * @Title: getLinks 
	 * @Description: TODO
	 * @param page
	 * @return: void
	 * @date: 2019年11月23日下午7:11:03
	 */
	PageInfo<Link> getLinks(int page);

	/** 
	 * @Title: deleteLink 
	 * @Description: 删除友情链接
	 * @param id
	 * @return: void
	 * @date: 2019年11月25日下午8:19:05
	 */
	int deleteLink(int id);

	/** 
	 * @Title: myFavorite 
	 * @Description: TODO
	 * @param page
	 * @param id
	 * @return
	 * @return: PageInfo<Link>
	 * @date: 2019年11月27日上午9:09:44
	 */
	PageInfo<Link> myFavorite(int page, Integer id);

}
