/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: ChanelMapper.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.dao 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月14日 下午1:16:13 
 * @version: V1.0   
 */
package com.zhenshuaiwei.dao;

import java.util.List;

import com.zhenshuaiwei.entity.Category;
import com.zhenshuaiwei.entity.Channel;

/** 
 * @ClassName: ChanelMapper 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月14日 下午1:16:13  
 */
public interface ChannelMapper {

	/** 
	 * @Title: getChannelList 
	 * @Description: TODO
	 * @return: void
	 * @date: 2019年11月14日下午1:23:38
	 */
	public List<Channel> getChannelList();


	
}
