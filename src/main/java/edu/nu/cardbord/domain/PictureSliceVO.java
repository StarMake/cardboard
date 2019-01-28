package edu.nu.cardbord.domain;

import java.util.Date;

import edu.nu.cardbord.common.util.AbstractObject;

/**
 * 线条VO类
 * @author distribute
 */
public class PictureSliceVO extends AbstractObject{

	/**
	 * id
	 */
	private Long id;
	/**
	 * 画布id
	 */
	private Long canvasId;
	/**
	 * slice在画板中的横坐标
	 */
	private Double x;
	/**
	 * slice在画板中的纵坐标
	 */
	private Double y;
	/**
	 * slice的类型，横竖
	 */
	private Integer type;
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
	public Long getCanvasId() {
		return canvasId;
	}
	public void setCanvasId(Long canvasId) {
		this.canvasId = canvasId;
	}
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
