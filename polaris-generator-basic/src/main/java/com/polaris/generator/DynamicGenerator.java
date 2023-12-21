package com.polaris.generator;

import cn.hutool.extra.template.TemplateException;
import com.polaris.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 动态文件生成
 *
 * @author MXD
 */
public class DynamicGenerator {
    public static void main(String[] args) throws freemarker.template.TemplateException, IOException {
        // 当前idea打开的窗口
        String projectPath = System.getProperty("user.dir") + File.separator + "polaris-generator-basic";
        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = projectPath + File.separator + "MainTemplate.java";
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        // 这次使用循环
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setAuthor("polaris");
        mainTemplateConfig.setOutputText("2023/12/19求和结果:");
        doGenerate(inputPath, outputPath, mainTemplateConfig);
    }

    /**
     * @param inputPath  模板文件输入路径
     * @param outputPath 生成代码的输出路径
     * @param model      参数配置
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException, freemarker.template.TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在的路径，模板文件的父级目录
        File templateDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        // 创建模板对象，加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName,"utf-8");

        // 生成
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(Paths.get(outputPath)), StandardCharsets.UTF_8));
        template.process(model, out);

//        //生成（鱼皮原本代码）
//        Writer out = new FileWriter(outputPath);
//        template.process(model, out);

        // 生成后关闭文件
        out.close();
    }
}
