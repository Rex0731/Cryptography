package Cryptography;
import java.util.*;
public class Vigenere {
    public static void main(String []args)
    {
        Scanner s=new Scanner(System.in);
        System.out.println("输入明文");
        String m=s.nextLine();
        System.out.println("输入密钥");
        String k=s.next();;
        System.out.println("输出的密文是：");
        System.out.println(Encrypt(m,k));
    }
    public static String Encrypt(String m,String k)
    {
        char []ch=k.toCharArray();
        char []ch1=m.toCharArray();
        int length=ch.length;
        int length1=ch1.length;
        int mn[]=new int[length1];
        int kn[]=new int[length];
        for(int i=0;i<length;i++)
        {
            kn[i]=ch[i]-97;
        }
        for(int i=0;i<length1;i++)
        {
            mn[i]=ch1[i]-97;
        }
        int j=0;
        for(int i=0;i<length1;i++)
        {
            if(j==length)
                j=0;
            mn[i]=(mn[i]+kn[j])%26; //这里引入的j是核心，使得kn始终按着0-7运行
            j++;

        }
        for(int i=0;i<length1;i++)
        {
            ch1[i]=(char) (mn[i]+65);
        }
        return String.valueOf(ch1);


    }


}
