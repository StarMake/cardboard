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

import edu.nu.cardbord.domain.PictureCharacterDO;

/**
 * Character管理的Mapper组件
 * @author distribute
 */
@Mapper
public interface PictureCharacterMapper {

	/**
	 * 新增一个character
	 */
	@Insert("INSERT INTO picture_character("
			+ "canvas_id,"
			+ "x,"
			+ "y,"
			+ "gmt_create,"
			+ "gmt_modified"
		+ ") VALUES("
			+ "#{canvasId},"
			+ "#{x},"
			+ "#{y},"
			+ "#{gmtCreate},"
			+ "#{gmtModified}"
		+ ")")
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(PictureCharacterDO pictureCharacter);
	
	/**
	 * 查询指定画板上的character
	 */
	@Select("SELECT "
			+ "id,"
			+ "canvas_id,"
			+ "x,"
			+ "y,"
			+ "content,"
			+ "font_color_r,"
			+ "font_color_g,"
			+ "font_color_b,"
			+ "font_size,"
			+ "gmt_create,"
			+ "gmt_modified "
		+ "FROM picture_character "
		+ "WHERE canvas_id=#{canvasId}")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "canvas_id", property = "canvasId"),
		@Result(column = "x", property = "x"),
		@Result(column = "y", property = "y"),
		@Result(column = "content", property = "content"),
		@Result(column = "font_color_r", property = "fontColorR"),
		@Result(column = "font_color_g", property = "fontColorG"),
		@Result(column = "font_color_b", property = "fontColorB"),
		@Result(column = "font_size", property = "fontSize"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<PictureCharacterDO> listByPictureCanvasId(@Param("canvasId") Long canvasId);
	
	/**
	 * 根据id获取对应的文本框
	 */
	@Select("SELECT "
			+ "id,"
			+ "canvas_id,"
			+ "x,"
			+ "y,"
			+ "content,"
			+ "font_color_r,"
			+ "font_color_g,"
			+ "font_color_b,"
			+ "font_size,"
			+ "gmt_create,"
			+ "gmt_modified "
		+ "FROM picture_character "
		+ "WHERE id=#{id}")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "canvas_id", property = "canvasId"),
		@Result(column = "x", property = "x"),
		@Result(column = "y", property = "y"),
		@Result(column = "content", property = "content"),
		@Result(column = "font_color_r", property = "fontColorR"),
		@Result(column = "font_color_g", property = "fontColorG"),
		@Result(column = "font_color_b", property = "fontColorB"),
		@Result(column = "font_size", property = "fontSize"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	PictureCharacterDO getById(@Param("id") Long id);
	
	/**
	 * 更新文本框
	 */
	@Update("UPDATE picture_character SET "
			+ "x=#{x},"
			+ "y=#{y},"
			+ "content=#{content},"
			+ "font_color_r=#{fontColorR},"
			+ "font_color_g=#{fontColorG},"
			+ "font_color_b=#{fontColorB},"
			+ "font_size=#{fontSize},"
			+ "gmt_modified=#{gmtModified} "
		+ "WHERE id=#{id}")
	void update(PictureCharacterDO pictureCharacter);
	
	/**
	 * 更新文本框的位置
	 */
	@Update("UPDATE picture_character SET "
			+ "x=#{x},"
			+ "y=#{y},"
			+ "gmt_modified=#{gmtModified} "
		+ "WHERE id=#{id}")
	void updatePosition(PictureCharacterDO pictureCharacter);
	
	/**
	 * 更新文本框内容信息
	 */
	@Update("UPDATE picture_character SET "
			+ "content=#{content},"
			+ "font_color_r=#{fontColorR},"
			+ "font_color_g=#{fontColorG},"
			+ "font_color_b=#{fontColorB},"
			+ "font_size=#{fontSize},"
			+ "gmt_modified=#{gmtModified} "
		+ "WHERE id=#{id}")
	void updateInfo(PictureCharacterDO pictureCharacter);
	
	/**
	 * 删除文本框
	 */
	@Delete("DELETE FROM picture_character WHERE id=#{id}")
	void remove(@Param("id") Long id);
	
	/**
	 * 删除指定画板上的所有文本框
	 */
	@Delete("DELETE FROM picture_character WHERE canvas_id=#{canvasId}")
	void removeAllByCanvasId(@Param("canvasId") Long canvasId);
}
