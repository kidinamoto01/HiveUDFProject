package com.andlinks.hive.function;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by suyu on 17-4-6.
 */
public class AttackClassifyCommandUDF extends UDF {
    public int evaluate(String str) {
        int result = 0;

        String[] tokens= new String[13];
        tokens[0] = "|id";
        tokens[1] = "|cat /etc/passwd#";
        tokens[2] = "'|'ld";
        tokens[3] = "\"|\"ld";
        tokens[4] = "';cat /etc/passwd;'";
        tokens[5] = "\";cat /etc/passwd;\"";
        tokens[6] = "||cat /etc/passwd";
        tokens[7] = "'&dir&'";
        tokens[8] = "\"&dir&\"";
        tokens[9] = "|ping -n 20 127.0.0.1||x";
        tokens[10] = "`ping -c 20 127.0.0.1`";
        tokens[11] = "&ping -n 20 127.0.0.1&";
        tokens[12] = "|ping -c 20 127.0.0.1||x";

        for (String s: tokens
                ) {
            if(str.contains(s))
                return 1;
        }
        return result;

    }
    public static void main(String[] args) {
        AttackClassifyCommandUDF test = new AttackClassifyCommandUDF();
        System.out.println(test.evaluate("select * from  by  |ping -c 20 127.0.0.1||x "));
    }
}
