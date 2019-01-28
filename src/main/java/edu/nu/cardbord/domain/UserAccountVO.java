package edu.nu.cardbord.domain;

import java.util.Date;

import edu.nu.cardbord.common.util.AbstractObject;

/**
 * 用户账户VO类
 * @author distribute
 */
public class UserAccountVO extends AbstractObject {
	
	/**
	 * id
	 */
	private Long id;
	/**
	 *用户名
	 */
	private String username;
	/**
	 * 用户名
	 */
	private String password;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	
}
