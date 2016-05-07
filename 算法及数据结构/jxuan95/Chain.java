package jxuan95;

/**
 * Created by jxuan on 16-4-19.
 */
public class Chain {
    public static void main(String[] args){
        int countx = 0;
        int x = 9999;
        while(x>0){
            countx++;
            x=x&(x-1);
        }
        System.out.println(countx);
    }


}
