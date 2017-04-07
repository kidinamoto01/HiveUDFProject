package com.andlinks.hive.function;

/**
 * Created by suyu on 17-4-2.
 */
public class AttackClassifyXssUDF {

    public int evaluate(String str) {
        int result = 0;

        String[] tokens= new String[21];
        tokens[0] = "\">";
        tokens[1] = "\"><script>";
        tokens[2] = "</textArea><script>";
        tokens[3] = ";//";
        tokens[4] = "alert%281%29";
        tokens[5] = "alert(1)";
        tokens[6] = "alert(";
        tokens[7] = "confirm(";
        tokens[8] = "confirm%281%29";
        tokens[9] = "prompt(";
        tokens[10] = "prompt%281%29";
        tokens[11] = "onMouseOver";
        tokens[12] = "document.location";
        tokens[13] = "document%2elocation%3d1";
        tokens[14] = "document.title=";
        tokens[15] = "document%2etitle%3d1";
        tokens[16] = "<a>";
        tokens[17] = "<script>alert(1)</script>";
        tokens[18] = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
        tokens[19] = "<xxx>";
        tokens[20] = "--><";

        for (String s: tokens
                ) {
            if(str.contains(s))
                return 1;
        }
        return result;

    }

    public static void main(String[] args) {
        AttackClassifyXssUDF test = new AttackClassifyXssUDF();
        System.out.println(test.evaluate("select * from test order by confirm("));
    }
}
