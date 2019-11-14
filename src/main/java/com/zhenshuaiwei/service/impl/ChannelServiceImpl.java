/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: ChanelServiceImpl.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.service.impl 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月14日 下午1:15:40 
 * @version: V1.0   
 */
package com.zhenshuaiwei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenshuaiwei.dao.ChannelMapper;
import com.zhenshuaiwei.entity.Category;
import com.zhenshuaiwei.entity.Channel;
import com.zhenshuaiwei.service.ChannelService;

/** 
 * @ClassName: ChanelServiceImpl 
 * @Description:频道接口
 * @author:zsw 
 * @date: 2019年11月14日 下午1:15:40  
 */
@Service
public class ChannelServiceImpl implements ChannelService{
	
	@Autowired
	private ChannelMapper mapper;

	@Override
	public List<Channel> getChannelList() {
		return mapper.getChannelList();
	}

	
	

}
