package edu.nu.cardbord.dao;

import java.util.List;


import edu.nu.cardbord.domain.PictureCardDO;

/**
 * Card管理DAO组件接口
 * @author distribute
 */
public interface PictureCardDAO {

	/**
	 * 新增一个card
	 */
	Long save(PictureCardDO card) throws Exception;
	
	/**
	 * 更新卡片
	 */
	void update(PictureCardDO card) throws Exception;
	
	/**
	 * 更新card的位置信息
	 */
	void updatePosition(PictureCardDO card) throws Exception;
	
	/**
	 * 更新card的内容信息
	 */
	void updateInfo(PictureCardDO card) throws Exception;
	
	/**
	 * 查询指定画板上的card
	 */
	List<PictureCardDO> listByPictureCanvasId(Long canvasId) throws Exception;

	/**
	 * 获取对应的id
	 */
	PictureCardDO getById(Long id) throws Exception;
	
	/**
	 * 删除卡片
	 */
	void remove(Long id) throws Exception;
	
	/**
	 * 删除指定画板上的所有card
	 */
	void removeAllByCanvasId(Long canvasId) throws Exception;
}
