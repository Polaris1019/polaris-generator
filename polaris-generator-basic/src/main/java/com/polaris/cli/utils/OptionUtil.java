package com.polaris.cli.utils;

import picocli.CommandLine.Option;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 第三期扩展点：检测 args 数组中是否存在对应选项，不存在则为数组增加选项
 * 利用反射自动读取必填选项名称
 * @author MXD
 */
public class OptionUtil {
    public static String[] processInteractiveOptions(Class<?> clazz, String[] args) {
        /**
         * 判断这个选项在传递的选项中是否存在？
         * 因为需要保证参数中的第⼀个元素是命令，也就是 generate、list、config 三者之⼀，
         * 所以选择 LinkedHashSet ，LinkedHashSet会保持元素的插⼊顺序，
         * 因此原始 args[0]的位置将保持不变，其他元素的查找性能也将得到提升。
         */
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
