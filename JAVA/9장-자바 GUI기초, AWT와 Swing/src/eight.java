import javax.swing.*;
import java.awt.*;
@SuppressWarnings("serial")
public class eight extends JFrame{
	public eight(String name) {
		setTitle(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		
		jp1.setBackground(Color.lightGray);
		jp1.add(new JButton("����"));
		jp1.add(new JButton("�ݱ�"));
		jp1.add(new JButton("������"));
		
		jp2.setBackground(Color.white);
		jp2.setLayout(null);
		for(int i=0;i<10;i++) {
			JLabel j=new JLabel("*");
			j.setForeground(Color.red);	
			int x=(int)(Math.random()*390);
			int y=(int)(Math.random()*280);
			j.setLocation(x,y);	
			j.setSize(10,10);
			jp2.add(j);
		}
		
		jp3.add(new JButton("Word Input"));
		jp3.add(new JTextField(20));
		
		Container c=getContentPane();
		c.add(jp1,BorderLayout.NORTH);
		c.add(jp2,BorderLayout.CENTER);
		c.add(jp3,BorderLayout.SOUTH);
		
		setSize(400,400);
		setVisible(true);
	}
	public static void main(String[]args) {
		new eight("���� ���� �г��� ���� ������");
	}
}
