package edu.nu.cardbord.service;

import edu.nu.cardbord.domain.PictureSliceDTO;

/**
 * @author distribute
 */
public interface PictureSliceService {

	/**
	 * 新增一个slice
	 */
	PictureSliceDTO save(PictureSliceDTO slice) throws Exception;
	
	/**
	 * 移除一个slice
	 */
	void remove(Long id) throws Exception;
}
