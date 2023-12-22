package com.polaris.maker.generator;

import com.polaris.maker.meta.Meta;
import com.polaris.maker.meta.MetaManager;

/**
 * @author MXD
 */
public class MainGenerator {
    public static void main(String[] args) {
        Meta meta = MetaManager.getMetaObject();
        System.out.println(meta);
    }
}
