import java.util.Scanner;
import java.io.*;
public class test {
	public static void main(String[]args)  {
		Scanner sc=new Scanner(System.in);
		System.out.println("��ü ��θ��� �ƴ� ���� �̸��� �Է��ϴ� ���, ������ ������Ʈ ������ �־�� �մϴ�.");
		System.out.print("ù��° ���� �̸��� �Է��ϼ���>>");
		String f1=sc.next();
		System.out.print("�ι�° ���� �̸��� �Է��ϼ���>>");
		String f2=sc.next();
		try {
			@SuppressWarnings("resource")
			FileReader fin1=new FileReader(f1);	
			@SuppressWarnings("resource")
			FileReader fin2=new FileReader(f2);
			System.out.println(f1+"�� "+f2+"�� ���մϴ�.");
			int c1,value=0;
			while((c1=fin1.read())!=-1) {
				if(c1==fin2.read())
					value=1;
		}
		if(value==1)
			System.out.println("������ �����ϴ�");
		else
			System.out.println("������ ���� �ٸ��ϴ�.");
		} catch (IOException e) {
		System.out.println("����� ����");
}
		sc.close();}}
