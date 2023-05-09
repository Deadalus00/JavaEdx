//HW01 Section 1: String Methods
public class StringOperations{
	public static void main(String[] args){
		//First requirement
		String examString = "YukeLiu";
		System.out.println(examString);
		//Second
		String examStrReplaced = examString.replace('Y','A');
		examStrReplaced = examStrReplaced.replace('u','Z');
		System.out.println(examStrReplaced);
		//Third
		String examStrUrl = "home.edx.org";
		System.out.println(examStrUrl);
		//Fourth
		int startIndex = examStrUrl.indexOf(".");
		int endIndex = examStrUrl.lastIndexOf(".");
		String examStrCon = examStrUrl.substring(startIndex + 1, endIndex).concat("1331");
		System.out.println(examStrCon);
	}
}