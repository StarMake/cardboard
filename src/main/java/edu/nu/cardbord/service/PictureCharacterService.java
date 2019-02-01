package edu.nu.cardbord.service;

import edu.nu.cardbord.domain.PictureCharacterDTO;

/**
 * @author distribute
 */
public interface PictureCharacterService {

	PictureCharacterDTO save(PictureCharacterDTO character) throws Exception;
	
	void remove(Long id) throws Exception;
	
	void updateInfo(PictureCharacterDTO character) throws Exception;
}
