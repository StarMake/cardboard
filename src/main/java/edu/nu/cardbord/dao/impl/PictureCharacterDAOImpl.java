package edu.nu.cardbord.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nu.cardbord.common.util.DateProvider;
import edu.nu.cardbord.dao.PictureCharacterDAO;
import edu.nu.cardbord.domain.PictureCharacterDO;
import edu.nu.cardbord.mapper.PictureCharacterMapper;

@Repository
public class PictureCharacterDAOImpl implements PictureCharacterDAO {

	/**
	 * Character管理的Mapper组件
	 */
	@Autowired
	private PictureCharacterMapper characterMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 新增一个character
	 */
	@Override
	public Long save(PictureCharacterDO character) throws Exception {
		character.setGmtCreate(dateProvider.getCurrentTime());
		character.setGmtModified(dateProvider.getCurrentTime());
		characterMapper.save(character);
		return character.getId();
	}

	/**
	 * 查询指定画板上的character
	 */
	@Override
	public List<PictureCharacterDO> listByPictureCanvasId(Long canvasId) throws Exception {
		return characterMapper.listByPictureCanvasId(canvasId);
	}

	/**
	 * 根据id获取对应的文本框
	 */
	@Override
	public PictureCharacterDO getById(Long id) throws Exception {
		return characterMapper.getById(id);
	}
	
	/**
	 * 更新文本框
	 */
	@Override
	public void update(PictureCharacterDO character) throws Exception {
		character.setGmtModified(dateProvider.getCurrentTime());
		characterMapper.update(character);
	}

	/**
	 * 删除文本框
	 */
	@Override
	public void remove(Long id) throws Exception {
		characterMapper.remove(id);
	}

	@Override
	public void updatePosition(PictureCharacterDO character) throws Exception {
		character.setGmtModified(dateProvider.getCurrentTime());
		characterMapper.updatePosition(character);
	}

	@Override
	public void updateInfo(PictureCharacterDO character) throws Exception {
		character.setGmtModified(dateProvider.getCurrentTime());
		characterMapper.updateInfo(character);
	}

	/**
	 * 删除指定的画板的所有文本框
	 */
	@Override
	public void removeAllByCanvasId(Long canvasId) throws Exception {
		characterMapper.removeAllByCanvasId(canvasId);
	}

}
