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

import edu.nu.cardbord.domain.PictureCardDO;

/**
 * Card管理的Mapper组件
 * @author distribute
 */
@Mapper
public interface PictureCardMapper {

	/**
	 * 新增一个card
	 */
	@Insert("INSERT INTO picture_card("
			+ "canvas_id,"
			+ "x,"
			+ "y,"
			+ "color,"
			+ "gmt_create,"
			+ "gmt_modified"
		+ ") VALUES("
			+ "#{canvasId},"
			+ "#{x},"
			+ "#{y},"
			+ "#{color},"
			+ "#{gmtCreate},"
			+ "#{gmtModified}"
		+ ")")
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(PictureCardDO pictureCard);
	
	/**
	 * 更新卡片
	 */
	@Update("UPDATE picture_card SET "
			+ "x=#{x},"
			+ "y=#{y},"
			+ "card_name=#{cardName},"
			+ "card_content=#{cardContent},"
			+ "color=#{color},"
			+ "status=#{status},"
			+ "gmt_modified=#{gmtModified} "
		+ "WHERE id=#{id}")
	void update(PictureCardDO pictureCard);
	
	/**
	 * 更新card的位置信息
	 */
	@Update("UPDATE picture_card SET "
			+ "x=#{x},"
			+ "y=#{y},"
			+ "gmt_modified=#{gmtModified} "
		+ "WHERE id=#{id}")
	void updatePosition(PictureCardDO pictureCard);
	
	/**
	 * 更新card的内容信息
	 */
	@Update("UPDATE picture_card SET "
			+ "card_name=#{cardName},"
			+ "card_content=#{cardContent},"
			+ "color=#{color},"
			+ "status=#{status},"
			+ "gmt_modified=#{gmtModified} "
		+ "WHERE id=#{id}")
	void updateInfo(PictureCardDO pictureCard);
	
	/**
	 * 查询指定画板上的card
	 */
	@Select("SELECT "
			+ "id,"
			+ "canvas_id,"
			+ "x,"
			+ "y,"
			+ "card_name,"
			+ "card_content,"
			+ "color,"
			+ "status,"
			+ "gmt_create,"
			+ "gmt_modified "
		+ "FROM picture_card "
		+ "WHERE canvas_id=#{canvasId}")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "canvas_id", property = "canvasId"),
		@Result(column = "x", property = "x"),
		@Result(column = "y", property = "y"),
		@Result(column = "card_name", property = "cardName"),
		@Result(column = "card_content", property = "cardContent"),
		@Result(column = "color", property = "color"),
		@Result(column = "status", property = "status"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<PictureCardDO> listByPictureCanvasId(@Param("canvasId") Long canvasId);
	
	/**
	 * 根据id获取对应的Card
	 */
	@Select("SELECT "
			+ "id,"
			+ "canvas_id,"
			+ "x,"
			+ "y,"
			+ "card_name,"
			+ "card_content,"
			+ "color,"
			+ "status,"
			+ "gmt_create,"
			+ "gmt_modified "
		+ "FROM picture_card "
		+ "WHERE id=#{id}")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "canvas_id", property = "canvasId"),
		@Result(column = "x", property = "x"),
		@Result(column = "y", property = "y"),
		@Result(column = "card_name", property = "cardName"),
		@Result(column = "card_content", property = "cardContent"),
		@Result(column = "color", property = "color"),
		@Result(column = "status", property = "status"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	PictureCardDO getById(@Param("id") Long id);
	
	/**
	 * 删除指定id的卡片
	 */
	@Delete("DELETE FROM picture_card WHERE id=#{id}")  
	void remove(@Param("id") Long id);
	
	/**
	 * 删除指定画板上的所有card
	 */
	@Delete("DELETE FROM picture_card WHERE canvas_id=#{canvasId}")
	void removeAllByCanvasId(@Param("canvasId") Long canvasId);
	
}
