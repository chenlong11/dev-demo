package cn.ksource.conf;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.TemplateHashModel;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**
 * Created by chenlong
 * Date：2018/9/12
 * time：12:01
 */
public class MyFreeMarkerConfigurer extends FreeMarkerConfigurer {

    private void loadAutoIncludeList(Configuration cfg) {
        //日期格式化
//        cfg.setSharedVariable("format", new Format());
    }


    private void loadCommonStaticClass(Configuration cfg) {
        try {
            BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
            TemplateHashModel staticModels = wrapper.getStaticModels();
            cfg.setSharedVariable("StrUtil", (TemplateHashModel) staticModels.get("cn.hutool.core.util.StrUtil"));
            cfg.setSharedVariable("Constants", (TemplateHashModel) staticModels.get("cn.ksource.constants.Constants"));
            cfg.setSharedVariable("PropConstants", (TemplateHashModel) staticModels.get("cn.ksource.constants.PropConstants"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Configuration getConfiguration() {
        Configuration cfg =  super.getConfiguration();
        //禁止本地化寻找
        cfg.setLocalizedLookup(false);
        cfg.setDefaultEncoding("utf-8");
        cfg.setClassicCompatible(true);
        //使用[#]替代<#ftl>
        cfg.setTagSyntax(Configuration.SQUARE_BRACKET_TAG_SYNTAX);
        loadAutoIncludeList(cfg);
        loadCommonStaticClass(cfg);
        return cfg;
    }
}
