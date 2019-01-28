package edu.nu.cardbord.domain;

import java.util.Date;

import edu.nu.cardbord.common.util.AbstractObject;

/**
 * 卡片DO类
 * @author distribute
 */
public class PictureCardDO extends AbstractObject {

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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((canvasId == null) ? 0 : canvasId.hashCode());
		result = prime * result + ((cardContent == null) ? 0 : cardContent.hashCode());
		result = prime * result + ((cardName == null) ? 0 : cardName.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
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
		PictureCardDO other = (PictureCardDO) obj;
		if (canvasId == null) {
			if (other.canvasId != null)
				return false;
		} else if (!canvasId.equals(other.canvasId))
			return false;
		if (cardContent == null) {
			if (other.cardContent != null)
				return false;
		} else if (!cardContent.equals(other.cardContent))
			return false;
		if (cardName == null) {
			if (other.cardName != null)
				return false;
		} else if (!cardName.equals(other.cardName))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (gmtCreate == null) {
			if (other.gmtCreate != null)
				return false;
		} else if (!gmtCreate.equals(other.gmtCreate))
			return false;
		if (gmtModified == null) {
			if (other.gmtModified != null)
				return false;
		} else if (!gmtModified.equals(other.gmtModified))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}
	
}
