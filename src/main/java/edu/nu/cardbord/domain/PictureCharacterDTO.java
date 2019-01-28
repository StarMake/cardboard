package edu.nu.cardbord.domain;

import java.util.Date;

import edu.nu.cardbord.common.util.AbstractObject;

/**
 * 文字DTO类
 * @author distribute
 */
public class PictureCharacterDTO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 画板id
	 */
	private Long canvasId;
	/**
	 * 在画板中的横坐标
	 */
	private Double x;
	/**
	 * 在画板中的纵坐标
	 */
	private Double y;
	/**
	 * 文字内容
	 */
	private String content;
	/**
	 * 字体颜色的R值
	 */
	private Integer fontColorR;
	/**
	 * 字体颜色的G值
	 */
	private Integer fontColorG;
	/**
	 * 字体颜色的B值
	 */
	private Integer fontColorB;
	/**
	 * 字体的大小
	 */
	private Integer fontSize;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getFontColorR() {
		return fontColorR;
	}
	public void setFontColorR(Integer fontColorR) {
		this.fontColorR = fontColorR;
	}
	public Integer getFontColorG() {
		return fontColorG;
	}
	public void setFontColorG(Integer fontColorG) {
		this.fontColorG = fontColorG;
	}
	public Integer getFontColorB() {
		return fontColorB;
	}
	public void setFontColorB(Integer fontColorB) {
		this.fontColorB = fontColorB;
	}
	public Integer getFontSize() {
		return fontSize;
	}
	public void setFontSize(Integer fontSize) {
		this.fontSize = fontSize;
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
