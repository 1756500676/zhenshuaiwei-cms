/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: DateTest.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.test 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月22日 上午9:11:32 
 * @version: V1.0  
 */
package com.zhenshuaiwei.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.zhenshuaiwei.dateutils.DateDesc;
import com.zhenshuaiwei.entity.Comment;
import com.zhenshuaiwei.service.CommentService;

/** 
 * @ClassName: DateTest 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月22日 上午9:11:32  
 */
public class DateTest extends BaseTest{
	@Autowired
	CommentService service;
	
	@Test
	public void tete() {
		PageInfo<Comment> myComment = service.getMyComment(1, 54);
		List<Comment> commentList= myComment.getList();
		commentList.forEach(comment -> {
			System.out.println(comment);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:m:s");
			Date date = null;
			try {
				date = format.parse(comment.getDateDesc());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			comment.setDateDesc(DateDesc.format(date));
		});
		
	}

}
