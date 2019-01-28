package edu.nu.cardbord.domain;

import java.util.Date;

import edu.nu.cardbord.common.util.AbstractObject;

/**
 * 卡片DTO类
 * @author distribute
 */
public class PictureCardDTO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 画布id
	 */
	private Long canvasId;
	/**
	 * car所在的横坐标
	 */
	private Double x;
	/**
	 * card所在的纵坐标
	 */
	private Double y;
	/**
	 * card的名称
	 */
	private String cardName;
	/**
	 * card的具体描述
	 */
	private String cardContent;
	/**
	 * card的颜色
	 */
	private Integer color;
	/**
	 * card所处的状态
	 */
	private Integer status;
	/**
	 * card创建时间
	 */
	private Date gmtCreate;
	/**
	 * card的修改时间
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
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardContent() {
		return cardContent;
	}
	public void setCardContent(String cardContent) {
		this.cardContent = cardContent;
	}
	public Integer getColor() {
		return color;
	}
	public void setColor(Integer color) {
		this.color = color;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
