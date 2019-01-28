package edu.nu.cardbord.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.nu.cardbord.dao.PictureCharacterDAO;
import edu.nu.cardbord.domain.PictureCharacterDO;
import edu.nu.cardbord.domain.PictureCharacterDTO;
import edu.nu.cardbord.service.PictureCharacterService;

/**
 * @author distribute
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PictureCharacterServiceImpl implements PictureCharacterService {

	@Autowired
	private PictureCharacterDAO characterDAO;
	
	@Override
	public Long save(PictureCharacterDTO character) throws Exception {
		return characterDAO.save(character.clone(PictureCharacterDO.class));
	}

	@Override
	public void remove(Long id) throws Exception {
		characterDAO.remove(id);
	}

	@Override
	public void updateInfo(PictureCharacterDTO character) throws Exception {
		characterDAO.updateInfo(character.clone(PictureCharacterDO.class));
	}
	
}
