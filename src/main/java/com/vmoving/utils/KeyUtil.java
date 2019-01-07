package com.vmoving.utils;

import java.util.Random;

public class KeyUtil {
	 /**
     * 生成唯一的主键
     * 格式：时间+随机数
     * 在并发下任然可能重复，需要加synchronized 多线程
     * @return
     */
    public static synchronized Integer genUniqueKey() {
        Random random = new Random();
        //生成6位随机数
        Integer number = random.nextInt(900000) + 100;

        return number;
    }
}
