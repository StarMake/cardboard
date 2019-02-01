package edu.nu.cardbord.service;

import edu.nu.cardbord.domain.PictureCardDTO;

/**
 * @author distribute
 */
public interface PictureCardService {

	/**
	 * 新建一个card
	 */
	PictureCardDTO save(PictureCardDTO card) throws Exception;
	
	/**
	 * 删除指定的card
	 */
	void remove(Long id) throws Exception;
	
	/**
	 * 更新card内容信息
	 */
	void updateInfo(PictureCardDTO card) throws Exception;
}
