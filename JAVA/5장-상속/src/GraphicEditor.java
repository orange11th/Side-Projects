import java.util.Scanner;
public class GraphicEditor {
	public static void main(String[]args) {
		System.out.println("�׷��� ������ beauty�� �����մϴ�.");
		Scanner sc=new Scanner(System.in);
		String []s = new String[10];
		int i=0;
		while(true) {
			System.out.print("����(1), ����(2), ��� ����(3), ����(4)>>");
			int select=sc.nextInt();
			if(select==4)
				break;
			switch(select) {
			case 1:
				System.out.print("Line(1), Rect(2), Circle(3)>>");
				int select2=sc.nextInt();
				if(select2==1)
					{s[i]="Line";i++;}
				else if(select2==2)
				{s[i]="Rect";i++;}
				else if(select2==3)
				{s[i]="Circle";i++;}	
				break;
			case 2:
				System.out.print("������ ������ ��ġ>>");
				select2=sc.nextInt();
				if(select2>i)
					System.out.println("������ �� �����ϴ�.");
				else
				{s[select2]=null;
				i--;}
				break;
			case 3:
				for(int k=0;k<i;k++)
					System.out.println(s[k]);
			}
		}
		System.out.println("beauty�� �����մϴ�.");
		sc.close();
	}
}
