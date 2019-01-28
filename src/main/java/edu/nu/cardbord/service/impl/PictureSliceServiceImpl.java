package edu.nu.cardbord.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.nu.cardbord.dao.PictureSliceDAO;
import edu.nu.cardbord.domain.PictureSliceDO;
import edu.nu.cardbord.domain.PictureSliceDTO;
import edu.nu.cardbord.service.PictureSliceService;

/**
 * 分割线Service组件
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PictureSliceServiceImpl implements PictureSliceService {

	/**
	 * 分割线管理DAO组件
	 */
	@Autowired
	private PictureSliceDAO sliceDAO;
	
	/**
	 * 新增一个slice
	 */
	@Override
	public Long save(PictureSliceDTO slice) throws Exception {
		return sliceDAO.save(slice.clone(PictureSliceDO.class));
	}

	/**
	 * 移除一个slice
	 */
	@Override
	public void remove(Long id) throws Exception {
		sliceDAO.remove(id);
	}
	
}
