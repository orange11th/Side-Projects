import java.util.*;
import java.io.*;
public class twelve {
	public static void main(String[]args) {
		Vector<String> v=new Vector<String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("��ü ��θ��� �ƴ� ���� �̸��� �Է��ϴ� ���, ������ ������Ʈ ������ �־�� �մϴ�.");
		System.out.print("��� ���ϸ� �Է�>> ");
		String name=sc.nextLine();
		try {
			FileReader fin=new FileReader(name);
			@SuppressWarnings("resource")
			BufferedReader bf=new BufferedReader(fin);
			String line="";
			while((line=bf.readLine())!=null) {
				v.add(line);
			}
		while(true){
			System.out.print("�˻��� �ܾ ����>> ");
			String src=sc.nextLine();
			if(src.equals("�׸�"))
				break;
			for(int i=0;i<v.size();i++) {
				if(v.get(i).contains(src))
						System.out.println((int)i+1+":"+v.get(i));
			}
		}
		} catch (IOException e) {
			System.out.println("������ �����ϴ�.");
		}
		sc.close();
		System.out.println("���α׷��� �����մϴ�.");
}}
