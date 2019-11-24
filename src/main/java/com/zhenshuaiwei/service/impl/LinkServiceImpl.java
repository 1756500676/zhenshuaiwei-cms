/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: LinkServiceImpl.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.service.impl 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月23日 下午6:35:03 
 * @version: V1.0  
 */
package com.zhenshuaiwei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhenshuaiwei.dao.LinkMappper;
import com.zhenshuaiwei.entity.Link;
import com.zhenshuaiwei.service.LinkService;

/** 
 * @ClassName: LinkServiceImpl 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月23日 下午6:35:03  
 */
@Service
public class LinkServiceImpl implements LinkService {

	@Autowired
	private LinkMappper linkMapper;

	@Override
	public int addLink(Link link) {
		return linkMapper.addLink(link);
	}

	@Override
	public PageInfo<Link> getLinks(int page) {
		PageHelper.startPage(page, 10);
		List<Link> list = linkMapper.getLinks();
		return new PageInfo<Link>(list);
	}
	
	
}
