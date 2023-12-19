interface Shape {
   final double PI = 3.14; // ���
   void draw(); // ������ �׸��� �߻� �޼ҵ�
   double getArea(); // ������ ������ �����ϴ� �߻� �޼ҵ�
   default public void redraw() { // ����Ʈ �޼ҵ�
      System.out.print("--- �ٽ� �׸��ϴ�.");
      draw();
   }
}
class Circle implements Shape{
	private int radius;
	public Circle(int radius) {this.radius=radius;}
	public void draw() {System.out.println(" �������� "+radius+"�� ���Դϴ�.");}
	public double getArea() {return radius*radius*PI;}
	public void redraw() {System.out.print("--- �ٽ� �׸��ϴ�.");
    draw();}
}
class Oval implements Shape{
	private int x,y;
	public Oval(int x,int y) {this.x=x;this.y=y;}
	public void draw() {System.out.println(" "+x+"x"+y+"�� �����ϴ� Ÿ���Դϴ�.");}
	public double getArea() {return PI*(double)(x/2)*(double)(y/2);}
	public void redraw() {System.out.print("--- �ٽ� �׸��ϴ�.");
	draw();}
}
class Rect implements Shape{
	private int x,y;
	public Rect(int x,int y) {this.x=x;this.y=y;}
	public void draw() {System.out.println(" "+x+"x"+y+"ũ���� �簢�� �Դϴ�.");}
	public double getArea() {return x*y;}
	public void redraw() {System.out.print("--- �ٽ� �׸��ϴ�.");
	draw();}
}
public class fourteen {
	public static void main(String[] args) {
		   Shape[] list = new Shape[3]; // Shape�� ��ӹ��� Ŭ���� ��ü�� ���۷��� �迭
		   list[0] = new Circle(10); // �������� 10�� �� ��ü
		   list[1] = new Oval(20, 30); // 20x30 �簢���� �����ϴ� Ÿ��
		   list[2] = new Rect(10, 40); // 10x40 ũ���� �簢��
		   for(int i=0; i<list.length; i++) list[i].redraw();
		   for(int i=0; i<list.length; i++) System.out.println("������ "+ list[i].getArea());
		}
}
