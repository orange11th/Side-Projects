import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class eightServer extends JFrame{
	private Socket socket=null;
	private ServerSocket listener=null;
	private JTextArea ja=new JTextArea();
	private JLabel imageLabel=new JLabel();
	private File file;
	public eightServer() {
		setTitle("���� �޴� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		ja.setBorder(BorderFactory.createLineBorder(Color.black,1));
		c.add(ja,BorderLayout.NORTH);
		
		c.add(imageLabel,BorderLayout.CENTER);
		
		setSize(300,300);
		setLocation(880,420);
		setVisible(true);

		try {
			listener=new ServerSocket(9999);
			while(true) {
			socket=listener.accept();
			ja.append("�����\n");
			rcvProgram pro =new rcvProgram(socket);
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
	class rcvProgram extends Thread{
		Socket socket;
		public rcvProgram(Socket socket) {
			this.socket=socket;
		}
	public void run(){
		try {
		BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String name=in.readLine();
		file=new File("copy_"+name);
		ja.append("���۹��� ���� �̸� ����: "+name.getBytes().length+"\n");
		ja.append("���۹��� ���� �̸�: "+name+"\n");	
		ja.append("������ ���� �̸�: "+file.getName()+"\n");
		}
		catch(IOException e){System.out.println(e.getMessage());}
		try {
		DataInputStream dis=new DataInputStream(socket.getInputStream());
		FileOutputStream fo=new FileOutputStream(file);
		while(true) {
			byte[]buffer=new byte[1024];
			while(true) {
				int n=dis.read(buffer);
				fo.write(buffer,0,n);
				if(n<buffer.length)
					break;
			}
			ja.append("���۹��� ���� ũ��:"+file.length()+"\n.............................................................................\n");
			ja.append("���� ���� ����. ���� ������ ����Ǿ����ϴ�\n");
			
			ImageIcon icon=new ImageIcon(file.getName());
			imageLabel.setIcon(icon);
			pack();
			
			dis.close();
			fo.close();
		}}
	catch(IOException e) {System.out.println(e.getMessage());}}}
	public static void main(String[]args) {
		new eightServer();
	}
}