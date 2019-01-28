package edu.nu.cardbord.dao;

import edu.nu.cardbord.domain.UserAccountDO;

/**
 * 用户账号管理DAO接口
 * @author distribute
 */
public interface UserAccountDAO {

	/**
	 * 新增用户账号
	 * @param userAccount 用户账号
	 * @return 用户账号
	 */
	UserAccountDO save(UserAccountDO userAccount) throws Exception;
	
	/**
	 * 为登录来统计是否有对应的账号在
	 * @param userAccount 用户账号
	 * @return
	 */
	UserAccountDO getForLogin(UserAccountDO userAccount) throws Exception;
	
	/**
	 * 根据id查询用户账号 
	 * @param id 用户账号id
	 * @return 用户账号
	 */
	UserAccountDO getById(Long id) throws Exception;
	
	/**
	 * 更新密码
	 * @param userAccount 用户账号
	 */
	void updatePassword(UserAccountDO userAccount) throws Exception;
}
