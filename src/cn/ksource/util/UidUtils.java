package cn.ksource.util;

import com.baidu.fsg.uid.UidGenerator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UidUtils {

    private static UidGenerator uidGenerator;

    @Resource
    public void setUidGenerator(UidGenerator uidGenerator) {
        UidUtils.uidGenerator = uidGenerator;
    }

    public static long getUID() {
        return uidGenerator.getUID();
    }

}
