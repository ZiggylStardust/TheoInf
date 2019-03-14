package Übung1;

import java.math.BigInteger;

public class Aufgabe5 {
    public static void main(String[] args) {

        for (int i = 64; i < 1000; i++) {

            System.out.println(i + "  " + (f(i) + f(2 * i + 1)));
        }
    }


    /**
     * Zahlenfolgen sind:
     * 0 1 3 7 15 31...
     *  2 5 11 23 47...
     *   4 9 19 39 79...
     *   ...
     *   Die Startzahlen sind immer gerade zahlen (ungerade sind immer in früheren reihen)
     *   Jede zahl lässt sich beschreiben durch 2(2(2n)+1)+1... usw.
     *   ist gleich m*2^k+2^(k-1)-1, k,m in N
     *   k beschreibt die Position der zahl in der reihe, n die reihe selbst
     *   Da jede zweite zahl anders sein muss, ist diese Zahlereihe:
     *   m*2^(2k+1)+2^((2k+1)-1)-1
     *   eine zahl kann nich in einer Reihe tiefer als die Zahl sein, da ungerade Zahlen von einer Reihe mit geraden
     *   zahlen erzeugt werden, und der index der Reihe kleiner/gleich der generator zahl ist
     *
     *
     * @param n
     * @return  entweder 1 oder 0. 1 bei geraden zahlen, und jedem zweiten elment der reihe, sonnst 0:
     */
    public static long f(long n){
        if (n%2==0) return 1;
        for(int i=0;i<n;i++){
            boolean run=true;
            for(int k=2;run;k=k+2){
                int exponent=k;
                long calc=i*(1l<<exponent)+(1l<<(exponent-1l))-1;
                if(calc>n) run=false;
                if(calc==n) return 0;
            }
        }
        return 1;

    }

    /**
     * 2n+1=k-->n=(k-1)/2
     * @param n
     * @return 0 für gerade und jedes zweite von diversen
     */
    public static int f2(int n){
        int i=1;
        for(;n%2==1;i++,n=(n-1)/2){}
        if(i%2==0) return 1;
        return 0;

    }


    public static long f3(long n){
        if (n%2==0) return 1;
        for(int i=0;i<n;i++){
            boolean run=true;
            long cacl3=2*i;
            for(;run;cacl3=2*(2*cacl3+1)+1){
                //int exponent=k;
                //BigInteger calc=BigInteger.valueOf(i).multiply(BigInteger.ONE.shiftLeft(exponent)).add(BigInteger.ONE.shiftLeft(exponent-1).add(BigInteger.valueOf(-1)));
                //if(calc.compareTo(BigInteger.valueOf(n))==1) run=false;
                //if(calc.equals(BigInteger.valueOf(n))) return 0;
                if(cacl3>n)run=false;
                if(cacl3<0) System.out.println("error");
                if(cacl3==n) return 1;

            }
        }
        return 0;

    }
}
