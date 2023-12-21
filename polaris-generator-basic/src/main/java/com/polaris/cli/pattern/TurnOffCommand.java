package com.polaris.cli.pattern;

/**
 * 关闭命令
 * @author MXD
 */
public class TurnOffCommand implements Command {
    private Device device;

    public TurnOffCommand(Device device){
        this.device = device;
    }

    @Override
    public void execute(){
        device.turnOff();
    }
}