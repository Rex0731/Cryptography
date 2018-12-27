package Cryptography;
import java.security.MessageDigest;
import java.util.Scanner;
import java.math.BigInteger;
public class MD5 {
    public static void main(String args[])
    {
        System.out.println("输入明文：");
        Scanner s=new Scanner(System.in);
        String text=s.next();
        String r=md5(text);
        System.out.println("密文是:"+r);

    }
    public static String md5(String text)
    {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try{
           byte []bt=text.getBytes();
           MessageDigest md=MessageDigest.getInstance("MD5");
           md.update(bt);
           byte [] c=md.digest();
           int j=c.length;
           char str[]=new char[j*2];
           int k=0;
           for(int i=0;i<j;i++)
           {
               byte byte0=c[i];
               str[k++]=hexDigits[byte0>>>4 & 0xf];
               str[k++] = hexDigits[byte0 & 0xf];
           }
           return new String(str);
        }catch (Throwable e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
