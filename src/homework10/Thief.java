package homework10;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class Thief {
    private BigDecimal money;

    private Thief() {
        this.money = BigDecimal.ZERO;
    }

    private void stealMoney(Bank bank) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class<Bank> bankClass = Bank.class;
        Field bankField = bankClass.getDeclaredField("money");
        bankField.setAccessible(true);
        BigDecimal moneyToSteal = (BigDecimal) bankField.get(bank);
        this.money = moneyToSteal;

        Class[] arg = new Class[1];
        arg[0] = BigDecimal.class;
        Method methodSetMoney = bankClass.getDeclaredMethod("setMoney", arg);
        methodSetMoney.setAccessible(true);
        methodSetMoney.invoke(bank, BigDecimal.valueOf(0));
    }

    @Override
    public String toString() {
        return "Вор - " + money + " денег";
    }
}
