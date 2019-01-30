package edu.nu.cardbord.service;


import org.apache.ibatis.annotations.Param;

import edu.nu.cardbord.domain.PictureCanvasDTO;

/**
 * @author distribute
 */
public interface PictureCanvasService {
	
	/**
	 * 根据id获取对应的画布
	 */
	PictureCanvasDTO getById(@Param("id") Long id) throws Exception;
	
	/**
	 * 创建一个新的画布
	 */
	Long save(PictureCanvasDTO canvas) throws Exception;
	
	/**
	 * 更新一个画布信息
	 */
	void updateInfo(PictureCanvasDTO canvas) throws Exception;
	
	/**
	 * 更新各个组件的位置
	 */
	void updatePosition(PictureCanvasDTO canvas) throws Exception;
	
	/**
	 * 删除指定的id的画板
	 */
	void remove(Long id) throws Exception;
}
