interface Shape {
   final double PI = 3.14; // 상수
   void draw(); // 도형을 그리는 추상 메소드
   double getArea(); // 도형의 면적을 리턴하는 추상 메소드
   default public void redraw() { // 디폴트 메소드
      System.out.print("--- 다시 그립니다.");
      draw();
   }
}
class Circle implements Shape{
	private int radius;
	public Circle(int radius) {this.radius=radius;}
	public void draw() {System.out.println(" 반지름이 "+radius+"인 원입니다.");}
	public double getArea() {return radius*radius*PI;}
	public void redraw() {System.out.print("--- 다시 그립니다.");
    draw();}
}
class Oval implements Shape{
	private int x,y;
	public Oval(int x,int y) {this.x=x;this.y=y;}
	public void draw() {System.out.println(" "+x+"x"+y+"에 내접하는 타원입니다.");}
	public double getArea() {return PI*(double)(x/2)*(double)(y/2);}
	public void redraw() {System.out.print("--- 다시 그립니다.");
	draw();}
}
class Rect implements Shape{
	private int x,y;
	public Rect(int x,int y) {this.x=x;this.y=y;}
	public void draw() {System.out.println(" "+x+"x"+y+"크기의 사각형 입니다.");}
	public double getArea() {return x*y;}
	public void redraw() {System.out.print("--- 다시 그립니다.");
	draw();}
}
public class fourteen {
	public static void main(String[] args) {
		   Shape[] list = new Shape[3]; // Shape을 상속받은 클래스 객체의 레퍼런스 배열
		   list[0] = new Circle(10); // 반지름이 10인 원 객체
		   list[1] = new Oval(20, 30); // 20x30 사각형에 내접하는 타원
		   list[2] = new Rect(10, 40); // 10x40 크기의 사각형
		   for(int i=0; i<list.length; i++) list[i].redraw();
		   for(int i=0; i<list.length; i++) System.out.println("면적은 "+ list[i].getArea());
		}
}
