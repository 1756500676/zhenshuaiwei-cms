/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: ReplyMapper.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.dao 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月26日 上午9:12:03 
 * @version: V1.0  
 */
package com.zhenshuaiwei.dao;

import com.zhenshuaiwei.entity.Reply;

/** 
 * @ClassName: ReplyMapper 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月26日 上午9:12:03  
 */
public interface ReplyMapper {

	/** 
	 * @Title: pushReply 
	 * @Description: 发表回复
	 * @param reply
	 * @return: void
	 * @date: 2019年11月26日上午9:12:17
	 */
	void pushReply(Reply reply);

	/** 
	 * @Title: getReplayById 
	 * @Description: TODO
	 * @param replyId
	 * @return: void
	 * @date: 2019年12月18日下午2:29:35
	 */
	Reply getReplayById(int replyId);

}
