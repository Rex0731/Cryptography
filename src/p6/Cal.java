package p6;
import java.awt.*;
import javax.swing.*;
public class Cal {
    public Cal(String str)
    {
        JFrame f=new JFrame(str);
        Container c=f.getContentPane();
        f.setLayout(new GridLayout(4,1));
        TextField t1,t2,t3;
        t1=new TextField(20);
        t2=new TextField(20);
        t3=new TextField(20);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.setSize(250,100);
        f.pack();
        f.setVisible(true);
    }
    public static void main(String args[])
    {
        Cal c=new Cal("计算器");
    }

}
