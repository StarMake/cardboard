package edu.nu.cardbord.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nu.cardbord.common.util.DateProvider;
import edu.nu.cardbord.dao.PictureCanvasDAO;
import edu.nu.cardbord.domain.PictureCanvasDO;
import edu.nu.cardbord.mapper.PictureCanvasMapper;

@Repository
public class PictureCanvasDAOImpl implements PictureCanvasDAO {

	/**
	 * Canvas画布管理Mapper组件
	 */
	@Autowired
	private PictureCanvasMapper canvasMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 新增一个画布
	 */
	@Override
	public Long save(PictureCanvasDO canvas) throws Exception {
		canvas.setGmtCreate(dateProvider.getCurrentTime());
		canvas.setGmtModified(dateProvider.getCurrentTime());
		canvasMapper.save(canvas);
		return canvas.getId();
	}

	/**
	 * 更新画布信息
	 */
	@Override
	public void update(PictureCanvasDO canvas) throws Exception {
		canvas.setGmtModified(dateProvider.getCurrentTime());
		canvasMapper.update(canvas);
	}

	/**
	 * 根据用户id查询所有的画布
	 */
	@Override
	public List<PictureCanvasDO> listByUserAccountId(
			Long userAccountId) throws Exception {
		return canvasMapper.getByUserAccountId(userAccountId);
	}

	/**
	 * 根据id获取对应的画布
	 */
	@Override
	public PictureCanvasDO getById(Long id) throws Exception {
		return canvasMapper.getById(id);
	}

	/**
	 * 删除画布
	 */
	@Override
	public void remove(Long id) throws Exception {
		canvasMapper.remove(id);
	}

}
