package edu.nu.cardbord.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.nu.cardbord.domain.PictureCardDTO;
import edu.nu.cardbord.domain.PictureCardVO;
import edu.nu.cardbord.service.PictureCardService;

/**
 * 卡片Controller组件
 */
@RestController
@RequestMapping("/card")
public class PictureCardController {

	private static final Logger logger = LoggerFactory
			.getLogger(PictureCardController.class);
	
	/**
	 * 卡片管理组件
	 */
	@Autowired
	private PictureCardService cardService;
	
	/**
	 * 创建一个卡片
	 */
	@PostMapping("/")
	public Long save(@RequestBody PictureCardVO card) {
		try {
			return cardService.save(card.clone(PictureCardDTO.class));
		} catch (Exception e) {
			logger.error("error", e);
			return -1L;
		}
	}
	
	/**
	 * 删除卡片
	 */
	@DeleteMapping("/{id}")
	public Boolean remove(@PathVariable("id") Long id) {
		try {
			cardService.remove(id);
			return true;
		} catch (Exception e) {
			logger.error("error", e);
			return false;
		}
	}
	
	/**
	 * 更新card信息
	 */
	@PutMapping("/{id}")
	public Boolean updateInfo(@RequestBody PictureCardVO card) {
		try {
			cardService.updateInfo(card.clone(PictureCardDTO.class));
			return true;
		} catch (Exception e) {
			logger.error("error", e);
			return false;
		}
	}
	
}
