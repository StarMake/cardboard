package edu.nu.cardbord.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.nu.cardbord.domain.UserAccountDO;

/**
 * 用户账号管理mapper组件
 * @author distribute
 */
@Mapper
public interface UserAccountMapper {

	/**
	 * 新增用户账号
	 * @param userAccount 用户账号
	 */
	@Insert("INSERT INTO membership_user_account("
			+ "username,"
			+ "password,"
			+ "gmt_create,"
			+ "gmt_modified"
		+ ") VALUES("
			+ "#{username},"
			+ "#{password},"
			+ "#{gmtCreate},"
			+ "#{gmtModified}"
		+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(UserAccountDO userAccount);
	
	/**
	 * 为登录来统计是否有对应的账号在
	 */
	@Select("SELECT "
				+ "id,"
				+ "username,"
				+ "gmt_create,"
				+ "gmt_modified "
		+ "FROM membership_user_account "
		+ "WHERE username=#{username} AND password=#{password} ")   
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "username", property = "username"),
		@Result(column = "password", property = "password"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	UserAccountDO getForLogin(UserAccountDO userAccount);
	
	/**
	 * 根据id查询用户账号 
	 * @param id 用户账号id
	 * @return 用户账号
	 */
	@Select("SELECT "
				+ "id,"
				+ "username,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM membership_user_account "
			+ "WHERE id=#{id} ")    
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "username", property = "username"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	UserAccountDO getById(@Param("id") Long id);
	
	/**
	 * 更新密码
	 * @param userAccount 用户账号
	 */
	@Update("UPDATE membership_user_account SET "
				+ "password=#{password},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}") 
	void updatePassword(UserAccountDO userAccount);
}
