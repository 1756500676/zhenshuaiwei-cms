/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: Link.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.entity 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月23日 下午6:17:41 
 * @version: V1.0  
 */
package com.zhenshuaiwei.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

/** 
 * @ClassName: Link 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月23日 下午6:17:41  
 */
public class Link implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 6767027834726433812L;
	private Integer id;
	@NotBlank(message = "不可为空")
	@URL(message = "url格式不符合")
	private String url;
	@NotBlank(message = "不可为空")
	@Length(min = 2,max = 10,message = "长度不符合")
	private String name;
	private Date created;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Link(Integer id, String url, String name, Date created) {
		super();
		this.id = id;
		this.url = url;
		this.name = name;
		this.created = created;
	}
	public Link() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Link [id=" + id + ", url=" + url + ", name=" + name + ", created=" + created + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Link other = (Link) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	
	
	
	

}
