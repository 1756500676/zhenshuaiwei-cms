/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: InsertArticle.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.test 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年12月22日 下午6:19:26 
 * @version: V1.0  
 */
package com.zhenshuaiwei.test;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.alibaba.fastjson.JSON;
import com.zhenshuaiwei.entity.Article;
import com.zhenshuaiwei.entity.Channel;
import com.zhenshuaiwei.service.ChannelService;
import com.zhenshuaiwei.utils.StringUtils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;

/** 
 * @ClassName: InsertArticle 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年12月22日 下午6:19:26  
 */
public class InsertArticle extends BaseTest {
	
	@Autowired
	private KafkaTemplate kafkaTemplate;
	
	@Autowired
	private ChannelService channelService;
	@Test
	public void insertArticle() {
		File file = new File("D:\\tenxun");
		File[] list = file.listFiles();
		for (File file2 : list) {
			Random random = new Random();
			Article article = new Article();
			article.setTitle(file2.getName().split("\\.")[0]);
			String string = FileUtil.readString(file2, "utf-8");
			article.setContent(string);
			List<Channel> channelList = channelService.getChannelList();
			article.setChannelId(String.valueOf(channelList.get(random.nextInt(channelList.size())).getId()));
			article.setHits(StringUtils.getRandomNumber(5));
			article.setHot(String.valueOf(random.nextInt(2)));
			article.setCreated(DateUtil.parseDate("2019-01-01"));
			kafkaTemplate.sendDefault("MYSQLAddArticle="+JSON.toJSONString(article));
		}
	}
}
