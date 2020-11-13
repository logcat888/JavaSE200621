package com.atguigu.java2;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MathTest {

    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal("298234928347239487239847239847298374289374982374.234982734982374982734987239847293874982374982734982734982739487239847298374928374982374982734982734987239847");
        BigDecimal bigDecimal2 = new BigDecimal("298234928347239487239847239847298374289374982374.7328678237857824875784258778247857834785783478578347583475834758734857348758734857345234982734982374982734987239847293874982374982734982734982739487239847298374928374982374982734982734987239847");
        BigDecimal add = bigDecimal1.add(bigDecimal2);
        System.out.println(add);
    }

    public static void main3(String[] args) {
        long l1 = 0x7FFFFFFFFFFFFFFFL;
        System.out.println(l1);

        BigInteger bi1 = new BigInteger("293847298374298749283749823759827359827359827359872398572983759823759823759827359827359872395872985729837589237598723985729837598237578");
        BigInteger bi2 = new BigInteger("1231231242314234234234283746287364827364872364293847298374298749283749823759827359827359827359872398572983759823759823759827359827359872395872985729837589237598723985729837598237578");
        //bi1 * bi2;
        BigInteger multiply = bi1.multiply(bi2);
        System.out.println(multiply);

    }

    public static void main2(String[] args) {
        double random = Math.random();
        System.out.println(random);
        double v = Math.random() * 100;
        System.out.println(v);
        int i = (int) (Math.random() * 100);
        System.out.println(i);

        double d = 9.9;
        int n = (int)d;
        System.out.println(n);

        System.out.println(Math.round(4.5));
        System.out.println(Math.round(-4.5));
    }
}
