import java.io.PrintStream;
public class Main{
	public static void main(String[] args){
		int n=Integer.parseInt(args[0]);// 命令行输入参数	
		if(n<1||n>1000){
		    System.out.println("输入失败，请输入小于1000的正整数！");
		}else{
			System.out.println("输入成功！");
		try {
			PrintStream ps = new PrintStream("../result.txt");
			System.setOut(ps);
		}catch(Exception e){
			System.out.println("创建result文件失败！");
		}
		System.out.println("2017012698");
		Calculate.QuesFunc(n);
		}
	}
}
