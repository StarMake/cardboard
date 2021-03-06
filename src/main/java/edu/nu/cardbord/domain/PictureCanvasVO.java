package edu.nu.cardbord.domain;

import java.util.Date;
import java.util.List;

import edu.nu.cardbord.common.util.AbstractObject;

/**
 * 画板VO类
 * @author distribute
 */
public class PictureCanvasVO extends AbstractObject {
	
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
	 * 画板拥有的cards
	 */
	private List<PictureCardVO> cards;
	/**
	 * 画板拥有的characters
	 */
	private List<PictureCharacterVO> characters;
	/**
	 * 画板拥有的slices
	 */
	private List<PictureSliceVO> slices;
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
	public List<PictureCardVO> getCards() {
		return cards;
	}
	public void setCards(List<PictureCardVO> cards) {
		this.cards = cards;
	}
	public List<PictureCharacterVO> getCharacters() {
		return characters;
	}
	public void setCharacters(List<PictureCharacterVO> characters) {
		this.characters = characters;
	}
	public List<PictureSliceVO> getSlices() {
		return slices;
	}
	public void setSlices(List<PictureSliceVO> slices) {
		this.slices = slices;
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
