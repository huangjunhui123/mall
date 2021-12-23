package com.macro.mall.demo.demo.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author 黄俊辉
 */
public class Main {
    public static void main(String args[]) {
        //引用com.meituan.Main日志输出器
        Logger logger = LogManager.getLogger(Main.class);
        //引用的名为RollingFile2的异步AsyncLogger
        Logger logger2 = LogManager.getLogger("RollingFile2");
        Person person = new Person("Li","lei");
        logger.info("hello, {}", person);
        logger2.info("good bye, {}", person);
    }


    static class Person {
        String name;
        String sex;

        Person(String n, String s) {
            name = n;
            sex = s;
        }
    }
}