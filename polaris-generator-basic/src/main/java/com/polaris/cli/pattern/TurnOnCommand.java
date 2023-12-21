package com.polaris.cli.pattern;

/**
 * 开启命令
 * @author MXD
 */
public class TurnOnCommand implements Command {
    private Device device;

    public TurnOnCommand(Device device){
        this.device = device;
    }

    @Override
    public void execute(){
        device.turnOn();
    }
}