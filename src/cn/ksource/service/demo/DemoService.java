package cn.ksource.service.demo;

import cn.ksource.domain.demo.DemoDto;
import cn.ksource.domain.demo.DemoExample;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/9/13
 * time：16:36
 */
public interface DemoService {

    void saveDemo(DemoDto demoDto);

    void updateDemo(DemoDto demoDto);

    List<DemoDto> selectByExample(DemoExample demoExample);

    void deleteDemoById(String id);

    DemoDto getDemoById(String id);

}
