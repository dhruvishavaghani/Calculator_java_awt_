
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class My_calc1 extends WindowAdapter implements ActionListener {
  Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16;
  Label l1;
  Frame f;
  
    String s1="";
    
    int n=0;
    int i=0;
    
     Queue<Character>q = new LinkedList<>();
     Queue<Integer>q1 = new LinkedList<>();


  My_calc1() 
  {
    f=new Frame("calculator");
    f.setSize(600,800);
    f.setVisible(true);
    f.setLayout(null);
    f.setBackground(Color.lightGray);
    f.addWindowListener(this);
    f.setFont(f.getFont().deriveFont(20f));

    l1=new Label(); 
    l1.setBackground(Color.gray);
    l1.setBounds(50,80,500,150);
    

    b16 = new Button("=");
    b1 = new Button("1");
    b2 = new Button("2");
    b3 = new Button("3");
    b4 = new Button("4");
    b5 = new Button("5");
    b6 = new Button("6");
    b7 = new Button("7");
    b8 = new Button("8");
    b9 = new Button("9");
    b10 = new Button("0");
    b11 = new Button("+");
    b12 = new Button("-");
    b13 = new Button("*");
    b14 = new Button("/");
    b15 = new Button("ON/OFF");
    
    b1.setBounds(50,270,100,100);
    b2.setBounds(183,270,100,100);
    b3.setBounds(316,270,100,100);
    b15.setBounds(449,270,100,100);
    b4.setBounds(50,400,100,100);
    b5.setBounds(183,400,100,100);
    b6.setBounds(316,400,100,100);
    b11.setBounds(449,400,100,100);
    b7.setBounds(50,530,100,100);
    b8.setBounds(183,530,100,100);
    b9.setBounds(316,530,100,100);
    b12.setBounds(449,530,100,100);
    b10.setBounds(50,660,100,100);
    b13.setBounds(316,660,100,100);
    b14.setBounds(183,660,100,100);
    b16.setBounds(449,660,100,100);
    
    
    f.add(b16);
    f.add(b1);
    f.add(b2);
    f.add(b3);
    f.add(b15);
    f.add(b4);
    f.add(b5);
    f.add(b6);
    f.add(b11);
    f.add(b7);
    f.add(b8);
    f.add(b9);
    f.add(b12);
    f.add(b10);
    f.add(b13);
    f.add(b14);
    f.add(l1);
    //b1.setForeground(Color.GRAY);

    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    b6.addActionListener(this);
    b7.addActionListener(this);
    b8.addActionListener(this);
    b9.addActionListener(this);
    b10.addActionListener(this);
    b11.addActionListener(this);
    b12.addActionListener(this);
    b13.addActionListener(this);
    b14.addActionListener(this);
    b15.addActionListener(this);
    b16.addActionListener(this);

  }
    
    public void windowClosing(WindowEvent e) 
     {
       f.dispose();
     }

  public void actionPerformed(ActionEvent e) 
  {

    if(e.getActionCommand().equals("="))
    {
            l1.setText(s1);
            int l=s1.length();
            StringTokenizer st1=new StringTokenizer(s1,"+*/-");

          while(i<l)
        {
            if(s1.charAt(i)=='+')
           {
            q.add(s1.charAt(i));
           }
            if(s1.charAt(i)=='-')
           {
           q.add(s1.charAt(i));
           }
            if(s1.charAt(i)=='*')
           {
           q.add(s1.charAt(i));
           }
            if(s1.charAt(i)=='/')
           {
           q.add(s1.charAt(i));
           }     
             i++;
        }
    
           while(st1.hasMoreTokens())
            {
                q1.add(Integer.parseInt(st1.nextToken()));
            }
     
        Iterator iterator = q1.iterator();
        n=n+q1.peek();
        q1.remove();
 
           while(iterator.hasNext())
          {
              if(q.peek()=='+')
              {
                  n=n+(q1.peek());
                  q.remove();
                  q1.remove();
              }
              else if(q.peek()=='-')
              {
                  n=n-(q1.peek());
                  q.remove();
                  q1.remove();
              }
             else if(q.peek()=='*')
              {
                   n=n*(q1.peek());
                   q.remove();
                   q1.remove();
              }
            else if(q.peek()=='/')
              {
                   n=n/(q1.peek());
                   q.remove();
                  q1.remove();
              }
          }
        l1.setText(Integer.toString(n));
  }
    
    else if (e.getSource() == b15)
     {
      s1 = "";
      l1.setText(s1);
     } 
    else 
     {
      s1+=e.getActionCommand();
      l1.setText(s1);
     }
 }

  public static void main(String[] args) {
    My_calc1 c = new My_calc1();
  }

}