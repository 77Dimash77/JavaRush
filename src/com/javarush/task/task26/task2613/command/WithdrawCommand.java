package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Collections;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);

        ConsoleHelper.writeMessage(res.getString("before"));
        do {
            int amount = getAmount(manipulator);
            try {
                withdraw(manipulator, amount);
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, code));
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                continue;
            }
            break;
        } while (true);
    }

    // пункты 1 - 3.
    private int getAmount(CurrencyManipulator manipulator) throws InterruptOperationException {
        int amount;
        do {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String input = ConsoleHelper.readString();
            try {
                amount = Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            if (amount <= 0) {
                continue;
            }
            if (!manipulator.isAmountAvailable(amount)) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            } else {
                break;
            }
        } while (true);
        return amount;
    }

    //пункт 4
    private void withdraw(CurrencyManipulator manipulator, int amount) throws NotEnoughMoneyException{
        Map<Integer, Integer> result = new TreeMap<>((o1, o2) -> o2 - o1);
        manipulator.withdrawAmount(amount).forEach((k,v) -> result.put(new Integer(k), new Integer(v)));
        result.forEach((k, v) -> ConsoleHelper.writeMessage("\t"+ k + " - " + v));
    }
}
