package edu.nu.cardbord.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.nu.cardbord.common.util.ObjectUtils;
import edu.nu.cardbord.dao.PictureCanvasDAO;
import edu.nu.cardbord.dao.PictureCardDAO;
import edu.nu.cardbord.dao.PictureCharacterDAO;
import edu.nu.cardbord.dao.PictureSliceDAO;
import edu.nu.cardbord.domain.PictureCanvasDO;
import edu.nu.cardbord.domain.PictureCanvasDTO;
import edu.nu.cardbord.domain.PictureCardDO;
import edu.nu.cardbord.domain.PictureCardDTO;
import edu.nu.cardbord.domain.PictureCharacterDO;
import edu.nu.cardbord.domain.PictureCharacterDTO;
import edu.nu.cardbord.domain.PictureSliceDO;
import edu.nu.cardbord.domain.PictureSliceDTO;
import edu.nu.cardbord.service.PictureCanvasService;

/**
 * 画板Service组件
 * @author distribute
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PictureCanvasServiceImpl implements PictureCanvasService {

	/**
	 * 画板DAO组件
	 */
	@Autowired
	private PictureCanvasDAO canvasDAO;
	/**
	 * 卡片DAO组件
	 */
	@Autowired
	private PictureCardDAO cardDAO;
	/**
	 * 文本框DAO组件
	 */
	@Autowired
	private PictureCharacterDAO characterDAO;
	/**
	 * 分割线DAO组件
	 */
	@Autowired
	private PictureSliceDAO sliceDAO;

	/**
	 * 根据id来获取对应具体的画板
	 */
	@Override
	public PictureCanvasDTO getById(Long id) throws Exception {
		PictureCanvasDTO canvas = canvasDAO.getById(id)
				.clone(PictureCanvasDTO.class);
		
		List<PictureCardDTO> cards = ObjectUtils.convertList(
				cardDAO.listByPictureCanvasId(id), 
				PictureCardDTO.class);
		if (cards == null) {
			cards = new ArrayList<>();
		}
		
		List<PictureCharacterDTO> characters = ObjectUtils.convertList(
				characterDAO.listByPictureCanvasId(id), 
				PictureCharacterDTO.class);
		if (characters == null) {
			characters = new ArrayList<>();
		}
		
		List<PictureSliceDTO> slices = ObjectUtils.convertList(
				sliceDAO.listByPictureCanvasId(id), 
				PictureSliceDTO.class);
		if (slices == null) {
			slices = new ArrayList<>();
		}
		
		canvas.setCards(cards);
		canvas.setCharacters(characters);
		canvas.setSlices(slices);
		
		return canvas;
	}

	/**
	 * 新建一个canvas
	 */
	@Override
	public void save(PictureCanvasDTO canvas) throws Exception {
		canvasDAO.save(canvas.clone(
				PictureCanvasDO.class));
	}

	/**
	 * 更新各个组件的位置
	 */
	@Override
	public void updatePosition(PictureCanvasDTO canvas) throws Exception {
		List<PictureCardDTO> cards = canvas.getCards();
		List<PictureCharacterDTO> characters = canvas.getCharacters();
		List<PictureSliceDTO> slices = canvas.getSlices();
		for (PictureCardDTO card : cards) {
			cardDAO.updatePosition(card.clone(PictureCardDO.class));
		}
		for (PictureCharacterDTO character : characters) {
			characterDAO.updatePosition(character.clone(PictureCharacterDO.class));
		}
		for (PictureSliceDTO slice : slices) {
			sliceDAO.updatePosition(slice.clone(PictureSliceDO.class));
		}
	}

	/**
	 * 删除指定的画板
	 */
	@Override
	public void remove(Long id) throws Exception {
		cardDAO.removeAllByCanvasId(id);
		characterDAO.removeAllByCanvasId(id);
		sliceDAO.removeAllByCanvasId(id);
		canvasDAO.remove(id);
	}

	/**
	 * 更新画布的信息
	 */
	@Override
	public void updateInfo(PictureCanvasDTO canvas) throws Exception {
		canvasDAO.update(canvas.clone(PictureCanvasDO.class));
	}
	
}
