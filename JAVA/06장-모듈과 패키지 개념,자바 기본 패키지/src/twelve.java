import java.util.Scanner;
class Person{
	private String name;
	public Person(String name) {this.name=name;}
	public String getName() {return name;}
}
public class twelve {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("���� ���ӿ� ������ ���� ����>>");
		int num=sc.nextInt();
		Person []person=new Person[num];
		for (int i=0;i<num;i++) {
			System.out.print((int)i+1+"��° ���� �̸�>>");
			person[i]=new Person(sc.next());}
		boolean b=true;
		while(b==true) {
			for(int i=0;i<num;i++) {
				Scanner sc1=new Scanner(System.in);
				System.out.print("["+person[i].getName()+"]:<Enter>");
				sc1.nextLine();
				int i1=(int)(Math.random()*3+1);
				int i2=(int)(Math.random()*3+1);
				int i3=(int)(Math.random()*3+1);
				System.out.print("\t"+i1+"\t"+i2+"\t"+i3+"\t");
				if((i1==i2)&&(i2==i3)) {
					System.out.println(person[i].getName()+"���� �̰���ϴ�!");b=false;break;
				}
				else
					System.out.println("�ƽ�����!");
			}
		}
		sc.close();
	}
}
