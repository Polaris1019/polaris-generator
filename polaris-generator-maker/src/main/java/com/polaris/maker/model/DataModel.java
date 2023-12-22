package com.polaris.maker.model;

import lombok.Data;

/**
 * @author MXD
 */
@Data
public class DataModel {

    /**
     * 作者（字符串，填充值）
     */
    private String author = "polaris";

    /**
     * 输出信息
     */
    private String outputText = "输出结果";

    /**
     * 是否循环（开关）
     */
    private boolean loop;


}
