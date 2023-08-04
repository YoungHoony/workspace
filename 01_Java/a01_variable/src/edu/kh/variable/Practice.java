package edu.kh.variable;

public class Practice {
	
  public static void main(String[] args) {
	
	int iNum1 = 10;
	int iNum2 = 4;
	float fNum = 3.0f;
	double dNum = 2.5;
	char ch = 'A';
	
	// int / int  = int 컴퓨터의 값처리에 의해서 같은 형식과 같은 값으로 나온다. 
	
	System.out.println(iNum1/iNum2); //2
	System.out.println( (int)dNum); //2
	
	System.out.println((double)iNum1); //10.0
	System.out.println(iNum2 * dNum); //10.0 (자동형변환)
	
	System.out.println((int)fNum); //3
	System.out.println(iNum1 / (int)fNum); //3
	System.out.println((int)(iNum1 /fNum)); //3
	
	System.out.println(iNum1 / fNum); // 3.3333333
	System.out.println(iNum1 / (double)fNum); //3.3333333333333335
	System.out.println((double)(iNum1 / fNum)); //3.3333333333333335
	
	System.out.println((int)ch); //65
	
	System.out.println(iNum1 + ch); //75  //자료형에서 int로 자동형변환
	
	System.out.println((char)(ch + iNum1)); //'K' //강제형변환
	

	}

}
