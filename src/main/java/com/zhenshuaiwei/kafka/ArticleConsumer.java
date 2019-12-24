/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: kafka.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年12月11日 上午11:18:42 
 * @version: V1.0  
 */
package com.zhenshuaiwei.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.listener.MessageListener;

import com.alibaba.fastjson.JSON;
import com.zhenshuaiwei.dao.ArticleMapper;
import com.zhenshuaiwei.dao.ArticleRepository;
import com.zhenshuaiwei.entity.Article;

/** 
 * @ClassName: kafka 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年12月11日 上午11:18:42  
 */
public class ArticleConsumer implements MessageListener<String, String>{

	@Autowired
	private ArticleMapper articelMapper;
	
	@Autowired
	private RedisTemplate redisTemplate; 
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
		String message  = data.value();
		if (message.startsWith("update")) {
			System.err.println(message);
//			删除redis数据重新从mysql查询,保持数据更新
			redisTemplate.delete("hotList");
//			修改es的数据
			String messageValue = message.split("=")[1];
			articleRepository.save(JSON.parseObject(messageValue,Article.class));
		}else if(message.startsWith("delete")) {
			System.err.println(message);
			String messageValue = message.split("=")[1];
			redisTemplate.delete("hotList");
			articleRepository.deleteById(Integer.parseInt(messageValue));
		}else if (message.startsWith("insert")) {
			System.err.println(message);
			redisTemplate.delete("hotList");
//			存在bug文章未审核可直接搜索到
			String messageValue = message.split("=")[1];
			articleRepository.save(JSON.parseObject(messageValue,Article.class));
		}else if (message.startsWith("MYSQLAddArticle")){
			String messageValue = message.split("=")[1];
			Article article = JSON.parseObject(messageValue,Article.class);
			articelMapper.addArticle(article);
		}else {
			Article article = JSON.parseObject(message, Article.class);
			articelMapper.addArticle(article);
			System.err.println("收到添加");
		}
	}
	
	
	
}
