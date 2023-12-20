package com.polaris.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

/**
 * @author MXD
 */
//2.注释的类 @Command 并给它一个名称，开启帮助手册
@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
//1.创建一个类实现了 Runnable 或 Callable
public class ASCIIArt implements Runnable {

    //3.对于每一个选项在应用程序，添加一个 @Option-注领域给你的命令类
    @Option(names = {"-s", "--font-size"}, description = "Font size")
    int fontSize = 19;

    //4.为每个位置参数，增加一个 @Parameters-注领域给你的命令类
    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
            description = "Words to be translated into ASCII art.")
    //5.Picocli将命令行参数，以强类型的价值，并将这些价值纳入附加说明的领域
    private String[] words = {"Hello,", "picocli"};

    //6.定义你的商务逻辑的 run 或 call 方法的类
    @Override
    public void run() {
        // 改成自己的run方法
        System.out.println("fontsize = " + fontSize);
        System.out.println("words = " + String.join(",", words));
    }

    public static void main(String[] args) {
        //7.在 main 方法种类、使用的 CommandLine.execute 方法引导你的应用程序
        int exitCode = new CommandLine(new ASCIIArt()).execute(args);
        //8.CommandLine.execute 法返回退出的代码
        System.exit(exitCode);
    }
}