package Cryptography;

import sun.misc.BASE64Encoder;

import java.security.SecureRandom;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;
import java.util.*;






public class DES
{
    public DES()
    {

    }
    public static void main(String args[])
    {
        System.out.println("输入要加密的内容：");
        Scanner s=new Scanner(System.in);
        String m=s.next();
        System.out.println("输入你的秘钥：");
        String k=s.next();
        String r=jdkBase64String(DES.encrypt(m,k));
        System.out.println("加密后的内容是："+r);
    }

//使用SecretKeyFactory,DESKeySpec,Cipher类
    public static byte[] encrypt(String m,String k){
        try{               //注意try还是在{括号里面
            //以下三行是获取秘钥
            DESKeySpec deskey=new DESKeySpec(k.getBytes("utf-8"));
            SecretKeyFactory keyFactory=SecretKeyFactory.getInstance("DES");//这个地方没有使用new ，注意下
            SecretKey key=keyFactory.generateSecret(deskey);
            Cipher cipher=Cipher.getInstance("DES"); //可以选择"DES/CFB/NOPADDING"
            cipher.init(Cipher.ENCRYPT_MODE,key); //加密模式选择
            return cipher.doFinal(m.getBytes("utf-8")); //加密明文

        }catch (Throwable e)
        {
            e.printStackTrace();
        }
        return  null;
    }
    public static String jdkBase64String(byte[] s) {  //使用base64编码，解决乱码输出的问题
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(s);
    }

}
//注意encrypt 函数有三种写法
/*第一种：最简洁的 使用SecretKey,SecretKeySpec,Cipher类
public static byte[] encrypt(String m,String k)
    {
        try{
            SecretKey secretKey=new SecretKeySpec(k.getBytes("utf-8"),"DES");
            Cipher cipher=Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            return  cipher.doFinal(m.getBytes("utf-8"));


        }catch (Throwable e)
        {
            e.printStackTrace();
        }
        return null;
    }
/*使用key generator
public static byte[] encrypt(String m,String k)
    {
        try{
            KeyGenerator keyGen=KeyGenerator.getInstance("DES"); 使用不固定的秘钥，每次加密值都不一样
            SecureRandom random= new SecureRandom();
            keyGen.init(56,random);
            SecretKey secretKey=keyGen.generateKey();
            byte[] key=secretKey.getEncoded();
            SecretKey secretKey=new SecretKeySpec(key,"DES");
            Cipher cipher=Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            return  cipher.doFinal(m.getBytes("utf-8"));


        }catch (Throwable e)
        {
            e.printStackTrace();
        }
        return null;
    }
 */