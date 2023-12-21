package com.polaris.cli.pattern;

/**
 * @author MXD
 */
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        // 按下按钮，执行命令
        command.execute();
    }
}