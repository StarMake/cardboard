package edu.nu.cardbord.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.nu.cardbord.domain.PictureSliceDTO;
import edu.nu.cardbord.domain.PictureSliceVO;
import edu.nu.cardbord.service.PictureSliceService;

/**
 * @author distribute
 */
@RestController
@RequestMapping("/slice")
public class PictureSliceController {

	private static final Logger logger = LoggerFactory
			.getLogger(PictureSliceController.class);
	
	/**
	 * slice管理组件
	 */
	@Autowired
	private PictureSliceService sliceService;
	
	/**
	 * 创建一个slice
	 */
	@PostMapping("/")
	public PictureSliceVO save(@RequestBody PictureSliceVO slice) {
		try {
			return sliceService.save(slice.clone(PictureSliceDTO.class)).clone(PictureSliceVO.class);
		} catch (Exception e) {
			logger.error("error", e);
			return new PictureSliceVO();
		}
	}
	
	/**
	 * 删除一个slice
	 */
	@DeleteMapping("/{id}")
	public Boolean remove(@PathVariable("id") Long id) {
		try {
			sliceService.remove(id);
			return true;
		} catch (Exception e) {
			logger.error("error", e);
			return false;
		}
	}
	
}
