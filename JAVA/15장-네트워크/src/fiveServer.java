import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class fiveServer extends JFrame{
	private JTextArea ja=new JTextArea();
	private HashMap<String,String> h=new HashMap<String,String>();
	private Socket socket=null;
	private ServerSocket listener=null;
	public fiveServer() {
		setTitle("���� ��ȸ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fileRead("score.txt");
		ja.setFont(new Font("Plain",Font.BOLD,15));
		add(ja);
	
		setSize(300,300);
		setLocation(880,420);
		setVisible(true);
		try {
			listener=new ServerSocket(9999);
			while(true) {
			socket=listener.accept();
			ja.append("\nŬ���̾�Ʈ �����");
			program pro =new program(socket);
			pro.start();
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				socket.close();
				listener.close();
			}catch(IOException e) {
				System.out.println("���� �߻�");
			}
		}
	}
	public void fileRead(String file) {
		try {
			File file1=new File(file);
			BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream(file1),"UTF8"));
			String line="";
			while((line=bf.readLine())!=null) {
				Scanner sc=new Scanner(line);
				h.put(sc.next(), sc.next());
				sc.close();
			}
		}catch(IOException e) {System.out.println("���� ����");};
		ja.append("score.txt �б� �Ϸ�");
	}
	class program extends Thread{
		Socket socket;
		public program(Socket socket) {
			this.socket=socket;
		}
		public void run() {
			try {
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				String inputMessage=in.readLine();
				if(h.containsKey(inputMessage)) {
					ja.append("\n"+inputMessage+":"+h.get(inputMessage));
					out.write(h.get(inputMessage)+"\n");
					out.flush();
					System.out.println("����");
				}
				else {
					ja.append("\n"+inputMessage+" ����");
					out.write("���� ���� �̸�\n");
					out.flush();
				}			
			}
		}catch(IOException e) {System.out.println(e.getMessage());}
	}
	}
	public static void main(String[]args) {
		new fiveServer();
	}
}