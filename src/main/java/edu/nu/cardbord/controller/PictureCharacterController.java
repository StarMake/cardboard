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

import edu.nu.cardbord.domain.PictureCharacterDTO;
import edu.nu.cardbord.domain.PictureCharacterVO;
import edu.nu.cardbord.service.PictureCharacterService;

@RestController
@RequestMapping("/character")
public class PictureCharacterController {

	private static final Logger logger = LoggerFactory
			.getLogger(PictureCharacterController.class);
	
	@Autowired
	private PictureCharacterService characterService;
	
	/**
	 * 创建一个文本框
	 */
	@PostMapping("/")
	public PictureCharacterVO save(@RequestBody PictureCharacterVO character) {
		try {
			return characterService.save(character.clone(PictureCharacterDTO.class))
					.clone(PictureCharacterVO.class);
		} catch (Exception e) {
			logger.error("error", e);
			return new PictureCharacterVO();
		}
	}
	
	/**
	 * 删除卡片
	 */
	@DeleteMapping("/{id}")
	public Boolean remove(@PathVariable("id") Long id) {
		try {
			characterService.remove(id);
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
	public Boolean updateInfo(@RequestBody PictureCharacterVO character) {
		try {
			characterService.updateInfo(character.clone(PictureCharacterDTO.class));
			return true;
		} catch (Exception e) {
			logger.error("error", e);
			return false;
		}
	}
	
}
