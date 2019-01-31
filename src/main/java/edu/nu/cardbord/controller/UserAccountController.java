package edu.nu.cardbord.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.nu.cardbord.common.util.ObjectUtils;
import edu.nu.cardbord.domain.PictureCanvasVO;
import edu.nu.cardbord.domain.UserAccountDTO;
import edu.nu.cardbord.domain.UserAccountVO;
import edu.nu.cardbord.service.UserAccountService;

/**
 * 
 * @author distribute
 */
@RestController
@RequestMapping("/user")
public class UserAccountController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserAccountController.class);
	
	/**
	 * 用户账号管理service组件
	 */
	@Autowired
	private UserAccountService userAccountService;
	
	/**
	 * 用户注册
	 * @param userAccount 用户账号
	 */
	@PostMapping("/register")  
	public UserAccountVO register(@RequestBody UserAccountVO userAccount) {
		try {
			UserAccountDTO resultUserAccount = userAccountService.save(
					userAccount.clone(UserAccountDTO.class));
			resultUserAccount.setPassword(null);
			return resultUserAccount.clone(UserAccountVO.class);
		} catch (Exception e) {
			logger.error("error", e); 
			return new UserAccountVO();
		}
	}
	
	/**
	 * 为登录来统计是否有对应的账号在
	 * @param userAccount 用户账号
	 * @return
	 */
	@PostMapping("/login")
	public UserAccountVO login(@RequestBody UserAccountVO userAccount) {
		try {
			UserAccountDTO resultUserAccount = userAccountService.getForLogin(
					userAccount.clone(UserAccountDTO.class));
			return resultUserAccount.clone(UserAccountVO.class);
		} catch (Exception e) {
			logger.error("error", e); 
			return new UserAccountVO();
		}
	}
	
	/**
	 * 更新密码
	 * @param userAccount 用户账号
	 */
	@PutMapping("/password/{id}")  
	public Boolean updatePassword(@RequestBody UserAccountVO userAccount) {
		try {
			userAccountService.updatePassword(userAccount.clone(UserAccountDTO.class)); 
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 获取该用户对应的所有画板
	 * @param userAccountId
	 * @return
	 */
	@GetMapping("/canvases/{userAccountId}")
	public List<PictureCanvasVO> listByUserAccountId(@PathVariable("userAccountId") Long userAccountId) {
		try {
			return ObjectUtils.convertList(
					userAccountService.getByUserAccountId(userAccountId), 
					PictureCanvasVO.class);
		} catch (Exception e) {
			logger.error("error", e);
			return new ArrayList<>();
		}
	}
	
}
