package p2;

import p2.Classes;
import p1.Student;

public class Main
{
    public static void main(String []args)
    {
        Classes c1=new Classes("classone");
        Student s1=new Student(1,"jack","male","classone");
        Student s2=new Student(2,"Rose","female","classone");
        c1.setStudent(s1,s2);
        c1.getStudent();
    }
}
