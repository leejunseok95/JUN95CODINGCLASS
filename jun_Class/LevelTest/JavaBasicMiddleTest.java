package leveltest;

import java.util.Random;

public class JavaBasicMiddleTest {
	public static void main(String[] args) {
		Random random = new Random();
		
		String[] names = new String[] {"이준석","이인환","권영채","유제이","김다윤","이희열"};//6명
		String[] subjects = new String[] {"국어","영어","수학","사회","과학","Oracle","Java"};//7과목
		double[] subAvg = new double[subjects.length];
		double[] nameAvg = new double[names.length];
		int[][] score = new int[names.length][subjects.length];
		int[] nameSum = new int[names.length];
		int[] subSum = new int[subjects.length];
		int[] rank = new int[names.length];
		
		
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				score[i][j] = random.nextInt(51) + 50;
				nameSum[i] += score[i][j];
				subSum[j] += score[i][j];
			}
			nameAvg[i] = (double)nameSum[i]/subjects.length;
		}
		
		for(int j = 0; j < subjects.length; j++) {
			subAvg[j] = (double)subSum[j]/nameSum.length;
		}
		
		for(int i = 0; i < rank.length; i++)
			rank[i] = 1;
		
		for(int i = 0; i < nameSum.length; i++){
			for(int j = 0; j < nameSum.length; j++){
				if(nameSum[i] < nameSum[j]){
					rank[i]++;
				}
			}
		}
		
		
		System.out.println("====================================================================================");
		for (int i = 0; i < subjects.length; i++) {
			System.out.print("\t" + subjects[i]);
		}
		System.out.println("\t합계\t평균\t석차");
		System.out.println("-------------------------------------------------------------------------------------");
		for (int i = 0; i < score.length; i++) {
			System.out.print(names[i] + "  |");
			for (int j = 0; j < score[i].length; j++) {
				System.out.print("\t" + score[i][j]);
				
			}
			System.out.print("\t" + nameSum[i] + "\t" + String.format("%.2f", nameAvg[i]) + "\t " + rank[i]);
			System.out.println();
		}
		System.out.println("-------------------------------------------------------------------------------------");
		
		System.out.print("합계  |");
		for (int i = 0; i < subSum.length; i++) {
			System.out.print("\t" + subSum[i]);
		}
		System.out.println();
		
		System.out.print("평균  |");
		for (int i = 0; i < subAvg.length; i++) {
			System.out.print("\t" + String.format("%.2f", subAvg[i]));
		}
		System.out.println();
		System.out.println("====================================================================================");		
	}
}












