package com.star.util;

import org.springframework.util.DigestUtils;

/**
 * @Description: MD5加密工具类
 */
public class MD5Utils {

    /**
     * @Param: 要加密的字符串
     * @Return: 加密后的字符串
     */
    public static String code(String str) {
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

}