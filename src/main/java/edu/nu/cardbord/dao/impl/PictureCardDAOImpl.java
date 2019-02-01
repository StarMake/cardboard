package edu.nu.cardbord.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nu.cardbord.common.util.DateProvider;
import edu.nu.cardbord.dao.PictureCardDAO;
import edu.nu.cardbord.domain.PictureCardDO;
import edu.nu.cardbord.mapper.PictureCardMapper;

/**
 * Card管理DAO组件
 * @author distribute
 */
@Repository
public class PictureCardDAOImpl implements PictureCardDAO {

	/**
	 * Card管理mapper组件
	 */
	@Autowired
	private PictureCardMapper pictureCardMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 新增一个card
	 */
	@Override
	public PictureCardDO save(PictureCardDO card) throws Exception {
		card.setGmtCreate(dateProvider.getCurrentTime());
		card.setGmtModified(dateProvider.getCurrentTime());
		pictureCardMapper.save(card);
		return card;
	}

	/**
	 * 查询指定画板上的card
	 */
	@Override
	public List<PictureCardDO> listByPictureCanvasId(Long canvasId) throws Exception {
		return pictureCardMapper.listByPictureCanvasId(canvasId);
	}
	
	/**
	 * 获取对应id的Card
	 */
	@Override
	public PictureCardDO getById(Long id) throws Exception {
		return pictureCardMapper.getById(id);
	}
	
	/**
	 * 更新卡片
	 */
	@Override
	public void update(PictureCardDO card) throws Exception {
		card.setGmtModified(dateProvider.getCurrentTime());
		pictureCardMapper.update(card);
	}

	/**
	 * 更新card的位置信息
	 */
	@Override
	public void updatePosition(PictureCardDO card) throws Exception {
		card.setGmtModified(dateProvider.getCurrentTime());
		pictureCardMapper.updatePosition(card);
	}

	/**
	 * 更新card的内容信息
	 */
	@Override
	public void updateInfo(PictureCardDO card) throws Exception {
		card.setGmtModified(dateProvider.getCurrentTime());
		pictureCardMapper.updateInfo(card);
	}

	/**
	 * 删除卡片
	 */
	@Override
	public void remove(Long id) throws Exception {
		pictureCardMapper.remove(id);
	}

	/**
	 * 删除指定的画板的所有card
	 */
	@Override
	public void removeAllByCanvasId(Long canvasId) throws Exception {
		pictureCardMapper.removeAllByCanvasId(canvasId);
	}
	
}
