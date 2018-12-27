package p1;
import java.util.*;


   class Person {
    public int Id;
    public String Name;
    public String Sex;
    public Person()
    {
        Id=0;
        Name="";
        Sex="";

    }
    public Person(int id,String name,String sex)
    {
        Id=id;
        Name=name;
        Sex=sex;
    }
    public int getId(){return Id;}
    public String getName(){return Name;}
    public void setId(int id){Id=id;}
    public void setName(String name){Name=name;}
 }

  class Teacher extends Person
 {

     public String School;
     public Teacher(int id,String name,String sex,String school)
     {
         super(id,name,sex);
         School=school;
     }
     public void setSchool(String s){School=s;}
     public String getSchool(){return School;}
 }
  public class Student extends Person  //一个.java文件只能有一个public ，而且此类名字作为.java文件的名字
 {
     public String Class;
     public Student(int id,String name ,String sex, String c) //构造函数也要变成public 才能在包外调用
     {
         super(id,name,sex);
         Class=c;
     }
     public void setClass(String c){Class=c;}
     public String getclass(){return Class;}

 }


