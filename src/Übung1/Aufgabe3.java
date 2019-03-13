package Übung1;

import java.math.BigInteger;
import java.util.LinkedList;

public class Aufgabe3 {

    public static void main(String[] args) {
        for(int k=1;k<10;k++){
            boolean run=true;
            BigInteger n=BigInteger.valueOf(7);
            LinkedList<BigInteger> ll=new LinkedList<>();
            int i;
        for(i=0;run;i++){
            System.out.println(n);
            if(ll.contains(n)){
                System.out.println("Does not halt for "+k+" loops at "+n);
                break;
            }
            ll.add(n);
            if(n.equals(BigInteger.ONE)) {run=false;}
            else if(!n.testBit(0)){n=n.divide(BigInteger.valueOf(2));}
            else {n=(n.multiply(BigInteger.valueOf(5)).add(BigInteger.ONE));}
        }
            if(!run) System.out.println(k+": "+i);
    }

    }
}
