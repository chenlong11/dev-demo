package cn.ksource.mapper.dicData;

import cn.ksource.domain.dicData.SysDicData;
import cn.ksource.domain.dicData.SysDicDataExample;
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

public interface SysDicDataMapper {
    @SelectProvider(type=SysDicDataSqlProvider.class, method="countByExample")
    long countByExample(SysDicDataExample example);

    @DeleteProvider(type=SysDicDataSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysDicDataExample example);

    @Delete({
        "delete from sys_dic_data",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_dic_data (id, dic_id, ",
        "data_code, data_val, ",
        "sn)",
        "values (#{id,jdbcType=BIGINT}, #{dicId,jdbcType=BIGINT}, ",
        "#{dataCode,jdbcType=VARCHAR}, #{dataVal,jdbcType=VARCHAR}, ",
        "#{sn,jdbcType=SMALLINT})"
    })
    int insert(SysDicData record);

    @InsertProvider(type=SysDicDataSqlProvider.class, method="insertSelective")
    int insertSelective(SysDicData record);

    @SelectProvider(type=SysDicDataSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="dic_id", property="dicId", jdbcType=JdbcType.BIGINT),
        @Result(column="data_code", property="dataCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_val", property="dataVal", jdbcType=JdbcType.VARCHAR),
        @Result(column="sn", property="sn", jdbcType=JdbcType.SMALLINT)
    })
    List<SysDicData> selectByExample(SysDicDataExample example);

    @Select({
        "select",
        "id, dic_id, data_code, data_val, sn",
        "from sys_dic_data",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="dic_id", property="dicId", jdbcType=JdbcType.BIGINT),
        @Result(column="data_code", property="dataCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_val", property="dataVal", jdbcType=JdbcType.VARCHAR),
        @Result(column="sn", property="sn", jdbcType=JdbcType.SMALLINT)
    })
    SysDicData selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysDicDataSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysDicData record, @Param("example") SysDicDataExample example);

    @UpdateProvider(type=SysDicDataSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysDicData record, @Param("example") SysDicDataExample example);

    @UpdateProvider(type=SysDicDataSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysDicData record);

    @Update({
        "update sys_dic_data",
        "set dic_id = #{dicId,jdbcType=BIGINT},",
          "data_code = #{dataCode,jdbcType=VARCHAR},",
          "data_val = #{dataVal,jdbcType=VARCHAR},",
          "sn = #{sn,jdbcType=SMALLINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysDicData record);
}