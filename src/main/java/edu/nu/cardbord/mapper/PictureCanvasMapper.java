package edu.nu.cardbord.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.nu.cardbord.domain.PictureCanvasDO;

/**
 * 画布管理Mapper组件
 * @author distribute
 */
@Mapper
public interface PictureCanvasMapper {

	/**
	 * 新增一个画布
	 */
	@Insert("INSERT INTO picture_canvas("
			+ "user_account_id,"
			+ "canvas_name,"
			+ "gmt_create,"
			+ "gmt_modified"
		+ ") VALUES("
			+ "#{userAccountId},"
			+ "#{canvasName},"
			+ "#{gmtCreate},"
			+ "#{gmtModified}"
		+ ")")
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(PictureCanvasDO pictureCanvas);
	
	/**
	 * 更新画布信息
	 */
	@Update("UPDATE picture_canvas SET "
			+ "canvas_name=#{canvasName},"
			+ "gmt_modified=#{gmtModified} "
		+ "WHERE id=#{id}")
	void update(PictureCanvasDO pictureCanvas);
	
	/**
	 * 根据用户id查询所有的画布
	 */
	@Select("SELECT "
			+ "id,"
			+ "user_account_id,"
			+ "canvas_name,"
			+ "gmt_create,"
			+ "gmt_modified "
		+ "FROM picture_canvas "
		+ "WHERE user_account_id=#{userAccountId}")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "user_account_id", property = "userAccountId"),
		@Result(column = "canvas_name", property = "canvasName"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<PictureCanvasDO> getByUserAccountId(
			@Param("userAccountId") Long userAccountId);
	
	/**
	 * 根据id获取对应的画布
	 */
	@Select("SELECT "
			+ "id,"
			+ "user_account_id,"
			+ "canvas_name,"
			+ "gmt_create,"
			+ "gmt_modified "
		+ "FROM picture_canvas "
		+ "WHERE id=#{id}")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "user_account_id", property = "userAccountId"),
		@Result(column = "canvas_name", property = "canvasName"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	PictureCanvasDO getById(@Param("id") Long id);
	
	/**
	 * 删除画布
	 */
	@Delete("DELETE FROM picture_canvas WHERE id=#{id}")
	void remove(@Param("id") Long id);
	
}
