package edu.nu.cardbord.domain;

import java.util.Date;

import edu.nu.cardbord.common.util.AbstractObject;

/**
 * 画板DO类
 * @author distribute
 */
public class PictureCanvasDO extends AbstractObject {
	
	/**
	 * id
	 */
	private Long id;
	/**
	 * 用户id
	 */
	private Long userAccountId;
	/**
	 * 画板的名字
	 */
	private String canvasName;
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
	public Long getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}
	public String getCanvasName() {
		return canvasName;
	}
	public void setCanvasName(String canvasName) {
		this.canvasName = canvasName;
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
	
	@Override
	public String toString() {
		return "PictureCanvasDO [id=" + id + ", userAccountId=" + userAccountId + ", canvasName=" + canvasName
				+ ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
}
