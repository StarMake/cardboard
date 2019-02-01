package edu.nu.cardbord.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.nu.cardbord.dao.PictureCardDAO;
import edu.nu.cardbord.domain.PictureCardDO;
import edu.nu.cardbord.domain.PictureCardDTO;
import edu.nu.cardbord.service.PictureCardService;

/**
 * @author distribute
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PictureCardServiceImpl implements PictureCardService {
	
	/**
	 * 卡片DAO管理组件
	 */
	@Autowired
	private PictureCardDAO pictureCardDAO;
	
	/**
	 * 创建一个新的卡片
	 */
	@Override
	public PictureCardDTO save(PictureCardDTO card) throws Exception {
		return pictureCardDAO.save(card.clone(PictureCardDO.class))
				.clone(PictureCardDTO.class);
	}

	/**
	 * 删除指定的card
	 */
	@Override
	public void remove(Long id) throws Exception {
		pictureCardDAO.remove(id);
	}

	/**
	 * 更新card内容信息
	 */
	@Override
	public void updateInfo(PictureCardDTO card) throws Exception {
		pictureCardDAO.updateInfo(card.clone(PictureCardDO.class));
	}
	
}
