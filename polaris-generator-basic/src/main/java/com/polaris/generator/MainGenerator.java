package com.polaris.generator;

import cn.hutool.extra.template.TemplateException;
import com.polaris.model.MainTemplateConfig;

import java.io.File;
import java.io.IOException;

import static com.polaris.generator.StaticGenerator.copyFilesByRecursive;

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
        mainTemplateConfig.setOutputText("真艰难");
        doGenerate(mainTemplateConfig);
    }

    /**
     * @param model
     * @throws TemplateException
     * @throws IOException
     * @throws freemarker.template.TemplateException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException, freemarker.template.TemplateException {
        // 获取整个项目的根路径
        String projectPath = System.getProperty("user.dir");
        File projectFile = new File(projectPath);
        // 输入路径：ACM示例代码目录
        String inputPath = new File(projectFile, "polaris-generator-demo-projects/acm-template").getAbsolutePath();
        // 输出路径：polaris-generator-basic
        String outputPath = projectPath;
        copyFilesByRecursive(inputPath, outputPath);
        // 生成动态文件，会覆盖部分已生成的静态文件
        String inputDynamicFilePath = projectPath + File.separator + "polaris-generator-basic" + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = projectPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }
}
