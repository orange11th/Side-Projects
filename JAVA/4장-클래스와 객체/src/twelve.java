import java.util.Scanner;
public class twelve {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		String []s= {"---","---","---","---","---","---","---","---","---","---"};
		String []a= {"---","---","---","---","---","---","---","---","---","---"};
		String []b= {"---","---","---","---","---","---","---","---","---","---"};
		System.out.println("��ǰ�ܼ�ƮȦ ���� �ý����Դϴ�.");
		while(true) {
			System.out.print("����:1, ��ȸ:2, ���:3, ������:4>>");
			int select=sc.nextInt();
			if(select==4)
				break;
			switch(select) {
			case 1:
				System.out.print("�¼����� S(1), A(2), B(3)>>");
				int select2=sc.nextInt();
				if(select2==1) {
					System.out.print("S>> ");
					for(int i=0;i<10;i++) {
						System.out.print(s[i]+" ");
					}
					System.out.print("\n�̸�>>");
					String name=sc.next();
					System.out.print("��ȣ>>");
					int num=sc.nextInt();
					s[num-1]=name;}
				if(select2==2) {
					System.out.print("A>> ");
					for(int i=0;i<10;i++) {
						System.out.print(a[i]+" ");
					}
					System.out.print("\n�̸�>>");
					String name=sc.next();
					System.out.print("��ȣ>>");
					int num=sc.nextInt();
					a[num-1]=name;}
				if(select2==3) {
					System.out.print("B>> ");
					for(int i=0;i<10;i++) {
						System.out.print(b[i]+" ");
					}
					System.out.print("\n�̸�>>");
					String name=sc.next();
					System.out.print("��ȣ>>");
					int num=sc.nextInt();
					b[num-1]=name;}
				break;
			case 2:
				System.out.print("S>> ");
				for(int i=0;i<10;i++)
					System.out.print(s[i]+" ");
				System.out.print("\nA>> ");
				for(int i=0;i<10;i++)
					System.out.print(a[i]+" ");
				System.out.print("\nB>> ");
				for(int i=0;i<10;i++)
					System.out.print(b[i]+" ");
				System.out.println("\n<<<��ȸ�� �Ϸ��Ͽ����ϴ�.>>>");
				break;
			case 3:
				System.out.print("�¼� S:1, A:2, B:3>>");
				select2=sc.nextInt();
				if(select2==1) {
					System.out.print("S>> ");
					for(int i=0;i<10;i++)
						System.out.print(s[i]+" ");
					System.out.print("\n�̸�>>");
					String name=sc.next();
					for(int i=0;i<10;i++)
						if(s[i].equals(name))
							s[i]="---";}
				if(select2==2) {
					System.out.print("A>> ");
					for(int i=0;i<10;i++)
						System.out.print(a[i]+" ");
					System.out.print("\n�̸�>>");
					String name=sc.next();
					for(int i=0;i<10;i++)
						if(a[i].equals(name))
							a[i]="---";}
				if(select2==3) {
					System.out.print("B>> ");
					for(int i=0;i<10;i++)
						System.out.print(b[i]+" ");
					System.out.print("\n�̸�>>");
					String name=sc.next();
					for(int i=0;i<10;i++)
						if(b[i].equals(name))
							b[i]="---";	}}}
		sc.close();}}
