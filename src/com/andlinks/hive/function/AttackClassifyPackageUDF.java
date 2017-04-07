package com.andlinks.hive.function;

/**
 * Created by suyu on 17-4-6.
 */
public class AttackClassifyPackageUDF {
    public int evaluate(String str) {
        int result = 0;

        String[] tokens= new String[14];
        tokens[0] = "\\..\\..\\..\\..\\..\\..\\..\\..";
        tokens[1] = "/../../../../../../";
        tokens[2] = "\\\\..\\\\..\\\\..\\\\..\\\\..\\\\..\\\\..\\\\..\\\\";
        tokens[3] = "/\\..\\..\\..\\..\\";
        tokens[4] = "/????/????/????/????/????/????/????/????";
        tokens[5] = "/..??..??..??..??..??..";
        tokens[6] = "/..?..?..?..?..?..?..?.";
        tokens[7] = "./././././././././././././././.";
        tokens[8] = "boot.ini";
        tokens[9] = "win.ini";
        tokens[10] = "/windows/win.ini";
        tokens[11] = "/etc/passwd";
        tokens[12] = "/WEB-INF/web.xml";
        tokens[13] = "//../....//....//WEB-INF/web.xml";

        for (String s: tokens
                ) {
            if(str.contains(s))
                return 1;
        }
        return result;

    }
    public static void main(String[] args) {
        AttackClassifyPackageUDF test = new AttackClassifyPackageUDF();
        System.out.println(test.evaluate("select * from  by "));
    }
}
