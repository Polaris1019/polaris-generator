package com.polaris.cli.example;

import com.polaris.cli.utils.OptionUtil;
import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * @author MXD
 */
//1.首先命令类需要实现 Callable 接口
public class Login implements Callable<Integer> {
    @Option(names = {"-u", "--user"}, description = "User name")
    String user;

    //2.将 @Option 注解的 interactive 参数设置为 true，表示该选项支持交互式输入
    @Option(names = {"-p", "--password"}, arity = "0..1", description = "Passphrase", interactive = true)
    String password;

    @Option(names = {"-cp", "--checkPassword"}, arity = "0..1", description = "Check Password", interactive = true)
    String checkPassword;

    @Override
    //3.所有参数都输入完成后，会执行 call 方法，可以在方法中编写业务逻辑
    public Integer call() throws Exception {
        // 打印出密码
        System.out.println("密码是：" + password);
        System.out.println("确认密码是：" + checkPassword);
        return 0;
    }

    //4.在 Main 方法中执行命令并传入参数
    public static void main(String[] args) {
//        new CommandLine(new Login()).execute("-u", "user123", "-p", "xxx", "-cp");
        // 强制交互式：传递类的字节码 和 args参数
        args = new String[]{"-u", "user123", "-p"};
        new CommandLine(new Login()).execute(OptionUtil.processInteractiveOptions(Login.class, args));
    }
}