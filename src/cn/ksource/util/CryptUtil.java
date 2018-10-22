package cn.ksource.util;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * 加密工具类
 */
public class CryptUtil {

    public static String getEncryptPassword(String account,String password) {
        Digester sha =  new Digester(DigestAlgorithm.SHA512);
        String s1 = sha.digestHex(account + password);
        Digester md5 = new Digester(DigestAlgorithm.MD5);
        return md5.digestHex(s1);
    }
}
