package offer;

/**
 * @author wmx
 * @version 1.0
 * @className Code05
 * @description
 * @date 2022/1/5 14:50
 */
public class Code05 {
    public static String replaceSpace(String s) {
        // String s2 = s1.replaceAll("\\s", "%20");
        StringBuffer result = new StringBuffer();
        if (s == null || s.length() == 0) {
            return result.toString();
        }
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                result.append("%20");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "We are happy.";
        String s = replaceSpace("We are happy.");
        System.out.println(s);
    }
}
