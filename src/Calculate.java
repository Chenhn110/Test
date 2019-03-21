import java.util.Random;


public class Calculate {
	public static void Integer(){
		String arith1 = null;//运算式
		char[]optCom = {'+','-','*','÷'}; //加减乘除操作集
		Random random = new Random();
		int optIdx = random.nextInt(4);
		int sum1 = 0;//每步运算结果
	    int optNum = random.nextInt(3) + 3; //3-5个运算符
		int a = random.nextInt(100);//随机生成0-100内的整数a
		int b = random.nextInt(100);//随机生成0-100内的整数b
		if(optCom[optIdx] == '+')  sum1 = a + b;
        if(optCom[optIdx] == '*')  sum1 = a * b;
        if(optCom[optIdx] == '-'){//若a-b为负数，则重新随机产生a b
			while(a-b < 0)
			{
				a = random.nextInt(100);
				b = random.nextInt(100);
			}
			sum1 = a - b;
		}
        if(optCom[optIdx] == '÷'){//若a÷b不能整除，则重新随机产生a b
			if (b == 0)
				b = random.nextInt(100);
			while (a%b != 0) {
				a = random.nextInt(100);
				b = random.nextInt(100);
			}
			sum1 = a/b;
		}
        arith1 = a + "" + optCom[optIdx] + "" + b;//将算式更新
        
        for(int j = 1; j < optNum; j++){//随机生成余下的运算符
    		int optIdx1 = random.nextInt(4);//随机生成下一个运算符号
    		int c = random.nextInt(100);//随机生成0-100内的整数c
    		if(optCom[optIdx1] == '+'){
    			sum1 += c;
    			arith1 = arith1 + "" + optCom[optIdx1] + "" + c;
    		}
    		if(optCom[optIdx1] == '-'){
    			while(sum1-c<0)
    			{
    				c=random.nextInt(100);
    			}
    			sum1 += c;
    			arith1 = arith1 + "" + optCom[optIdx1] + "" + c;
    		}
    		if(optCom[optIdx1] == '*'){//若下一个运算符号为乘号，判断前后两个运算符的优先级
    			if(optCom[optIdx] == '+' || optCom[optIdx] == '-')
    			{
    				arith1 = "(" + arith1 + ")" + optCom[optIdx1] + c;
    			}
    			else
    			{
    				arith1 = arith1 + "" + optCom[optIdx1] + "" + c;
    			} 
    		    sum1 = sum1*c;
    		}	
    		if(optCom[optIdx1] == '÷'){//若下一个运算符号为除号，判断前后两个运算符的优先级
    			while (c == 0 || sum1%c != 0) {
    				c=random.nextInt(100);
    			}
    			if(optCom[optIdx] == '+' || optCom[optIdx] == '-')
    			{
    				arith1= "(" + arith1 + ")" + optCom[optIdx1] + c;
    			}
    			else
    			{
    				arith1 = arith1 + "" + optCom[optIdx1] + "" + c;
    			} 
    		    sum1 = sum1/c;
    		}	
//    		optIdx = optIdx1;//更新运算符
    	}	
        System.out.println(arith1 + "=" + sum1);//输出运算式及结果
	}
	public static void Fraction(){
		String arith2 = null;//运算式
		//String sum2 = null;
		char[]optSim = {'+','-'}; //分数加减操作集
		Random random = new Random();
		int mole = 0;
		int deno = 0; //初始化分子分母
		int optNum = random.nextInt(3) + 3; //3-5个运算符
		int mole1 = random.nextInt(20)+1;//随机生成分子1
		int deno1 = random.nextInt(20)+1;//随机生成分母1
		if (mole1 != 0 && deno1 != 0) {
			if (mole1 > deno1) {// 如果分子大于分母，也就是不是真分数时，交换分子分母，使其变成真分数
				int temp = mole1;
				mole1 = deno1;
				deno1 = temp;
			}
			if (mole1 == deno1) {// 如果分子刚好等于分母，重新生成分子
				mole1 = random.nextInt(20);
			}
			int gcd1 = gcd(mole1, deno1);// 求分子分母最大公因数，保证分数形式最简
			deno1 = deno1 / gcd1;// 化简
			mole1 = mole1 / gcd1;// 化简
		}
		arith2 = mole1 + "/" + deno1;// 存储题目
		for (int k = 0; k < optNum; k++) {// 小于运算符数量时不断产生分数，不断计算
			int deno2 = random.nextInt(20);// 生成分母
			int mole2 = random.nextInt(20);// 生成分子
			if (mole2 != 0 && deno2 != 0) {
				if (mole2 > deno2) {// 避免不是真分数
					int temp = mole2;
					mole2 = deno2;
					deno2 = temp;

				}
				if (mole2 == deno2) {// 如果分子等于分母，重新生成分子
					mole2 = random.nextInt(20);
				}
				int gcd2 = gcd(mole2, deno2);// 化简分式，使其最简
				deno2 = deno2 / gcd2;
				mole2 = mole2 / gcd2;
			}
			int idx = random.nextInt(2);//随机生成运算符下标
			if (optSim[idx]  == '+') {// 如果是加号，实现分数加法
				if (deno1 == deno2) {// 如果两个分母相同，直接将分子相加
					mole = mole1 + mole2;
				} else {// 通分，相加
					deno = deno1 * deno2;
					mole = mole1 * deno2 + mole2 * deno1;
				}
				if (mole > deno) {// 如果运算结果不是真分数
					k--;// 计数的u减一，也就是重新生成重新计算
				} else {// 在给定范围内的话，通分运算结果
					int gcd = gcd(mole, deno);
					deno = deno / gcd;
					mole = mole / gcd;
					arith2 = arith2 + optSim[idx] + mole2 + "/" + deno2;
					deno1 = deno;// 储存通分结果
					mole1 = mole;
				}
			} else {// 如果是减号，实现减法操作
				if (deno1 == deno2) {// 分母相同直接分子相减
					mole = mole1 - mole2;
				} else {// 其他情况，先通分再相减
					deno = deno1 * deno2;
					mole = mole1 * deno2 - mole2 * deno1;
				}
				if (mole < 0) {// 如果导致结果小于0了，就重新生成
					k--;
				} else {// 通分结果化简
					int gcd = gcd(mole, deno);
					deno = deno / gcd;
					mole = mole / gcd;
					arith2 = arith2 + optSim[idx] + mole2 + "/" + deno2;
					deno1 = deno;// 储存通分结果
					mole1 = mole;
				}
			}
		}
		System.out.println(arith2 + " = " + mole + "/" + deno);// 输出题目和答案
		
	}
	
	//最大公因数，每次代入,显然有a<b
	 public static int gcd(int a, int b){
	       while(a!=0)
	             return gcd(b % a, a);
	       return b;
	}
	 
	 public static  void QuesFunc(int n) {// 实现产生n个混合四则运算的方法
		 Random random = new Random();
			for (int i = 0; i < n; i++) {
				int flag = random.nextInt(4); //随机生成整数四则运算或真分数加减运算
				if (flag == 0 || flag == 2) {//0生成整数四则运算
					Integer();
				} else {//执行真分数加减运算
					Fraction();
				}
			}
		}
}
