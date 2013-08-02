package javtang;

public abstract class Strings {

		public static String repeat(String s, int count) {
				StringBuilder sb = new StringBuilder();
				for(int i=0; i<count; i++) {
						sb.append(s);
				}
				return sb.toString();
		}
}
