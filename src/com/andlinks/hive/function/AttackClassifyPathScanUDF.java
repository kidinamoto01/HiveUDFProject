package com.andlinks.hive.function;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by suyu on 17-4-6.
 */
public class AttackClassifyPathScanUDF extends UDF {
    public String evaluate(String str) {
        int result = 0;

        String[] tokens= new String[17];
        tokens[0] = ".mdb";
        tokens[1] = "cmd.exe";
        tokens[2] = "fuck.php";
        tokens[3] = "fck_select.html";
        tokens[4] = "cao.php";
        tokens[5] = "inc.asp.bak";
        tokens[6] = "ydxzdate.asa";
        tokens[7] = "1.asp.asa";
        tokens[8] = "a.asp;(1).jpg";
        tokens[9] = "360.aspx";
        tokens[10] = "6qv4myup.aspx";
        tokens[11] = "DataShop).aspx";
        tokens[12] = "admin_.aspx";
        tokens[13] = "CEO.jsp";
        tokens[14] = "admin/go.jsp";
        tokens[15] = "install/install.jsp";
        tokens[16] = "readme.txt";

        for (String s: tokens
                ) {
            if(str.contains(s))
                return "路径扫描";
        }
        return "Nothing";

    }
    public static void main(String[] args) {
        AttackClassifyPathScanUDF test = new AttackClassifyPathScanUDF();
        System.out.println(test.evaluate("select * from  by readme.txt "));
    }
}
