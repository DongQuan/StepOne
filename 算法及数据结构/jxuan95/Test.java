package jxuan95;

import java.util.*;

/**
 * Created by eisen on 16-9-11.
 */
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            in.nextLine();
            while (n >= 0) {
                String line = in.nextLine();
                String[] s = line.split(",");
                int[] temp = new int[s.length];
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = 0; i < s.length; i++) {
                    arrayList.add(Integer.parseInt(s[i]));
                }
                System.out.println(arrayList.get(0));
                System.out.println(arrayList.contains(5));
                System.out.println("   hello    ".trim());
                n--;
            }
        }
    }
}
