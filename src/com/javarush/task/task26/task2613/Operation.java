package com.javarush.task.task26.task2613;

public enum Operation {
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT,
    TEST;

    public static Operation getAllowableOperationByOrdinal(Integer i) {
        i--;
        Operation[] operations = Operation.values();
        if (i >= operations.length || i < 0) throw new IllegalArgumentException();
        return operations[i];
    }
}
