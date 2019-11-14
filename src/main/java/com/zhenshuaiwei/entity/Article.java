/**  
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: Article.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.entity 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月14日 下午1:32:38 
 * @version: V1.0   
 */
package com.zhenshuaiwei.entity;

import java.io.Serializable;
import java.sql.Date;

/** 
 * @ClassName: Article 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月14日 下午1:32:38  
 */
public class Article implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 6927479125403981315L;
	private Integer id;
	// 文章标题
	private String title;
	// 文章内容
	private String content;
	//标题图片的url 地址
	private String picture;
	// 频道
	private String channelId;
	private Channel channel;
	
	//频道下的分类
	private String categoryId;
	private Category category;
	
	//用户
	private String userId;
	private User user;
	
	//点击数
	private String hits;
	//是否热门
	private String hot;
//	是否审核
	private String status;
//	是否被删除
	private String deleted;
	//发表时间
	private Date created;
//	最后修改时间
	private Date updated;
//	评论的数量
	private int commentCnt;
//	文章类型
	private int articleType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getHits() {
		return hits;
	}
	public void setHits(String hits) {
		this.hits = hits;
	}
	public String getHot() {
		return hot;
	}
	public void setHot(String hot) {
		this.hot = hot;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public int getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	public int getArticleType() {
		return articleType;
	}
	public void setArticleType(int articleType) {
		this.articleType = articleType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/** 
	 * @Title:Article
	 * @Description:TODO 
	 * @param id
	 * @param title
	 * @param content
	 * @param picture
	 * @param channelId
	 * @param channel
	 * @param categoryId
	 * @param category
	 * @param userId
	 * @param user
	 * @param hits
	 * @param hot
	 * @param status
	 * @param deleted
	 * @param created
	 * @param updated
	 * @param commentCnt
	 * @param articleType 
	 */
	public Article(Integer id, String title, String content, String picture, String channelId, Channel channel,
			String categoryId, Category category, String userId, User user, String hits, String hot, String status,
			String deleted, Date created, Date updated, int commentCnt, int articleType) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.picture = picture;
		this.channelId = channelId;
		this.channel = channel;
		this.categoryId = categoryId;
		this.category = category;
		this.userId = userId;
		this.user = user;
		this.hits = hits;
		this.hot = hot;
		this.status = status;
		this.deleted = deleted;
		this.created = created;
		this.updated = updated;
		this.commentCnt = commentCnt;
		this.articleType = articleType;
	}
	/** 
	 * @Title:Article
	 * @Description:TODO  
	 */
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content + ", picture=" + picture
				+ ", channelId=" + channelId + ", channel=" + channel + ", categoryId=" + categoryId + ", category="
				+ category + ", userId=" + userId + ", user=" + user + ", hits=" + hits + ", hot=" + hot + ", status="
				+ status + ", deleted=" + deleted + ", created=" + created + ", updated=" + updated + ", commentCnt="
				+ commentCnt + ", articleType=" + articleType + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channelId == null) ? 0 : channelId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Article other = (Article) obj;
		if (channelId == null) {
			if (other.channelId != null)
				return false;
		} else if (!channelId.equals(other.channelId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	
	
}
