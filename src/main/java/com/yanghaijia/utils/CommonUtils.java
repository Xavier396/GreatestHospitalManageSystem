package com.yanghaijia.utils;

import java.util.UUID;

/**
 * 说明:
 *
 * @author haijiay
 * 创建时间: 2023/4/14 11:06
 */


public class CommonUtils {

    public static String getUUID()
    {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
