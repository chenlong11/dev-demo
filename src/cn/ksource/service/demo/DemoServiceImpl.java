package cn.ksource.service.demo;

import cn.hutool.core.util.RandomUtil;
import cn.ksource.domain.demo.Demo;
import cn.ksource.domain.demo.DemoDto;
import cn.ksource.domain.demo.DemoExample;
import cn.ksource.mapper.demo.DemoDao;
import cn.ksource.util.DateUtilSupport;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenlong
 * Date：2018/9/13
 * time：16:36
 */
@Service
public class DemoServiceImpl implements DemoService{

    @Autowired
    private DemoDao demoDao;

    @Override
    public void saveDemo(DemoDto demoDto){
        Demo demo = new Demo();
        BeanUtils.copyProperties(demoDto, demo);
        demo.setId(RandomUtil.simpleUUID());
        demo.setCreateDate(DateUtilSupport.getCurDate());
        demo.setCreateTime(DateUtilSupport.getCurTime());
        demo.setStatu(Short.valueOf("1"));
        demoDao.insert(demo);
    }

    @Override
    public void updateDemo(DemoDto demoDto){
        Demo demo = new Demo();
        BeanUtils.copyProperties(demoDto, demo);
        demoDao.updateByPrimaryKeySelective(demo);
    }

    @Override
    public void selectByExample(DemoExample demoExample) {
        demoDao.selectByExample(demoExample);
    }


}