//url: https://leetcode.com/problems/student-attendance-record-ii/description/
package attendRec;



//fixme
//not good idea

public class Solution {

	/** Ctrl + C starts here **/

	public static long TOP = 1000000007L;

	public int checkRecord(int n) {
		switch (n) {
			case 1:
				return 3;
			case 2:
				return 8;
			default:
				int[] AA = new int[n+1];
				int[] PP = new int[n+1];
				AA[0]=0;
				PP[0]=1;
				AA[1]=1;
				AA[2]=4;
				PP[1]=2;
				PP[2]=4;
				for(int i=3;i<=n;i++){
					AA[i] = (int) (((long)AA[i-2]+PP[i-2]+AA[i-3]+PP[i-3]+AA[i-1]+PP[i-1])%TOP);
					PP[i] =(int) (((long)PP[i-2]+PP[i-1]+PP[i-3])%TOP);
				}

				return (int) (((long)AA[n]+PP[n])%TOP);
		}
	}




	/** Ctrl + C ends here **/

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();
	}
	public void test() {
		System.out.println("Test starts!");
		System.out.println("Good Luck!");
		System.out.println("");
		for(int i=1;i<=200;i++)
			System.out.println(i+":"+checkRecord(i));
//		3
//		8
//		19
//		43
//		94
//		200
//		418
//		861
//		1753
	}
}
