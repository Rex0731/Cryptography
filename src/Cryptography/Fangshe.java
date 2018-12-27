package Cryptography;
import java.util.*;
public class Fangshe {
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.println("输入明文x");
        String x=s.nextLine();
        System.out.println("输入a");
        int a=s.nextInt();
        System.out.println("输入b");
        int b=s.nextInt();
        System.out.println("加密后的密文为：");
        String ch=Encrypt(x,a,b);
        System.out.println(ch);
    }
    public static String Encrypt(String x,int a,int b) //加密，最后要返回加密后的内容
    {
        char [] ch=x.toCharArray();
        int length=ch.length;
        int []in=new int [length];
        for(int i=0;i<length;i++)
        {
            in[i]=ch[i]-97;  //char
        }
        for(int i=0;i<length;i++)
        {
            in[i]=(in[i]*a+b)%26;
        }
        for(int i=0;i<length;i++)
        {
            ch[i]=(char) ( in[i]+65);

        }

        return String.valueOf(ch);
    }

}
