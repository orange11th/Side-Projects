import java.util.*;

class Dijkstra {
	protected int n; //������ ���� ������ ����
	protected int[][] weight; //2���� �迭 weight�� �� �������� ����ġ�� ����
	protected String[] saveRoute;
	protected String[] vertex = {"a","b","c","d","e","f","g","h"};
	protected ArrayList<String> ansList;
	
	protected Dijkstra(int n) {
		super();
		this.n = n; //�����ڸ� ���� ������ ���� �����ϰ�,
		weight = new int[n][n]; //����ġ�� ������ �迭 weight�� ũ�� ����.
		saveRoute = new String[n];
	}
	protected ArrayList getList() {
		return ansList;
	}
	/*
	public int stringToInt(String s) {
		//���ڿ��� int������ �ٲ��ش�.
		int x = 0;
		for(int i=0; i<vertex.length; i++) {
			if(vertex[i]==s) x=i;
		}
		System.out.println("string to int Ȯ��:"+x);
		return x;
	}
	*/
	protected int stringToInt(String s) {
		return (int)s.charAt(0)-97;
	}
	protected void input(String v1, String v2, int w) {
		//���� ���ڿ��� �Էµ� ������ v1�� v2�� �ش�Ǵ� ���� �ε��� x1�� x2�� �ٲ��ش�.
		int x1 = stringToInt(v1);
		int x2 = stringToInt(v2);
		
		//x1���� x2������ ����ġ�� ����
		//�� ��, x1���� x2������ ����ġ�� x2���� x1������ ����ġ�� ����.(�ߺ��� ��)
		//����ġ�� ��� �Էµ��� �ʾҴٸ� �⺻�� 0�� �ԷµǾ� ���� ���̴�.
		weight[x1][x2] = w;
		weight[x2][x1] = w;
	}
	
	protected void algorithm(String a) {
		boolean[] visited = new boolean[n]; //�� �������� �湮 ����
		int distance[] = new int[n]; //���� �������������� �� ������������ �Ÿ�
		
		//���� ������ a�������� �� ������������ ��� �Ÿ� �ʱ�ȭ
		for(int i=0; i<n; i++) {
			//�̻���� ���� 251�ʿ����� �ķ� �ʱ�ȭ������
			//���⿡���� int���� ���� ū �� 2147483647�� �ʱ�ȭ�Ѵ�.
			distance[i] = Integer.MAX_VALUE;
		}
		
		int x = stringToInt(a); //���ڿ��� �Էµ� ���� �������� �ش�Ǵ� ���� �ε��� x�� �ٲٰ�
		distance[x] = 0; //���� ������ x�� �Ÿ��� 0���� �ʱ�ȭ�ϰ�, 
		visited[x] = true; //�湮 �������̹Ƿ� true�� ����
		saveRoute[x] = vertex[x]; //�ڽ��� �������� ��δ� �ڱ� �ڽ��� ����
		
		//���� ������ x�������� ������ i������ �Ÿ��� �����Ѵ�.
		for(int i=0; i<n; i++) {
			//�湮���� �ʾҰ� x���� i������ ����ġ�� �����Ѵٸ�, �Ÿ� i�� x���� i������ ����ġ ����
			//�� x���� ������ ������������ �Ÿ��� ������.
			//(x�� �������� ���� ���������� Integer.MAX_VALUE�� ��� ����Ǿ� ���� ���̴�.)
			if(!visited[i] && weight[x][i]!=0) {
				distance[i] = weight[x][i];
				saveRoute[i] = vertex[x]; //�ڽ��� �������� ������ �������� ��ο� ���� �������� ����
			}
		}
		
		for(int i=0; i<n-1; i++) {
			int minDistance = Integer.MAX_VALUE; //�ִܰŸ� minDistance�� �ϴ� ���� ū ������ �����ϰ�,
			int minVertex = -1; //�� �Ÿ����� �ִ� �ε��� minIndex�� -1�� �����صд�.
			for(int j=0; j<n; j++) {
				//�湮���� �ʾҰ� �Ÿ��� ������ ������ �߿��� ���� ����� �Ÿ��� ���� ����� �������� ���Ѵ�.
				if(!visited[j] && distance[j]!=Integer.MAX_VALUE) {
					if(distance[j]<minDistance) {
						minDistance = distance[j];
						minVertex = j;
					}
				}
			}	
			visited[minVertex] = true; //���� �ݺ����� ���� ����� ���� ����� �������� �湮 ǥ��
			for(int j=0; j<n; j++) {
				//�湮���� �ʾҰ� minVertex���� ����ġ�� �����ϴ�(minVertex���� �����) �������̶��
				if(!visited[j] && weight[minVertex][j]!=0) {
					//���� �� �������� ������ �ִ� �Ÿ����� minVertex�� ����ġ�� ���� ������ ũ�ٸ� �ִܰŸ� ����
					if(distance[j]>distance[minVertex]+weight[minVertex][j]) {
						distance[j] = distance[minVertex]+weight[minVertex][j];
						saveRoute[j] = vertex[minVertex]; //�ִܰŸ��� ���ŵ� �������� ��ο� minVertex�� �ش��ϴ� ������ ����
					}
				}
			}
		}
		//���� ���������� Ư�� ������������ �Ÿ� ���
		/*
		for(int i=0; i<n; i++) {
			System.out.println("���� ������ "+a+"���� ������ "+vertex[i]+"������ �Ÿ� :"+distance[i]);
		}
		
		System.out.println("==================================");
		*/
		//���� ���������� Ư�� ������������ ��� ���
		ansList=new ArrayList<String>();
		
		for(int i=0; i<n; i++) {
			String route = "";
			String ans="";
			//System.out.println("���� ��� "+a+"���� ��� "+vertex[i]+"������ �Ÿ� :"+distance[i]);
			
			//System.out.print("���� ��� "+a+"���� ��� "+vertex[i]+"��� : ");
			int index = i;
			while(true) {
				if(saveRoute[index] == vertex[index]) break; //���� �������� ��� break
				route += " " + saveRoute[index];
				index = stringToInt(saveRoute[index]); //�������� ������ �� �������� int������ �ٲ㼭 index�� ���� 
			}
			StringBuilder sb = new StringBuilder(route);
			ans+="���� ��� "+a+"���� ��� "+vertex[i]+"������ �Ÿ� : "+distance[i]+" || ���: "+sb.reverse() + vertex[i];
			ansList.add(ans);
			//System.out.println(sb.reverse() + vertex[i]);
		}
	}
	public static void main(String[] args) {
		Dijkstra d = new Dijkstra(8);
		
		//������ �� ������ ������ ����ġ ����
		d.input("a","b",4);
		d.input("a","c",3);
		d.input("b","c",2);
		d.input("b","d",5);
		d.input("c","d",3);
		d.input("c","e",6);
		d.input("d","e",1);
		d.input("d","f",5);
		d.input("e","g",5);
		d.input("f","g",2);
		d.input("f","h",7);
		d.input("g","h",4);
		
		//������ a���������� �ִܰŸ� �� �ִܰ�� ���
		d.algorithm("a");
	}
}