package p2;

import p1.Student;

public class Classes
{
    public String ClassName;
    //List<Student> s = new ArrayList<Student>();

    Student[]s=new Student[2];
    public Classes (String classname)
    {
        ClassName=classname;
    }
    public void setStudent(Student s1,Student s2)
    {
        s[0]=s1;
        s[1]=s2;
    }
    public void getStudent(){
        System.out.println("班级名称：" + ClassName+"\n学生:("+s[0].Name+" "+s[1].Name+")"  );

    }

}
