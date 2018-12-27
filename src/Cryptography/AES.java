package Cryptography;

import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;
import java.security.SecureRandom;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Encoder;
public class AES {
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.println("输入明文：");
        String m=s.next();
        String r=base64Encode(encrypt(m));
        System.out.println("输出的密文是："+r);
    }
    public static String base64Encode(byte []a)
    {
        BASE64Encoder e=new BASE64Encoder();
        return (e.encode(a));
    }
    public static byte [] encrypt(String m)
    {
        try{
            KeyGenerator keyGen=KeyGenerator.getInstance("AES"); //使用不固定的秘钥，每次加密值都不一样
            SecureRandom random= new SecureRandom();
            keyGen.init(192,random);
            SecretKey secretKey=keyGen.generateKey();
            byte[] key=secretKey.getEncoded();
            SecretKey secretKey1=new SecretKeySpec(key,"AES");
            Cipher cipher=Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE,secretKey1);
            return cipher.doFinal(m.getBytes("utf-8"));
        }catch (Throwable e)
        {
            e.printStackTrace();
        }
        return null;

    }
}
