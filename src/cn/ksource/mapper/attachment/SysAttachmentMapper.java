package cn.ksource.mapper.attachment;

import cn.ksource.domain.attachment.SysAttachment;
import cn.ksource.domain.attachment.SysAttachmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SysAttachmentMapper {
    @SelectProvider(type=SysAttachmentSqlProvider.class, method="countByExample")
    long countByExample(SysAttachmentExample example);

    @DeleteProvider(type=SysAttachmentSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysAttachmentExample example);

    @Delete({
        "delete from sys_attachment",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_attachment (id, business_id, ",
        "att_type, att_name, ",
        "att_path, att_size, ",
        "att_ext, sn, create_id, ",
        "create_date, create_time, ",
        "state)",
        "values (#{id,jdbcType=BIGINT}, #{businessId,jdbcType=BIGINT}, ",
        "#{attType,jdbcType=VARCHAR}, #{attName,jdbcType=VARCHAR}, ",
        "#{attPath,jdbcType=VARCHAR}, #{attSize,jdbcType=VARCHAR}, ",
        "#{attExt,jdbcType=VARCHAR}, #{sn,jdbcType=SMALLINT}, #{createId,jdbcType=BIGINT}, ",
        "#{createDate,jdbcType=DATE}, #{createTime,jdbcType=TIME}, ",
        "#{state,jdbcType=TINYINT})"
    })
    int insert(SysAttachment record);

    @InsertProvider(type=SysAttachmentSqlProvider.class, method="insertSelective")
    int insertSelective(SysAttachment record);

    @SelectProvider(type=SysAttachmentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="business_id", property="businessId", jdbcType=JdbcType.BIGINT),
        @Result(column="att_type", property="attType", jdbcType=JdbcType.VARCHAR),
        @Result(column="att_name", property="attName", jdbcType=JdbcType.VARCHAR),
        @Result(column="att_path", property="attPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="att_size", property="attSize", jdbcType=JdbcType.VARCHAR),
        @Result(column="att_ext", property="attExt", jdbcType=JdbcType.VARCHAR),
        @Result(column="sn", property="sn", jdbcType=JdbcType.SMALLINT),
        @Result(column="create_id", property="createId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIME),
        @Result(column="state", property="state", jdbcType=JdbcType.TINYINT)
    })
    List<SysAttachment> selectByExample(SysAttachmentExample example);

    @Select({
        "select",
        "id, business_id, att_type, att_name, att_path, att_size, att_ext, sn, create_id, ",
        "create_date, create_time, state",
        "from sys_attachment",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="business_id", property="businessId", jdbcType=JdbcType.BIGINT),
        @Result(column="att_type", property="attType", jdbcType=JdbcType.VARCHAR),
        @Result(column="att_name", property="attName", jdbcType=JdbcType.VARCHAR),
        @Result(column="att_path", property="attPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="att_size", property="attSize", jdbcType=JdbcType.VARCHAR),
        @Result(column="att_ext", property="attExt", jdbcType=JdbcType.VARCHAR),
        @Result(column="sn", property="sn", jdbcType=JdbcType.SMALLINT),
        @Result(column="create_id", property="createId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIME),
        @Result(column="state", property="state", jdbcType=JdbcType.TINYINT)
    })
    SysAttachment selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysAttachmentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysAttachment record, @Param("example") SysAttachmentExample example);

    @UpdateProvider(type=SysAttachmentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysAttachment record, @Param("example") SysAttachmentExample example);

    @UpdateProvider(type=SysAttachmentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysAttachment record);

    @Update({
        "update sys_attachment",
        "set business_id = #{businessId,jdbcType=BIGINT},",
          "att_type = #{attType,jdbcType=VARCHAR},",
          "att_name = #{attName,jdbcType=VARCHAR},",
          "att_path = #{attPath,jdbcType=VARCHAR},",
          "att_size = #{attSize,jdbcType=VARCHAR},",
          "att_ext = #{attExt,jdbcType=VARCHAR},",
          "sn = #{sn,jdbcType=SMALLINT},",
          "create_id = #{createId,jdbcType=BIGINT},",
          "create_date = #{createDate,jdbcType=DATE},",
          "create_time = #{createTime,jdbcType=TIME},",
          "state = #{state,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysAttachment record);
}