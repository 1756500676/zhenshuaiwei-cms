/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: ChanelService.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.service 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月14日 下午1:14:44 
 * @version: V1.0   
 */
package com.zhenshuaiwei.service;

import java.util.List;

import com.zhenshuaiwei.entity.Channel;

/** 
 * @ClassName: ChanelService 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月14日 下午1:14:44  
 */
public interface ChannelService {

	/** 
	 * @Title: getChannelList 
	 * @Description: TODO
	 * @return: void
	 * @date: 2019年11月14日下午1:22:56
	 */
	List<Channel> getChannelList();

}
