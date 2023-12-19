import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.*;

public class seven extends JFrame{
	private JLabel label;
	private Clip clip;
	public seven() {
		setTitle("����� ������ ã�� ����/���� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		createMenu();
		label=new JLabel();
		label.setText("����� ������ �����ϼ���");
		label.setFont(new Font("Serif",Font.BOLD,17));
		add(label);
		
		setLocation(880,420);
		setSize(500,200);
		setVisible(true);
	}
	private void createMenu() {
		JMenuBar mb=new JMenuBar();
		JMenu audioMenu=new JMenu("�����");
		
		JMenuItem playItem=new JMenuItem("����");
		JMenuItem stopItem=new JMenuItem("����");
		playItem.addActionListener(new OpenActionListener());
		stopItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clip.stop();
				label.setText("����� ������ �����ϼ���");
			}
		});
		
		audioMenu.add(playItem);
		audioMenu.add(stopItem);
		
		mb.add(audioMenu);
		setJMenuBar(mb);
	}
	private void loadAudio(String pathName) {
		try{
			clip=AudioSystem.getClip();
			File audioFile=new File(pathName);
			AudioInputStream audioStream=AudioSystem.getAudioInputStream(audioFile);
			clip.open(audioStream);}
		catch(IOException e) {e.printStackTrace();}
		catch(LineUnavailableException e) {e.printStackTrace();}
		catch(UnsupportedAudioFileException e) {e.printStackTrace();}
	}
	class OpenActionListener implements ActionListener{
		private JFileChooser chooser;
		public OpenActionListener() {
			chooser=new JFileChooser();
			chooser.setCurrentDirectory(new File("C:\\Users\\orang\\eclipse-workspace\\14��"));
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			FileNameExtensionFilter filter=new FileNameExtensionFilter("WAV files","wav");
			chooser.setFileFilter(filter);
			int ret=chooser.showOpenDialog(null);
			if(ret !=JFileChooser.APPROVE_OPTION) {JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�","���",JOptionPane.WARNING_MESSAGE);
			return;}
			String filePath=chooser.getSelectedFile().getPath();
			loadAudio(filePath);
			clip.start();
			label.setText(chooser.getSelectedFile().getName()+" �� �����ϰ� �ֽ��ϴ�.");
			}
		}
	public static void main(String[]args) {
		new seven();
	}
}
