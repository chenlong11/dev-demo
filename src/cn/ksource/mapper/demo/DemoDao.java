package cn.ksource.mapper.demo;

import cn.ksource.domain.demo.DemoExample;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * Created by chenlong
 * Date：2018/9/14
 * time：11:29
 */
public interface DemoDao extends DemoMapper {

    @SelectProvider(type=DemoDaoProvider.class, method="selectByExample")
    void selectByExample(DemoExample demoExample);

}
