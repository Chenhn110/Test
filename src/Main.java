import java.io.PrintStream;
public class Main{
	public static void main(String[] args){
		int n=Integer.parseInt(args[0]);// �������������	
		if(n<1||n>1000){
		    System.out.println("����ʧ�ܣ�������С��1000����������");
		}else{
			System.out.println("����ɹ���");
		try {
			PrintStream ps = new PrintStream("../result.txt");
			System.setOut(ps);
		}catch(Exception e){
			System.out.println("����result�ļ�ʧ�ܣ�");
		}
		System.out.println("2017012698");
		Calculate.QuesFunc(n);
		}
	}
}
