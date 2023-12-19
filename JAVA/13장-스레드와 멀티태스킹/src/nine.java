import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class nine extends JFrame{				//������
	private MyPanel panel=new MyPanel();
	public nine() {
		setTitle("�����带 ���� �׺�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(880,420);//Frame ȭ���߾ӿ� ����
		
		setContentPane(panel);
		
		setSize(600,400);
		setVisible(true);
	}
	class MyPanel extends JPanel implements Runnable{
		private JLabel []label=new JLabel[3];
		private int []random=new int[3];
		private boolean flag=false;
		private JLabel text;
		public MyPanel() {							//�г�
			setLayout(null);
			setLabel();
			addMouseListener(new MyMouseListener());
			
			
			Thread th=new Thread(this);
			th.start();
		}
		synchronized public void start() {			//����
			flag=true;
			this.notify();
		}
		synchronized public void waitForStart() {	//���
			if(!flag)
				try {this.wait();}catch(InterruptedException e) {return;}
		}
		public void run() {							//������
			while(true) {
				waitForStart();
			try {for(int i=0;i<3;i++) {
				int tmp=(int)(Math.random()*3);		//����Ǽ��� �ʹ� ���Ƽ� 3��(0,1,2)�� ����
				label[i].setText(Integer.toString(tmp));
				Thread.sleep(200);}
				if(label[0].getText().equals(label[1].getText())&&label[1].getText().equals(label[2].getText()))
					text.setText("�����մϴ�!!");
				else
					text.setText("�ƽ�����");
				flag=false;}
			catch(InterruptedException e) {return;}
		}}
		public void setLabel() {					//�� ����
			for(int i=0;i<label.length;i++) {
				label[i]=new JLabel("0");
				label[i].setSize(120,100);
				label[i].setHorizontalAlignment(JLabel.CENTER);
				label[i].setFont(new Font("Serif",Font.BOLD,100));
				label[i].setLocation(60+180*i,50);
				label[i].setForeground(Color.yellow);
				label[i].setBackground(Color.magenta);
				label[i].setOpaque(true);
				add(label[i]);
			}
			text=new JLabel("���콺�� Ŭ���� �� ���� �����մϴ�.");
			text.setSize(400,100);
			text.setHorizontalAlignment(JLabel.CENTER);
			text.setForeground(Color.black);
			text.setFont(new Font("Serif",Font.BOLD,20));
			text.setLocation(100,200);
			add(text);
		}
	}
	class MyMouseListener extends MouseAdapter{		//������ ����
		public void mouseClicked(MouseEvent e) {
			panel.start();
		}
	}
	public static void main(String[]args) {
		new nine();
	}
}
