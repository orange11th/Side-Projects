import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends JFrame {
	protected Container c;
	protected JTextField JTrNum, JTnum, JTCalc;
	protected JTextField[] JT;
	protected JButton input, add, calc;
	protected JRadioButton DV, Dijkstra, RIP, IGRP, OSPF;
	protected JRadioButton[] JB;
	protected String[] labels = { "��߳��,�������,metric(����O)", "��߳��,�������,metric", "��߳��,�������(ȩ ���� ���)", 
			"��߳��,�������,�뿪��,����","��߳��,�������,�뿪��,����" };
	protected String[] JBName = { "�Ÿ� ����", "���ͽ�Ʈ��", "RIP", "IGRP", "OSPF" };
	protected JLabel introduce, name, select, search, JLrNum, JLnum, jl;
	protected RouterDialog dialog;
	protected Dijkstra d;
	protected Bellman_Ford b;
	protected int rNum, num, flag;
	protected JTextArea JA;
	protected ArrayList<String> ansList;
	protected List<Edge> edges;
	// ȭ�� ũ�� ������
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double Displaywidth = screenSize.getWidth();
	double Displayheight = screenSize.getHeight();
	// ���α׷� ũ�� ����
	int SizeX = 800;
	int SizeY = 600;

	public Main() {
		setTitle("����� �ùķ�����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		c = getContentPane();

		c.setLayout(null);

		// ���α׷� �Ұ� Y=15~45
		introduce = new JLabel("����� �ùķ�����");
		introduce.setFont(new Font("SansSerif", Font.BOLD, 30));
		introduce.setBounds(240, 15, 300, 30);
		c.add(introduce);
		// �̸� �й�
		name = new JLabel("B889056 ��ȿ��");
		name.setFont(new Font("SansSerif", Font.BOLD, 13));
		name.setBackground(Color.pink);
		name.setOpaque(true);
		name.setBounds(520, 32, 100, 13);
		c.add(name);
		// ���� ��ư ����
		select = new JLabel("����� ���������� �����ϼ���.");
		select.setFont(new Font("SansSerif", Font.BOLD, 15));
		select.setBounds(260, 70, 300, 15);
		c.add(select);
		// ������ư ����
		ButtonGroup group = new ButtonGroup();// ��ư �׷� ��ü ����
		JB = new JRadioButton[5];
		for (int i = 0; i < JB.length; i++) {
			JB[i] = new JRadioButton(JBName[i]);
			group.add(JB[i]);
			JB[i].addItemListener(new MyItemListener());
			JB[i].setBounds(100 + 120 * i, 90, 100, 30);
			c.add(JB[i]);
		}
		// ����� ���� �Է� ����
		JLrNum = new JLabel("��� ����(�ִ� 8��):");
		JLrNum.setFont(new Font("SansSerif", Font.BOLD, 15));
		JLrNum.setBounds(160, 130, 140, 15);
		JLrNum.setVisible(false);
		c.add(JLrNum);
		// ����� ���� �Է� ĭ
		JTrNum = new JTextField(10);
		JTrNum.setBounds(300, 130, 60, 15);
		JTrNum.setVisible(false);
		c.add(JTrNum);
		// ���� ���� �Է� ����
		JLnum = new JLabel("���� ����:");
		JLnum.setFont(new Font("SansSerif", Font.BOLD, 15));
		JLnum.setBounds(380, 130, 70, 15);
		JLnum.setVisible(false);
		c.add(JLnum);
		// ���� ���� �Է� ĭ
		JTnum = new JTextField(10);
		JTnum.setBounds(450, 130, 60, 15);
		JTnum.setVisible(false);
		c.add(JTnum);

		input = new JButton("�Է�");
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					num = Integer.parseInt(JTnum.getText());
				} catch (NumberFormatException e1) {
					num = 0;
					rNum=0;
				}
				try {
					rNum = Integer.parseInt(JTrNum.getText());
				} catch (NumberFormatException e1) {
					rNum = 0;
					num=0;
				}
				search.setVisible(false);
				JTCalc.setVisible(false);
				calc.setVisible(false);
				dialog = new RouterDialog(num);
				dialog.setVisible(true);
			}
		});
		input.setBounds(520, 130, 60, 15);
		input.setVisible(false);
		c.add(input);

		search = new JLabel("��θ� �˻��� ���( , �� �ߺ� �Է� ����)");
		search.setBounds(155, 170, 300, 15);
		search.setFont(new Font("SansSerif", Font.BOLD, 15));
		search.setVisible(false);
		c.add(search);

		JTCalc = new JTextField(15);
		JTCalc.setBounds(430, 170, 80, 15);
		JTCalc.setVisible(false);
		c.add(JTCalc);

		calc = new JButton("�˻�");
		calc.setBounds(515, 170, 60, 15);
		calc.addActionListener(new calcActionListener());
		calc.setVisible(false);
		c.add(calc);

		JA = new JTextArea();
		JA.setFont(new Font("SansSerif", Font.BOLD, 20));
		JScrollPane scrollPane = new JScrollPane(JA);
		scrollPane.setBounds(50, 200, 685, 330);
		c.add(scrollPane);

		setResizable(false);
		setLocation(((int) Displaywidth - SizeX) / 2, ((int) Displayheight - SizeY) / 2);// ���α׷� ȭ�� �߾� ���
		setSize(SizeX, SizeY);
		setVisible(true);
	}

	// ������ư ������
	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.DESELECTED)
				return;
			JLrNum.setVisible(true);
			JTrNum.setVisible(true);
			JLnum.setVisible(true);
			JTnum.setVisible(true);
			input.setVisible(true);
			if (JB[0].isSelected()) {// �Ÿ� ����
				flag = 0;
				JTrNum.setText("");
				JTnum.setText("");
				JA.setText("");
				search.setVisible(false);
				JTCalc.setVisible(false);
				calc.setVisible(false);
			} else if (JB[1].isSelected()) {// ���ͽ�Ʈ��
				flag = 1;
				JTrNum.setText("");
				JTnum.setText("");
				JA.setText("");
				search.setVisible(false);
				JTCalc.setVisible(false);
				calc.setVisible(false);
			} else if (JB[2].isSelected()) {// RIP
				flag = 2;
				JTrNum.setText("");
				JTnum.setText("");
				JA.setText("");
				search.setVisible(false);
				JTCalc.setVisible(false);
				calc.setVisible(false);
			} else if (JB[3].isSelected()) {// IGRP
				flag = 3;
				JTrNum.setText("");
				JTnum.setText("");
				JA.setText("");
				search.setVisible(false);
				JTCalc.setVisible(false);
				calc.setVisible(false);
			} else if (JB[4].isSelected()) {// OSPF
				flag = 4;
				JTrNum.setText("");
				JTnum.setText("");
				JA.setText("");
				search.setVisible(false);
				JTCalc.setVisible(false);
				calc.setVisible(false);
			}
		}
	}

	// ���̾�׷�
	class RouterDialog extends JDialog {
		String[] s = { "�Է� ����" };

		public RouterDialog(int num) {
			setTitle("�ҹ��ڷ� �Է�! ex) a,b,5");
			setLayout(new FlowLayout());
			jl = new JLabel(labels[flag]);

			jl.setFont(new Font("Serif", Font.BOLD, 15));
			add(jl);
			JT = new JTextField[num];
			for (int i = 0; i < JT.length; i++) {
				JT[i] = new JTextField(15);
				add(JT[i]);
			}
			JButton btn = new JButton("�Է�");
			btn.addActionListener(new MyActionListener());
			add(btn);

			if (num == 0||rNum==0) {
				jl.setText(s[0]);
				btn.setText("���ư���");
			}
			setSize(250, 100 + num * 30);
			setLocation(((int) Displaywidth - 250) / 2, ((int) Displayheight - (100 + num * 30)) / 2);
		}
	}

	// ���̾�׷� ��ư ������
	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(num==0||rNum==0) {
				dialog.setVisible(false);
				return;}
			// TODO Auto-generated method stub
			JA.setText("");
			JTCalc.setText("");
			switch (flag) {
			case 0:
				try {
					edges = new ArrayList<Edge>();
					for (int i = 0; i < num; i++) {
						Scanner sc = new Scanner(JT[i].getText()).useDelimiter(",");
						edges.add(
								new Edge((int) sc.next().charAt(0) - 97, (int) sc.next().charAt(0) - 97, sc.nextInt()));
					}
				} catch (Exception e2) {
					dialog.setVisible(false);
					break;
				}
				dialog.setVisible(false);
				search.setVisible(true);
				JTCalc.setVisible(true);
				calc.setVisible(true);
				break;
			case 1:
				try {
					d = new Dijkstra(rNum);
					ArrayList<st> struct = new ArrayList<st>();
					for (int i = 0; i < num; i++) {
						Scanner sc = new Scanner(JT[i].getText()).useDelimiter(",");
						struct.add(new st(sc.next(), sc.next(), sc.nextInt()));
						d.input(struct.get(i).source, struct.get(i).destination, struct.get(i).metric);
					}
				} catch (Exception e2) {
					dialog.setVisible(false);
					break;
				}
				dialog.setVisible(false);
				search.setVisible(true);
				JTCalc.setVisible(true);
				calc.setVisible(true);
				break;
			case 2://RIP
				try {
					edges = new ArrayList<Edge>();
					String s1,s2;
					for (int i = 0; i < num; i++) {
						Scanner sc = new Scanner(JT[i].getText()).useDelimiter(",");
						s1=sc.next();
						s2=sc.next();
						edges.add(new Edge((int) s1.charAt(0) - 97, s2.charAt(0) - 97, 1));
						edges.add(new Edge((int) s2.charAt(0) - 97, s1.charAt(0) - 97, 1));
					}
				} catch (Exception e2) {
					dialog.setVisible(false);
					break;
				}
				dialog.setVisible(false);
				search.setVisible(true);
				JTCalc.setVisible(true);
				calc.setVisible(true);
				break;
			case 3:
				try {
					edges = new ArrayList<Edge>();
					String s1,s2;
					int i1,bandwidth,delay;
					for (int i = 0; i < num; i++) {
						Scanner sc = new Scanner(JT[i].getText()).useDelimiter(",");
						s1=sc.next();
						s2=sc.next();
						bandwidth=sc.nextInt();
						delay=sc.nextInt();
						if(bandwidth==0||delay==0)
							i1=0;
						else
							i1=(int) Math.pow(10, 7) / bandwidth + delay / 10;
						edges.add(new Edge((int) s1.charAt(0) - 97, s2.charAt(0) - 97, i1));
						edges.add(new Edge((int) s2.charAt(0) - 97, s1.charAt(0) - 97, i1));
					}
				} catch (Exception e2) {
					dialog.setVisible(false);
					break;
				}
				dialog.setVisible(false);
				search.setVisible(true);
				JTCalc.setVisible(true);
				calc.setVisible(true);
				break;
			case 4:
				try {
					d = new Dijkstra(rNum);
					ArrayList<st> struct = new ArrayList<st>();
					String s1,s2;
					int i1,bandwidth,delay;
					for (int i = 0; i < num; i++) {
						Scanner sc = new Scanner(JT[i].getText()).useDelimiter(",");
						s1=sc.next();
						s2=sc.next();
						bandwidth=sc.nextInt();
						delay=sc.nextInt();
						if(bandwidth==0||delay==0)
							i1=1;
						else
							i1=(int) Math.pow(10, 7) / bandwidth + delay / 10;
						struct.add(
								new st(s1, s2, i1));
						d.input(struct.get(i).source, struct.get(i).destination, struct.get(i).metric);
					}
				} catch (Exception e2) {
					dialog.setVisible(false);
					break;
				}
				dialog.setVisible(false);
				search.setVisible(true);
				JTCalc.setVisible(true);
				calc.setVisible(true);
				break;
			}
		}
	}

	// ��� ��ư ������
	class calcActionListener implements ActionListener {
		private Scanner sc;

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JA.setText("");
			switch (flag) {
			case 0:
				b = new Bellman_Ford();
				sc = new Scanner(JTCalc.getText()).useDelimiter(",");
				while (sc.hasNext()) {
					b.bellmanFord(edges, (int) sc.next().charAt(0) - 97, rNum);
					ansList = b.getList();
					int size = ansList.size();
					for (int i = 0; i < size; i++) {
						JA.append(ansList.get(i) + "\n");
					}
					JA.append(" =======================================================\n");
				}
				break;
			case 1:
				sc = new Scanner(JTCalc.getText()).useDelimiter(",");
				while (sc.hasNext()) {
					d.algorithm(sc.next());
					ansList = d.getList();
					int size = ansList.size();
					for (int i = 0; i < size; i++) {
						JA.append(ansList.get(i) + "\n");
					}
					JA.append(" =======================================================\n");
				}
				break;
			case 2:
				b = new Bellman_Ford();
				sc = new Scanner(JTCalc.getText()).useDelimiter(",");
				while (sc.hasNext()) {
					b.bellmanFord(edges, (int) sc.next().charAt(0) - 97, rNum);
					ansList = b.getList();
					int size = ansList.size();
					for (int i = 0; i < size; i++) {
						JA.append(ansList.get(i) + "\n");
					}
					JA.append(" =======================================================\n");
				}
				break;
			case 3:
				b = new Bellman_Ford();
				sc = new Scanner(JTCalc.getText()).useDelimiter(",");
				while (sc.hasNext()) {
					b.bellmanFord(edges, (int) sc.next().charAt(0) - 97, rNum);
					ansList = b.getList();
					int size = ansList.size();
					for (int i = 0; i < size; i++) {
						JA.append(ansList.get(i) + "\n");
					}
					JA.append(" =======================================================\n");
				}
				break;
			case 4:
				sc = new Scanner(JTCalc.getText()).useDelimiter(",");
				while (sc.hasNext()) {
					d.algorithm(sc.next());
					ansList = d.getList();
					int size = ansList.size();
					for (int i = 0; i < size; i++) {
						JA.append(ansList.get(i) + "\n");
					}
					JA.append(" =======================================================\n");
				}
				break;
			}
		}
	}

	class st {
		String source;
		String destination;
		int metric;

		protected st(String s, String d, int i) {
			this.source = s;
			this.destination = d;
			this.metric = i;
		}
	}

	public static void main(String[] args) {
		new Main();
	}
}