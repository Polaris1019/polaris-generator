package com.polaris.maker.cli;

import com.polaris.maker.cli.command.ConfigCommand;
import com.polaris.maker.cli.command.GenerateCommand;
import com.polaris.maker.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * 命令执行器
 *
 * @author MXD
 */
@Command(name = "polaris", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {

    private final CommandLine commandLine;

    /**
     * 为什么使用代码块？
     * 代码块，节省开销，提升性能
     */ {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        // 不输入子命令时，给出友好提示
        System.out.println("请输入具体命令，或者输入 --help 查看命令提示");
    }

    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}