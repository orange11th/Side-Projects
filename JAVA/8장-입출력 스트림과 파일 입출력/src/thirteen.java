import java.util.Scanner;
import java.io.*;
public class thirteen {
	static void list(File f) {
		System.out.println("   ["+f.getPath()+"]");
		File[] subfiles=f.listFiles();
		for(int i=0;i<subfiles.length;i++)
			if(subfiles[i].isDirectory())
				System.out.printf("dir%15d����Ʈ\t\t%s\n",subfiles[i].length(),subfiles[i].getName());
			else if(subfiles[i].isFile())
				System.out.printf("file%14d����Ʈ\t\t%s\n",subfiles[i].length(),subfiles[i].getName());}
	public static void main(String[]args) {
		System.out.println("***** ���� Ž�����Դϴ�. *****");
		String name="C:\\";
		File f=new File(name);
		list(f);
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.print(">>");
			String adr=sc.nextLine();
			if(adr.equals("�׸�"))
				break;
			else if(adr.equals(".."))
				f=f.getParentFile();
			else
				{name=name+adr+"\\";f=new File(name);}
			list(f);
	}
		sc.close();
}}
