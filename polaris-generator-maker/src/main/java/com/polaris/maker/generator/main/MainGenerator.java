package com.polaris.maker.generator.main;


/**
 * @author MXD
 */
public class MainGenerator extends GenerateTemplate {

    @Override
    protected void buildDist(String outputPath, String sourceCopyDestPath, String jarPath, String shellOutputFilePath) {
        System.out.println("不要生成精简版程序包啦！");
    }
}

