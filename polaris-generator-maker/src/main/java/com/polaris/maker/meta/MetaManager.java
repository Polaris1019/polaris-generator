package com.polaris.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

/**
 * @author MXD
 */
public class MetaManager {

    /**
     * volatile，并发编程中常用的关键字，确保多线程环境下的内存可见性
     * 这样 meta 一旦被修改，所有内存都能看见
     */
    private static volatile Meta meta;

    /**
     * 双检锁实现单例模式
     */
    public static Meta getMetaObject() {
        if (meta == null) {
            // 加锁
            synchronized (MetaManager.class) {
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    // 私有构造函数，防止外部用new的方式创建出多个对象
    private static Meta initMeta(){
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        // todo 校验配置文件，处理默认值
        return newMeta;
    }
}
