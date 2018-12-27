package Cryptography;

import java.util.*;
public class RC4     {
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int []S=new int [256];
        int []T=new int [256];
        System.out.println("输入明文：");
        String m=s.next();
        char []ch=m.toCharArray();
        int length1=ch.length;
        int []mw=new int[length1];
        System.out.println("input a n:");
        double a=s.nextDouble();
        double length2=Math.pow(2,a);
        int length=(int)(length2);
        System.out.println("input the length of K");
        int b=s.nextInt();
        int []K=new int [b];
        System.out.println("input K");
        for(int i=0;i<b;i++)
        {
            K[i]=s.nextInt();

        }
        for(int i=0;i<length;i++)
        {
            S[i]=i;
            T[i]=K[i % b];
        }
        int j=0;
        for(int i=0;i<length;i++)
        {
            j=((j+S[i]+T[i])% length);
            swap(S,i,j);

        }
        /*for(int i=0;i<length;i++)
        {
            //System.out.print(S[i]);
            System.out.print(T[i]);

        }*/


        int w=0,c=0;
        for(int i=0;i<length1;i++)
        {
            w=(w+1)%length;
            c=(c+S[w])%length;
            swap(S,w,c);
            int t=(S[w]+S[c])%length;
            mw[i]=(S[t]^ch[i])%26+97;
            ch[i]=(char)(mw[i]);

        }
        System.out.println("加密后的密文是：");
        for(int i=0;i<length1;i++)
        {
            System.out.print(ch[i]);
        }


    }
    public static void swap(int[] array,int x,int y){
        int xx = array[x];
        int yy = array[y];
        array[x] = yy;
        array[y] = xx;
    }


}

