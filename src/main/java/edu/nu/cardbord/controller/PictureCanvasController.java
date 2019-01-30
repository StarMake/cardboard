package edu.nu.cardbord.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.nu.cardbord.common.util.CloneDirection;
import edu.nu.cardbord.domain.PictureCanvasDTO;
import edu.nu.cardbord.domain.PictureCanvasVO;
import edu.nu.cardbord.service.PictureCanvasService;

/**
 * @author distribute
 */
@RestController
@RequestMapping("/canvas")
public class PictureCanvasController {

	private static final Logger logger = LoggerFactory.getLogger(
			PictureCanvasController.class);
	
	/**
	 * 画板Service组件
	 */
	@Autowired
	private PictureCanvasService canvasService;
	
	/**
	 * 获取指定的画板
	 */
	@GetMapping("/{id}")
	public PictureCanvasVO getById(@PathVariable("id") Long id) {
		try {
			return canvasService.getById(id).clone(
					PictureCanvasVO.class, 
					CloneDirection.OPPOSITE);
		} catch (Exception e) {
			logger.error("error");
			return new PictureCanvasVO();
		}
	}
	
	/**
	 * 新建一个canvas
	 */
	@PostMapping("/")
	public Long save(@RequestBody PictureCanvasVO canvas) {
		try {
			return canvasService.save(canvas.clone(PictureCanvasDTO.class));
		} catch (Exception e) {
			logger.error("error", e);
			return null;
		}
	}
	
	/**
	 * 删除指定id的
	 */
	@DeleteMapping("/{id}")
	public Boolean remove(@PathVariable("id") Long id) {
		try {
			canvasService.remove(id);
			return true;
		} catch (Exception e) {
			logger.error("error");
			return false;
		}
	}
	
	/**
	 * 更新画板中组件的所有位置信息
	 */
	@PutMapping("/position/{id}")
	public Boolean updatePosition(@RequestBody PictureCanvasVO canvas) {
		try {
			canvasService.updatePosition(canvas.clone(PictureCanvasDTO.class, 
					CloneDirection.FORWARD));
			return true;
		} catch (Exception e) {
			logger.error("error", e);
			return false;
		}
	}
	
	/**
	 * 更新画板的内容信息
	 */
	@PutMapping("/info/{id}")
	public Boolean updateInfo(@RequestBody PictureCanvasVO canvas) {
		try {
			canvasService.updateInfo(canvas.clone(PictureCanvasDTO.class));
			return true;
		} catch (Exception e) {
			logger.error("error", e);
			return false;
		}
	}
	
}
