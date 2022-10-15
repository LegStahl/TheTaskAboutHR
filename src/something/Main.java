package something;

import java.util.Scanner;

public class Main {
	public static void main(String[] argv) {
		int sumSalary = 0;
		long usedBytes = 0;
		long start = System.currentTimeMillis();
		long finish = 0;
		System.out.println(usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory());
		Scanner scanner = new Scanner(System.in);
		//String sizeAndSul = scanner.nextLine();
		//long usedBytes = 0;
		//System.out.println(usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory());
		//Scanner scannerForString = new Scanner(sizeAndSul);
		int[] leftPack = new int[scanner.nextInt() + 1];
		int[] rightPack = new int[scanner.nextInt() + 1];
		//System.out.println(usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory());
		sumSalary = scanner.nextInt();
		int left = 1;
		int right = 1;
        int localMax = 0;
        int globalMax = 0;
        int leftMax = 0;
        int rightMax = 0;
        boolean rightCheckOver = true;
        boolean leftCheckOver = true;
        int temporary = 0;
		while(left < leftPack.length || right < rightPack.length) {

			//String salaryOfPerson = scanner.nextLine();
			//scannerForString = new Scanner(salaryOfPerson);
			if(left < leftPack.length) {
				temporary = scanner.nextInt();
				leftPack[left] = temporary;
				if(!(leftMax + temporary <= sumSalary)){
					leftCheckOver = false;
				}
				if(left!=0 && leftMax <= sumSalary && leftCheckOver) {
					leftMax += temporary;
					localMax++;
				}else if(left == 0) {
					if(temporary < sumSalary) {
						leftMax = leftPack[0];
						localMax++;
					}
					else {
						leftMax = temporary;
					}
				}
				left++;
			}
			else {
				scanner.next();
			}
			if(right < rightPack.length) {
				temporary = scanner.nextInt();
				rightPack[right] = temporary;
				if(!(rightMax + temporary <= sumSalary)){
					rightCheckOver = false;
				}
				if(right != 0 && rightMax + temporary <= sumSalary && rightCheckOver) {
					rightMax += temporary;
					globalMax++;
				}
				else if(right == 0) {
					if(temporary < sumSalary) {
						rightMax = rightPack[0];
						globalMax++;
					}
					else {
						rightMax = temporary;
					}
				}
				right++;
			}
			else {
				scanner.next();
			}
			scanner.nextLine();
		}
		//System.out.println(usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory());
		scanner.close();
		//scannerForString.close();
		//System.out.println(usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory());
		if(globalMax < localMax) {
			globalMax = localMax;
			localMax = 0;
		}
		else {
			localMax = 0;
		}
		if(globalMax != 0) {
			for(int i = 1; i < rightPack.length; i++) {
				rightPack[i] = rightPack[i - 1] + rightPack[i];
			}
			
			for(int i = 1; i < leftPack.length; i++) {
				leftPack[i] = leftPack[i - 1] + leftPack[i];
			}
			
	    
			int sum = 0;
	        for (int i = 1; i < leftPack.length; i++)
	        {
	            localMax = 0;
	            sum = 0;
	            for (int j = 1; j < rightPack.length; j++)
	            {
	                sum = rightPack[j] + leftPack[i];
	                if (sum > sumSalary)
	                {                         
	                    break;
	                }
	                localMax = i + j;
	
	                
	            }
	            if (localMax > globalMax) 
	            	globalMax = localMax;
	            
	        }

	      
		
	}
		finish = System.currentTimeMillis();
		System.out.println(globalMax);
		System.out.println(finish - start);
		System.out.println(usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory());
	}
}
