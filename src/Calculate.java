import java.util.Random;


public class Calculate {
	public static void Integer(){
		String arith1 = null;//����ʽ
		char[]optCom = {'+','-','*','��'}; //�Ӽ��˳�������
		Random random = new Random();
		int optIdx = random.nextInt(4);
		int sum1 = 0;//ÿ��������
	    int optNum = random.nextInt(3) + 3; //3-5�������
		int a = random.nextInt(100);//�������0-100�ڵ�����a
		int b = random.nextInt(100);//�������0-100�ڵ�����b
		if(optCom[optIdx] == '+')  sum1 = a + b;
        if(optCom[optIdx] == '*')  sum1 = a * b;
        if(optCom[optIdx] == '-'){//��a-bΪ�������������������a b
			while(a-b < 0)
			{
				a = random.nextInt(100);
				b = random.nextInt(100);
			}
			sum1 = a - b;
		}
        if(optCom[optIdx] == '��'){//��a��b�����������������������a b
			if (b == 0)
				b = random.nextInt(100);
			while (a%b != 0) {
				a = random.nextInt(100);
				b = random.nextInt(100);
			}
			sum1 = a/b;
		}
        arith1 = a + "" + optCom[optIdx] + "" + b;//����ʽ����
        
        for(int j = 1; j < optNum; j++){//����������µ������
    		int optIdx1 = random.nextInt(4);//���������һ���������
    		int c = random.nextInt(100);//�������0-100�ڵ�����c
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
    		if(optCom[optIdx1] == '*'){//����һ���������Ϊ�˺ţ��ж�ǰ����������������ȼ�
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
    		if(optCom[optIdx1] == '��'){//����һ���������Ϊ���ţ��ж�ǰ����������������ȼ�
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
//    		optIdx = optIdx1;//���������
    	}	
        System.out.println(arith1 + "=" + sum1);//�������ʽ�����
	}
	public static void Fraction(){
		String arith2 = null;//����ʽ
		//String sum2 = null;
		char[]optSim = {'+','-'}; //�����Ӽ�������
		Random random = new Random();
		int mole = 0;
		int deno = 0; //��ʼ�����ӷ�ĸ
		int optNum = random.nextInt(3) + 3; //3-5�������
		int mole1 = random.nextInt(20)+1;//������ɷ���1
		int deno1 = random.nextInt(20)+1;//������ɷ�ĸ1
		if (mole1 != 0 && deno1 != 0) {
			if (mole1 > deno1) {// ������Ӵ��ڷ�ĸ��Ҳ���ǲ��������ʱ���������ӷ�ĸ��ʹ���������
				int temp = mole1;
				mole1 = deno1;
				deno1 = temp;
			}
			if (mole1 == deno1) {// ������Ӹպõ��ڷ�ĸ���������ɷ���
				mole1 = random.nextInt(20);
			}
			int gcd1 = gcd(mole1, deno1);// ����ӷ�ĸ�����������֤������ʽ���
			deno1 = deno1 / gcd1;// ����
			mole1 = mole1 / gcd1;// ����
		}
		arith2 = mole1 + "/" + deno1;// �洢��Ŀ
		for (int k = 0; k < optNum; k++) {// С�����������ʱ���ϲ������������ϼ���
			int deno2 = random.nextInt(20);// ���ɷ�ĸ
			int mole2 = random.nextInt(20);// ���ɷ���
			if (mole2 != 0 && deno2 != 0) {
				if (mole2 > deno2) {// ���ⲻ�������
					int temp = mole2;
					mole2 = deno2;
					deno2 = temp;

				}
				if (mole2 == deno2) {// ������ӵ��ڷ�ĸ���������ɷ���
					mole2 = random.nextInt(20);
				}
				int gcd2 = gcd(mole2, deno2);// �����ʽ��ʹ�����
				deno2 = deno2 / gcd2;
				mole2 = mole2 / gcd2;
			}
			int idx = random.nextInt(2);//�������������±�
			if (optSim[idx]  == '+') {// ����ǼӺţ�ʵ�ַ����ӷ�
				if (deno1 == deno2) {// ���������ĸ��ͬ��ֱ�ӽ��������
					mole = mole1 + mole2;
				} else {// ͨ�֣����
					deno = deno1 * deno2;
					mole = mole1 * deno2 + mole2 * deno1;
				}
				if (mole > deno) {// ������������������
					k--;// ������u��һ��Ҳ���������������¼���
				} else {// �ڸ�����Χ�ڵĻ���ͨ��������
					int gcd = gcd(mole, deno);
					deno = deno / gcd;
					mole = mole / gcd;
					arith2 = arith2 + optSim[idx] + mole2 + "/" + deno2;
					deno1 = deno;// ����ͨ�ֽ��
					mole1 = mole;
				}
			} else {// ����Ǽ��ţ�ʵ�ּ�������
				if (deno1 == deno2) {// ��ĸ��ֱͬ�ӷ������
					mole = mole1 - mole2;
				} else {// �����������ͨ�������
					deno = deno1 * deno2;
					mole = mole1 * deno2 - mole2 * deno1;
				}
				if (mole < 0) {// ������½��С��0�ˣ�����������
					k--;
				} else {// ͨ�ֽ������
					int gcd = gcd(mole, deno);
					deno = deno / gcd;
					mole = mole / gcd;
					arith2 = arith2 + optSim[idx] + mole2 + "/" + deno2;
					deno1 = deno;// ����ͨ�ֽ��
					mole1 = mole;
				}
			}
		}
		System.out.println(arith2 + " = " + mole + "/" + deno);// �����Ŀ�ʹ�
		
	}
	
	//���������ÿ�δ���,��Ȼ��a<b
	 public static int gcd(int a, int b){
	       while(a!=0)
	             return gcd(b % a, a);
	       return b;
	}
	 
	 public static  void QuesFunc(int n) {// ʵ�ֲ���n�������������ķ���
		 Random random = new Random();
			for (int i = 0; i < n; i++) {
				int flag = random.nextInt(4); //��������������������������Ӽ�����
				if (flag == 0 || flag == 2) {//0����������������
					Integer();
				} else {//ִ��������Ӽ�����
					Fraction();
				}
			}
		}
}
