import java.util.Scanner;
public class sixteen {
	public static void program(String man,int com){//0=���� 1=���� 2=��
		if(man.equals("����")) {
			switch(com) {
			case 0: System.out.println("����� = ����, ��ǻ�� = ����, �����ϴ�.");break;
			case 1: System.out.println("����� = ����, ��ǻ�� = ����, ����ڰ� �̰���ϴ�.");break;
			case 2: System.out.println("����� = ����, ��ǻ�� = ��, ��ǻ�Ͱ� �̰���ϴ�.");break;
			}
		}
		if(man.equals("����")) {
			switch(com) {
			case 0: System.out.println("����� = ����, ��ǻ�� = ����, ��ǻ�Ͱ� �̰���ϴ�.");break;
			case 1: System.out.println("����� = ����, ��ǻ�� = ����, �����ϴ�.");break;
			case 2: System.out.println("����� = ����, ��ǻ�� = ��, ����ڰ� �̰���ϴ�.");break;
			}
		}
		if(man.equals("��")) {
			switch(com) {
			case 0: System.out.println("����� = ��, ��ǻ�� = ����, ����ڰ� �̰���ϴ�.");break;
			case 1: System.out.println("����� = ��, ��ǻ�� = ����, ��ǻ�Ͱ� �̰���ϴ�.");break;
			case 2: System.out.println("����� = ��, ��ǻ�� = ��, �����ϴ�.");break;
			}
		}
	}
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("��ǻ�Ϳ� ���� ���� �� ������ �մϴ�.");
		while(true) {
			System.out.print("���� ���� ��!>>");
			String s=sc.next();	
			if(s.equals("�׸�")) 
				break;			
			int com=(int)Math.random()*3;
			program(s,com);
		}
		System.out.println("������ �����մϴ�...");
		sc.close();
	}
}
