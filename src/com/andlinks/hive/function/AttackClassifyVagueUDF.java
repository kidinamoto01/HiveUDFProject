package com.andlinks.hive.function;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by suyu on 17-4-6.
 */
public class AttackClassifyVagueUDF extends UDF {
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
