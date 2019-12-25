package stringtrain;

public class Num468 {
    //思路:
    // 1.先排除不含有"."和":"的，再排除以"."和":"开始和结束的；
    // 2.当含有"."时，用split函数切割成数组，判断每个元素是否满足IPv4条件；
    // 3.当含有":"时，用split函数切割成数组，判断每个元素是否满足IPv6条件。
    //执行用时 :2 ms, 在所有 java 提交中击败了85.37%的用户
    //内存消耗 :34.5 MB, 在所有 java 提交中击败了90.20%的用户
    public static void main(String [] arrs){
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
    public static String validIPAddress(String IP) {
        if (IP.startsWith(".")||IP.startsWith(":")||IP.endsWith(".")||IP.endsWith(":")) return "Neither";
        String[] strings=null;
        if (IP.contains(".")){
            strings = IP.split("\\.");
            if (strings.length==4){
                if (validIPv4(strings[0])&&validIPv4(strings[1])&&validIPv4(strings[2])&&validIPv4(strings[3])){
                    return "IPv4";
                }else {
                    return "Neither";
                }
            }else{
                return "Neither";
            }
        }else if (IP.contains(":")){
            strings = IP.split(":");
            if (strings.length==8){
                for (String str:strings){
                    if (!validIPv6(str)){
                        return "Neither";
                    }
                }
                return "IPv6";
            }else{
                return "Neither";
            }

        }
        return "Neither";
    }

    private static boolean validIPv4(String str) {
        if (str==null||str.length()==0||str.length()>3||(str.charAt(0)=='0'&&str.length()>1)){
            return false;
        }
        for(int i=0; i<str.length();i++){
            char c = str.charAt(i);
            if(!(c>='0'&&c<='9')){
                return false;
            }
        }
        if (Integer.parseInt(str)>255){
            return false;
        }
        return true;
    }

    private static boolean validIPv6(String str) {
        if (str==null||str.length()==0||str.length()>4){
            return false;
        }
        for(int j=0;j<str.length();j++){
            char c = str.charAt(j);
            if(!((c>='0'&&c<='9')||(c>='a'&&c<='f')||(c>='A'&&c<='F'))){
                return false;
            }
        }
        return true;
    }


}
