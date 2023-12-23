package com.polaris.generator;

import cn.hutool.extra.template.TemplateException;
import com.polaris.model.MainTemplateConfig;

import java.io.File;
import java.io.IOException;


/**
 * 核心生成器
 *
 * @author MXD
 */
public class MainGenerator {
    public static void main(String[] args) throws freemarker.template.TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("polaris");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("结果：");
        doGenerate(mainTemplateConfig);
    }

    /**
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     * @throws freemarker.template.TemplateException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException, freemarker.template.TemplateException {
        String inputRootPath = "D:\\JAVA\\code\\polaris-generator\\polaris-generator\\polaris-generator-demo-projects\\acm-template-pro";
        String outputRootPath = "D:\\JAVA\\code\\polaris-generator\\polaris-generator\\acm-template-pro";

        String inputPath;
        String outputPath;

        inputPath = new File(inputRootPath, "src/com/polaris/acm/MainTemplate.java.ftl").getAbsolutePath();
        outputPath = new File(outputRootPath, "src/com/polaris/acm/MainTemplate.java").getAbsolutePath();
        DynamicGenerator.doGenerate(inputPath, outputPath, model);

        inputPath = new File(inputRootPath, ".gitignore").getAbsolutePath();
        outputPath = new File(outputRootPath, ".gitignore").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);

        inputPath = new File(inputRootPath, "READMD.md").getAbsolutePath();
        outputPath = new File(outputRootPath, "READMD.md").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);

    }
}
