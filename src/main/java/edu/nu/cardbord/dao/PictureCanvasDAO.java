package edu.nu.cardbord.dao;

import java.util.List;

import edu.nu.cardbord.domain.PictureCanvasDO;

/**
 * 画布管理DAO组件
 * @author distribute
 */
public interface PictureCanvasDAO {

	/**
	 * 新增一个画布
	 */
	void save(PictureCanvasDO canvas) throws Exception;
	
	/**
	 * 更新画布信息
	 */
	void update(PictureCanvasDO canvas) throws Exception;
	
	/**
	 * 根据用户id查询所有的画布
	 */
	List<PictureCanvasDO> listByUserAccountId(
			Long userAccountId) throws Exception;
	
	/**
	 * 根据id获取对应的画布
	 */
	PictureCanvasDO getById(Long id) throws Exception;
	
	/**
	 * 删除画布
	 */
	void remove(Long id) throws Exception;
}
