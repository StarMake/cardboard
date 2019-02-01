package edu.nu.cardbord.dao;

import java.util.List;

import edu.nu.cardbord.domain.PictureSliceDO;

/**
 * @author distribute
 */
public interface PictureSliceDAO {

	/**
	 * 新增一个slice
	 */
	PictureSliceDO save(PictureSliceDO slice) throws Exception;
	
	/**
	 * 更新slice的位置
	 */
	void updatePosition(PictureSliceDO slice) throws Exception;
	
	/**
	 * 查询指定画板上的slice
	 */
	List<PictureSliceDO> listByPictureCanvasId(Long canvasId) throws Exception;
	
	/**
	 * 删除slice
	 */
	void remove(Long id) throws Exception;
	
	/**
	 * 删除指定画板上的所有分割线
	 */
	void removeAllByCanvasId(Long canvasId) throws Exception;
}
