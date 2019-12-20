/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: Reply.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.entity 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月26日 上午8:59:59 
 * @version: V1.0  
 */
package com.zhenshuaiwei.entity;

import java.io.Serializable;
import java.util.Date;

/** 
 * @ClassName: Reply 
 * @Description: 恢复类
 * @author:zsw 
 * @date: 2019年11月26日 上午8:59:59  
 */
public class Reply implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 4520826878063765494L;

	private Integer id;
	
	//column comment_id
	private int commentId;
	
	//column reply_id
	private int replyId;
	
	private int replyType;
	
	private String content;
	//column from_userid;
	private int fromUserId;
	private User fromUser;
	
	//column to_userid
	private int toUserId;
	private User toUser;
	
	private Date created;
	private String descDate;

	
	
	public int getReplyType() {
		return replyType;
	}

	public void setReplyType(int replyType) {
		this.replyType = replyType;
	}

	public String getDescDate() {
		return descDate;
	}

	public void setDescDate(String descDate) {
		this.descDate = descDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(int fromUserId) {
		this.fromUserId = fromUserId;
	}

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public int getToUserId() {
		return toUserId;
	}

	public void setToUserId(int toUserId) {
		this.toUserId = toUserId;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}


	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Reply [id=" + id + ", commentId=" + commentId + ", replyId=" + replyId + ", content=" + content
				+ ", fromUserId=" + fromUserId + ", fromUser=" + fromUser + ", toUserId=" + toUserId + ", toUser="
				+ toUser + ", created=" + created + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + replyId;
		result = prime * result + ((toUser == null) ? 0 : toUser.hashCode());
		result = prime * result + toUserId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reply other = (Reply) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (replyId != other.replyId)
			return false;
		if (toUser == null) {
			if (other.toUser != null)
				return false;
		} else if (!toUser.equals(other.toUser))
			return false;
		if (toUserId != other.toUserId)
			return false;
		return true;
	}
	

	
	
}
