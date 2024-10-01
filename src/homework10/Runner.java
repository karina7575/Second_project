package homework10;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Class<Bank> bankClass = Bank.class;
        Class<Thief> thiefClass = Thief.class;
        Bank bank = createBank(bankClass, BigDecimal.valueOf(1500));
        Thief thief = createThief(thiefClass);
        thiefStealMoney(thiefClass, thief, bank);
        System.out.println(thief);
        System.out.println(bank);

        //Запрещено изменять модификаторы доступа!
        //Практически все будет через рефлексию
        //Создать банк с 1500 денег
        //Создать вора
        //Дописать метод stealMoney у вора так, чтобы он крал все деньги из банка себе
        //(увеличивал у себя деньги и обнулял деньги банка)
        //Вызвать здесь метод stealMoney
        //Распечатать вора и банк

        //Итог:
        //Вор - 1500 денег
        //Банк - 0 денег
    }

    private static Bank createBank(Class<Bank> bankClass, BigDecimal money) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<Bank> bankConstructor = bankClass.getDeclaredConstructor(BigDecimal.class);
        bankConstructor.setAccessible(true);
        Bank bank = bankConstructor.newInstance(money);
        return bank;
    }

    private static Thief createThief(Class<Thief> thiefClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<Thief> thiefConstructor = thiefClass.getDeclaredConstructor();
        thiefConstructor.setAccessible(true);
        Thief thief = thiefConstructor.newInstance();
        return thief;
    }

    private static void thiefStealMoney(Class<Thief> thiefClass, Thief thief, Bank bank) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class[] arg = new Class[1];
        arg[0] = Bank.class;
        Method methodStealMoney = thiefClass.getDeclaredMethod("stealMoney", arg);
        methodStealMoney.setAccessible(true);
        methodStealMoney.invoke(thief, bank);
    }

}
