package com.polaris.cli.utils;

import picocli.CommandLine.Option;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author MXD
 */
public class OptionUtil {
    public static String[] processInteractiveOptions(Class<?> clazz, String[] args) {
        // 将传递过来的数组转成集合，方便添加
        Set<String> argSet = new LinkedHashSet<>(Arrays.asList(args));

        // 获取字段的Option注解
        for (Field field : clazz.getDeclaredFields()) {
            // 如果注解存在且其interactive属性为true，则执行以下操作
            Option option = field.getAnnotation(Option.class);
            if (option != null && option.interactive()) {
                // 如果传递的参数中没有该属性，则添加
                if (!argSet.contains(option.names()[0])) {
                    argSet.add(option.names()[0]);
                }
            }
        }
        args = argSet.toArray(new String[0]);
        return args;
    }
}
