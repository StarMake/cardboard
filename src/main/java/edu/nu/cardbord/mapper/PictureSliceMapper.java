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

import edu.nu.cardbord.domain.PictureSliceDO;

/**
 * Slice的管理Mapper组件
 * @author distribute
 */
@Mapper
public interface PictureSliceMapper {

	/**
	 * 新增一个slice
	 */
	@Insert("INSERT INTO picture_slice("
			+ "canvas_id,"
			+ "x,"
			+ "y,"
			+ "type,"
			+ "gmt_create,"
			+ "gmt_modified"
		+ ") VALUES("
			+ "#{canvasId},"
			+ "#{x},"
			+ "#{y},"
			+ "#{type},"
			+ "#{gmtCreate},"
			+ "#{gmtModified}"
		+ ")")
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(PictureSliceDO pictureSlice);
	
	/**
	 * 更新slice的位置
	 */
	@Update("UPDATE picture_slice SET "
			+ "x=#{x},"
			+ "y=#{y},"
			+ "gmt_modified=#{gmtModified} "
		+ "WHERE id=#{id}")
	void updatePosition(PictureSliceDO pictureSlice);
	
	/**
	 * 查询指定画板上的slice
	 */
	@Select("SELECT "
			+ "id,"
			+ "canvas_id,"
			+ "x,"
			+ "y,"
			+ "type,"
			+ "gmt_create,"
			+ "gmt_modified "
		+ "FROM picture_slice "
		+ "WHERE canvas_id=#{canvasId}")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "canvas_id", property = "canvasId"),
		@Result(column = "x", property = "x"),
		@Result(column = "y", property = "y"),
		@Result(column = "type", property = "type"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<PictureSliceDO> listByPictureCanvasId(@Param("canvasId") Long canvasId);
	
	/**
	 * 删除slice
	 */
	@Delete("DELETE FROM picture_slice WHERE id=#{id}")
	void remove(@Param("id") Long id);
	
	/**
	 * 删除指定画板上的所有分割线
	 */
	@Delete("DELETE FROM picture_slice WHERE canvas_id=#{canvasId}")
	void removeAllByCanvasId(@Param("canvasId") Long canvasId);
}
