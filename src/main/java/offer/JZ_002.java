package offer;

/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2021/2/21 20:58
 */
public class JZ_002 {

    public static void main(String[] args){
        String target = "We Are Happy";
        String res = replaceSpace(target);
        System.out.println(res);


    }

    public static String replaceSpace(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        int len = s.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++){
            char ch  = s.charAt(i);
            if (ch == ' '){
                sb.append("%20");
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
