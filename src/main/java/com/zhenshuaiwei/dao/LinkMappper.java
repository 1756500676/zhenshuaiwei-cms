/**
 * zsw 公司 ZhenShuaiWei_SSM_PROJECT
 * @Title: LinkMappper.java 
 * @Prject: zhenshuaiwei-cms
 * @Package: com.zhenshuaiwei.dao 
 * @Description: TODO
 * @author: zsw  
 * @date: 2019年11月23日 下午6:35:49 
 * @version: V1.0  
 */
package com.zhenshuaiwei.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.zhenshuaiwei.entity.Link;

/** 
 * @ClassName: LinkMappper 
 * @Description: TODO
 * @author:zsw 
 * @date: 2019年11月23日 下午6:35:49  
 */
public interface LinkMappper {

	/** 
	 * @Title: addLink 
	 * @Description: TODO
	 * @param link
	 * @return
	 * @return: int
	 * @date: 2019年11月23日下午6:52:53
	 */
	@Insert("insert into cms_link set url=#{url},name=#{name},created=now()")
	int addLink(Link link);

	/** 
	 * @Title: getLinks 
	 * @Description: TODO
	 * @return: void
	 * @date: 2019年11月23日下午7:11:50
	 */
	@Select("select id,url,name,created from cms_link order by created desc")
	List<Link> getLinks();

	/** 
	 * @Title: deleteLink 
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: int
	 * @date: 2019年11月25日下午8:19:46
	 */
	@Delete("delete from cms_link where id = #{id}")
	int deleteLink(int id);

}
