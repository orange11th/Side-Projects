import java.util.Scanner;
public class eight {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		 System.out.print("�� (x1,y1)�� ��ǥ�� �Է��Ͻÿ�>>");
		 int x1=sc.nextInt();
		 int y1=sc.nextInt();
		 System.out.print("�� (x2,y2)�� ��ǥ�� �Է��Ͻÿ�>>");
		int x2=sc.nextInt();
		int y2=sc.nextInt();
		if(((x1<100&x2<100)||(x1>200&&x2>200))||((y1<100&&y2<100||(y1>200&&y2>200))))
			System.out.println("false");
		else
			System.out.println("true");
		sc.close();	
	}
}
