package cn.ksource.mapper.dic;

import cn.ksource.domain.dic.SysDicDto;
import org.apache.ibatis.annotations.Select;

public interface SysDicManager extends SysDicMapper {
    @Select({ "select",
            " id, dic_name, dic_code, sn, create_date, create_time, state ",
            " from sys_dic ",
            " where dic_code = #{dicCode,jdbcType=VARCHAR} "})
    SysDicDto getByCode(String dicCode);
}
