package jxuan95;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by eisen on 16-9-13.
 * 百度算法2，search in xml
 * <recipe>
 * <recipename>Ice Cream Sundae</recipename>
 * <ingredlist>
 * <listitem>
 * <quantity>3</quantity>
 * <itemdescription>chocolate syrup or chocolate fudge</itemdescription>
 * </listitem>
 * <listitem>
 * <quantity>1</quantity>
 * <itemdescription>nuts</itemdescription>
 * </listitem>
 * <listitem>
 * <quantity>1</quantity>
 * <itemdescription>cherry</itemdescription>
 * </listitem>
 * </ingredlist>
 * <preptime>5 minutes</preptime>
 * </recipe>
 * <listitem><quantity></quantity></listitem>
 *
 * 3
 4 7 10
 */
public class baiduoj2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            ArrayList<String> arrayList = new ArrayList<>();
            String line = in.nextLine();
            while (true) {
                String next = in.nextLine();

                if (next.equals("</recipe>")) {
                    break;
                }
                arrayList.add(next);
            }
            String m = in.nextLine();
            String[] mtemp = m.split("><");
            int num = mtemp.length / 2;

            for (int i = 0; i < mtemp.length; i++) {
                mtemp[i] = mtemp[i].replace("<", "");
                mtemp[i] = mtemp[i].replace(">", "");
                mtemp[i] = mtemp[i].replace("/", "");
            }


            int count = 0;
            for (int i = 0, len = arrayList.size(); i < len; i++) {
                for (int j = 0; j < mtemp.length; j++) {

                }
            }
        }
    }
}
