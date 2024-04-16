package com.javarush.task.pro.task10.task1020;

public class Computer {
    Mouse mouse;
    Monitor monitor;
    Keyboard keyboard;
    SystemUnit systemUnit;

    public Computer() {
        this.mouse = new Mouse();
        this.monitor = new Monitor();
        this.keyboard = new Keyboard();
        this.systemUnit = new SystemUnit();
    }
}
