package datadrivenTesting;

public class GeneratingRandomNumber {
    public static void main(String[] args) {
		int n=20;
		String AlphaNumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		StringBuilder builder = new StringBuilder(n);
		for(int i=0;i<n;i++) {
			int index = (int)(AlphaNumericString.length()*Math.random());
			builder.append(AlphaNumericString.charAt(index));
		}
		System.out.println(builder);
		
	
	}
}
