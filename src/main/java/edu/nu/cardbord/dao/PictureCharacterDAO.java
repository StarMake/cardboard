package edu.nu.cardbord.dao;

import java.util.List;


import edu.nu.cardbord.domain.PictureCharacterDO;

public interface PictureCharacterDAO {

	/**
	 * 新增一个character
	 */
	PictureCharacterDO save(PictureCharacterDO character) throws Exception;
	
	/**
	 * 查询指定画板上的character
	 */
	List<PictureCharacterDO> listByPictureCanvasId(Long canvasId) throws Exception;
	
	/**
	 * 根据id获取对应的文本框
	 */
	PictureCharacterDO getById(Long id) throws Exception;
	
	/**
	 * 更新文本框
	 */
	void update(PictureCharacterDO character) throws Exception;
	
	/**
	 * 更新位置
	 */
	void updatePosition(PictureCharacterDO character) throws Exception;
	
	/**
	 * 更新内容信息
	 */
	void updateInfo(PictureCharacterDO character) throws Exception;
	
	/**
	 * 删除文本框
	 */
	void remove(Long id) throws Exception;
	
	/**
	 * 删除指定画板上的所有文本框
	 */
	void removeAllByCanvasId(Long canvasId) throws Exception;
}
