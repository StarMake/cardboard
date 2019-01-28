package edu.nu.cardbord.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nu.cardbord.common.util.DateProvider;
import edu.nu.cardbord.dao.PictureSliceDAO;
import edu.nu.cardbord.domain.PictureSliceDO;
import edu.nu.cardbord.mapper.PictureSliceMapper;

@Repository
public class PictureSliceDAOImpl implements PictureSliceDAO {

	/**
	 * Slice的管理Mapper组件
	 */
	@Autowired
	private PictureSliceMapper sliceMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 新增一个slice
	 */
	@Override
	public Long save(PictureSliceDO slice) throws Exception {
		slice.setGmtCreate(dateProvider.getCurrentTime());
		slice.setGmtModified(dateProvider.getCurrentTime());
		sliceMapper.save(slice);
		return slice.getId();
	}

	/**
	 * 更新slice的位置
	 */
	@Override
	public void updatePosition(PictureSliceDO slice) throws Exception {
		slice.setGmtModified(dateProvider.getCurrentTime());
		sliceMapper.updatePosition(slice);
	}

	/**
	 * 查询指定画板上的slice
	 */
	@Override
	public List<PictureSliceDO> listByPictureCanvasId(Long canvasId) throws Exception {
		return sliceMapper.listByPictureCanvasId(canvasId);
	}

	/**
	 * 删除slice
	 */
	@Override
	public void remove(Long id) throws Exception {
		sliceMapper.remove(id);
	}

	/**
	 * 删除指定的画板的所有分割符
	 */
	@Override
	public void removeAllByCanvasId(Long canvasId) throws Exception {
		sliceMapper.removeAllByCanvasId(canvasId);
	}

}
