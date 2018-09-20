package cn.ksource.mapper.demo;

import cn.ksource.domain.demo.DemoDto;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/9/14
 * time：11:29
 */
public interface DemoDao extends DemoMapper {

    @SelectProvider(type=DemoDaoProvider.class, method="selectByExample")
    List<DemoDto> selectByExample(DemoDto demoDto);

    @Update({"update demo set state = 0 where id = #{id} "})
    void deleteDemoById(String id);

}
