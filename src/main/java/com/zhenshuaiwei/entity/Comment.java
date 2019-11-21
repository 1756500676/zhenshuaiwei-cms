/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: Comment.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.entity 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月21日 上午9:40:29 
 * @version: V1.0  
 */
package com.zhenshuaiwei.entity;

import java.io.Serializable;
import java.sql.Date;

/** 
 * @ClassName: Comment 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月21日 上午9:40:29  
 */
public class Comment implements Serializable{
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -4487055255870683228L;
	private Integer id;
	private int articleId;
	private Article article;
	private int userId;
	private User user;
	private String content;
	private int likeNum;
	private Date created;
	
	
	
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", articleId=" + articleId + ", article=" + article + ", userId=" + userId
				+ ", user=" + user + ", content=" + content + ", likeNum=" + likeNum + ", created=" + created + "]";
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(Integer id, int articleId, Article article, int userId, User user, String content, int likeNum,
			Date created) {
		super();
		this.id = id;
		this.articleId = articleId;
		this.article = article;
		this.userId = userId;
		this.user = user;
		this.content = content;
		this.likeNum = likeNum;
		this.created = created;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + articleId;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + userId;
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
		Comment other = (Comment) obj;
		if (articleId != other.articleId)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	

}
