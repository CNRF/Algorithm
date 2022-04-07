package Leetcode;

/**
 * https://leetcode-cn.com/problems/rotate-string/
 * @author mingxing.wang
 * @date 2022/4/7 11:50
 */
public class Code796 {
    public boolean rotateString(String s, String goal) {
        String ns=s+s;
        if(s.length()==goal.length()&&ns.contains(goal)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Code796 code796 = new Code796();
        boolean b = code796.rotateString("abc", "cab");
        System.out.println(b);
    }
}
