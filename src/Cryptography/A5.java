package Cryptography;
import java.util.*;
public class A5 {
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.println("输入需要的秘钥长度：");
        int n=s.nextInt();
        System.out.println("输入明文：");
        String m=s.next();
        String w=Encrypt(n,m);
        System.out.println("加密后的密文是："+w);

    }
    public static String Encrypt(int n,String  m)
    {
        int x[]=new int[]{0,1,0,1,1,1,0,0,0,1,1,0,1,1,0,1,0,1,0,1};
        int y[]=new int[]{1,1,1,0,0,0,1,1,1,0,0,1,0,1,1,0,1,0,1,1,1,0,1};
        int z[]=new int[]{0,1,1,0,1,0,1,0,1,1,0,0,0,1,1,1,0,1,0,1,1,0,0,1};
        int c[]=new int[n]; //秘钥数组c
        for(int i=0;i<n;i++)
        {
            if(x[9]==y[11])
            {
                int a=x[13]^x[16]^x[17]^x[18];
                int b=y[12]^y[16]^y[20]^y[21];
                exchange(x,a);
                exchange(y,b);
                c[i]=x[18]^y[21]^z[22];
            }
            else if(x[9]==z[11])
            {
                int a=x[13]^x[16]^x[17]^x[18];
                int b=z[17]^z[18]^z[21]^z[22];
                exchange(x,a);
                exchange(z,b);
                c[i]=x[18]^y[21]^z[22];

            }
            else if(y[11]==z[11])
            {
                int a=y[12]^y[16]^y[20]^y[21];
                int b=z[17]^z[18]^z[21]^z[22];
                exchange(y,a);
                exchange(z,b);
                c[i]=x[18]^y[21]^z[22];
            }
        }
        char []ch=m.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            ch[i]=(char)(ch[i]^c[i]);
        }
        return String.valueOf(ch);

    }
    public static void exchange(int x[],int a)
    {
        for(int i=x.length-1;i>=1;i--)
        {
            x[i]=x[i-1];
        }
        x[0]=a;
    }

}
