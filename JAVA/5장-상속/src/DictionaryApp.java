abstract class PairMap {
   protected String KeyArray[];
   protected String valueArray[]; 
   abstract String get(String key); // key ���� ���� value ����, ������ null ����
   abstract void put(String ket, String value);
   abstract String delete(String key); // key ���� ���� ������ (value�� �Բ�) ����, ������ value �� ����
   abstract int length();
}
class Dictionary extends PairMap{
	private int i;
	public Dictionary(int num) {KeyArray=new String[num];valueArray=new String[num];this.i=0;}
	String get(String key) {
		String value = null;
		try{for(int k=0;k<i;k++)
			if(KeyArray[k].equals(key))
				value=valueArray[k];}catch(Exception NullPointerException) {
					return null;
				}
		return value;
	}
	void put(String key, String value) {
		for(int k=0;k<i;k++) {
			if(KeyArray[k].equals(key))
				valueArray[k]=value;
		}
		KeyArray[i]=key;valueArray[i]=value;i++;
	}
	String delete(String key) {
		String value=null;
		for(int k=0;k<i;k++) {
			if(KeyArray[k].equals(key)) {
				value=valueArray[k];
				KeyArray[k]=null;
				valueArray[k]=null;}
			}i--;return value;}
	int length() {
		return i;
	}
}
public class DictionaryApp{
	public static void main(String[]args) {
		 Dictionary dic = new Dictionary(10);
		   dic.put("Ȳ����", "�ڹ�");
		   dic.put("���繮", "���̼�");
		   dic.put("���繮", "C++"); // ���繮�� ���� C++�� ����
		   System.out.println("���繮�� ���� "+dic.get("���繮"));
		   System.out.println("Ȳ������ ���� "+dic.get("Ȳ����"));
		   dic.delete("Ȳ����"); // Ȳ���� ������ ����
		   System.out.println("Ȳ������ ���� "+dic.get("Ȳ����")); //������ ������ ����
		   System.out.println("�迭�� ��� ������ "+dic.length());
	}
}