package com.andlinks.hive.function;

/**
 * Created by suyu on 17-4-2.
 * user()
 *
 */

import org.apache.hadoop.hive.ql.exec.UDF;


public class AttackClassifySqlUDF extends UDF{



    public String evaluate(String str) {
       int result = 0;

       String[] tokens= new String[21];
        tokens[0] = "user()";
        tokens[1] = "\"";
        tokens[2] = "\'";
        tokens[3] = "--";
        tokens[4] = "/*";
        tokens[5] = "/*!";
        tokens[6] = "';";
        tokens[7] = "-1' or";
        tokens[8] = "-1 or";
        tokens[9] = "order by";
        tokens[10] = "b/**/y";
        tokens[11] = "/*!by*/";
        tokens[12] = "IF(SUBSTR(@@version";
        tokens[13] = "and sleep(";
        tokens[14] = "' and sleep(";
        tokens[15] = "waitfor delay '";
        tokens[16] = "@@version";
        tokens[17] = "having 1=1--";
        tokens[18] = "' and";
        tokens[19] = "' || '' || '";
        tokens[20] = "' exec master..xp_cmdshell 'vol'--";

        for (String s: tokens
             ) {
                if(str.contains(s))
                    return "SQL注入攻击";
        }
       return "Nothing";

    }

    public static void main(String[] args) {
        AttackClassifySqlUDF test = new AttackClassifySqlUDF();
        System.out.println(test.evaluate("select * from test order by "));
    }
}
