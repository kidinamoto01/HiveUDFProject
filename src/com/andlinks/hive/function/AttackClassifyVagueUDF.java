package com.andlinks.hive.function;

/**
 * Created by suyu on 17-4-6.
 */
public class AttackClassifyVagueUDF {
    public int evaluate(String str) {
        int result = 0;

        String[] tokens= new String[1];
        tokens[0] = ")))))))))))";


        for (String s: tokens
                ) {
            if(str.contains(s))
                return 1;
        }
        return result;

    }
    public static void main(String[] args) {
        AttackClassifyVagueUDF test = new AttackClassifyVagueUDF();
        System.out.println(test.evaluate("select * from  by ))))))))))) "));
    }
}
