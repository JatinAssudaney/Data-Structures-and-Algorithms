
public class GoalParser {
	// GENERIC SOLUTION
//	public String interpret(String command) {
//		String res = "";
//		int index = 0;
//		while (index < command.length()) {
//			char ch = command.charAt(index);
//			if (ch == '(') {
//				index++;
//				int start = index;
//				int end = index;
//				while (end < command.length() && command.charAt(end) != ')') {
//					end++;
//				}
//				if (start == end) {
//					res += "o";
//				} else {
//					res += command.substring(start, end);
//				}
//				index = end + 1;
//
//			} else {
//				res += ch;
//			}
//		}
//		return res;
//	}

	// SPECIFIC

	public String interpret(String command) {
		char[] orig = command.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < orig.length; i++) {
			if (orig[i] == 'G') {
				sb.append("G");
			} else if (orig[i] == '(') {
				if (orig[i + 1] == ')') {
					sb.append("o");
					i += 1;
				} else {
					sb.append("al");
					i += 3;
				}
			}
		}

		return sb.toString();
	}

}
