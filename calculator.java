import java.applet.*;
import java.awt.event.*;
import java.awt.*;

public class calculator extends Applet implements ActionListener 
{
    Button AC,AB,Amod,Adiv,A7,A8,A9,Amul,A4,A5,A6,Aminus,A1,A2,A3,Aplus,A0,Adot,Aequal,CLOSE;
    TextField txt;
    String mainTxt="0";
    String ch="";
    double a=0.0;
    double b=0.0;
    int flag=0;
    public void init()
    {
        setLayout(new BorderLayout());
        txt=new TextField(16);
        add(txt,BorderLayout.NORTH);
        txt.setText(mainTxt);
        txt.addActionListener(this);

        Panel s=new Panel();

        s.setLayout(new GridLayout(5,4));
        AC =new Button("Clear");
        AB =new Button("back");
        Amod =new Button("%");
        Adiv =new Button("/");
        A7 =new Button("7");
        A8 =new Button("8");
        A9 =new Button("9");
        Amul =new Button("X");
        A4 =new Button("4");
        A5 =new Button("5");
        A6 =new Button("6");
        Aminus =new Button("-");
        A1 =new Button("1");
        A2 =new Button("2");
        A3 =new Button("3");
        Aplus =new Button("+");
        new Button("");
        A0 =new Button("0");
        Adot =new Button(".");
        Aequal =new Button("=");
        CLOSE=new Button("CLOSE");
        s.add(AC);
        AC.addActionListener(this);

        s.add(AB);
        AB.addActionListener(this);

        s.add(Amod);
        Amod.addActionListener(this);

        s.add(Adiv);
        Adiv.addActionListener(this);

        s.add(A7);
        A7.addActionListener(this);

        s.add(A8);
        A8.addActionListener(this);

        s.add(A9);
        A9.addActionListener(this);

        s.add(Amul);
        Amul.addActionListener(this);

        s.add(A4);
        A4.addActionListener(this);

        s.add(A5);
        A5.addActionListener(this);

        s.add(A6);
        A6.addActionListener(this);

        s.add(Aminus);
        Aminus.addActionListener(this);

        s.add(A1);
        A1.addActionListener(this);

        s.add(A2);
        A2.addActionListener(this);

        s.add(A3);
        A3.addActionListener(this);

        s.add(Aplus);
        Aplus.addActionListener(this);

        s.add(CLOSE);
        CLOSE.addActionListener(this);

        s.add(A0);
        A0.addActionListener(this);

        s.add(Adot);
        Adot.addActionListener(this);

        s.add(Aequal);
        Aequal.addActionListener(this);

        add(s,BorderLayout.CENTER);

    }

    
    public void actionPerformed(ActionEvent ae)
    {
        if(mainTxt.equals("infinity"))
        mainTxt="0";
        String str=ae.getActionCommand();
        if(str.equals("0"))
            mainTxt=mainTxt+"0";
        if(str.equals("1"))
            mainTxt=mainTxt+"1";
        if(str.equals("2"))
            mainTxt=mainTxt+"2";
        if(str.equals("3"))
            mainTxt=mainTxt+"3";
        if(str.equals("4"))
            mainTxt=mainTxt+"4";
        if(str.equals("5"))
            mainTxt=mainTxt+"5";
        if(str.equals("6"))
            mainTxt=mainTxt+"6";
        if(str.equals("7"))
            mainTxt=mainTxt+"7";
        if(str.equals("8"))
            mainTxt=mainTxt+"8";
        if(str.equals("9"))
            mainTxt=mainTxt+"9";
        if(str.equals("."))
            mainTxt=mainTxt+".";

        if(str.equals("%")||str.equals("/")||str.equals("X")||str.equals("-")||str.equals("+"))
        {
            a=Double.parseDouble(mainTxt);
            mainTxt="0";
            ch=str;
            flag=1;
        }

        if(str.equals("="))
        {
            if(flag==1)
            {
                b=Double.parseDouble(mainTxt);
                calculator ob=new calculator();
                String c=ob.cal(a,b,ch);
                if(c.equals("infinity"))
                    mainTxt="infinity";
                else
                    mainTxt=c;
                flag=0;
            }
        }

        if(str.equals("Clear"))
        {
            flag=0;
            mainTxt="0";
        }

        if(str.equals("back"))
        {
            mainTxt=mainTxt.substring(0,(mainTxt.length()-1));
            if(mainTxt.charAt(mainTxt.length()-1)=='.')
            mainTxt=mainTxt.substring(0,mainTxt.length()-1);
        }
 
        int i=0;
        while(i<mainTxt.length()-1&&mainTxt.length()>1)
        {
            if(mainTxt.charAt(i)=='0')
            i++;
            else
            break;
        }
        mainTxt=mainTxt.substring(i);
        
        txt.setText(mainTxt);
        
    }
    
    public void paint(Graphics g)
    {
        setVisible(true);
        g.drawString("thank you",100,100);
    }
    
    String cal(double a,double b,String choice)
    {
        String res="";
        char chi=choice.charAt(0);
        switch(chi)
        {
            case '+':
            res=Double.toString(a+b);
            break;
            case '-':
            res=Double.toString(a-b);
            break;
            case 'X':
            res=Double.toString(a*b);
            break;
            case '/':
            if(b==0.0)
                res="infinity";
            else
                res=Double.toString(a/b);
            break;
            case '%':
            if(b==0.0)
                res="infinity";
            else
                res=Double.toString(a%b);
            break;
        }
        return(res);
    }
}
