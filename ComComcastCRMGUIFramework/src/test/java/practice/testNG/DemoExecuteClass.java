package practice.testNG;

public class DemoExecuteClass extends DemoDataClass{

	public static void main(String[] args)  {

		Object[][] obj = example();
		
		for(int i = 0;i<= obj.length;i++) {
			for(int j = 0;j<obj[i].length;j++)
			{
			System.out.print(obj[i][j]+"\t");
		}
		System.out.println();
		}
		
		
		
	}	

}
