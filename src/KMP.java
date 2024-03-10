import java.util.*;
public class KMP {
    public static void main(String[] args){
        String a1 = "caaaaaaacdaaab";
        String a2 = "";
        System.out.println(search(a1,a2));
    }
    public static int search(String string,String object) {
        //创建两个变量起指针的作用
        int sp = 0;
        int op = 0;
        //先判断可能出现异常的情况
        if(string==null||object==null){
            return -1;
        }
        if(string.length()<object.length()){
        return  -1;
        }
        int next[] = get_next(object,object.length());
        while(sp<string.length()&&op<object.length()){
            if(op==-1||string.charAt(sp)==object.charAt(op)){
                op++;
                sp++;
            }else{
                op = next[op];
            }
            if (op>=object.length()){
                return sp-op;
            }
        }return -1;
    }
    public static int[] get_next(String object,int length){
        int next[]=new int[length];
        int i = 2;
        int j = 0;
        next[0] = -1;
        next[1] = 0;
        while (i<object.length()){
            //判断字符是否相等
            if(j == -1 || object.charAt(i-1) == object.charAt(j)){
                next[i] = j+1;
                i++;
                j++;
            }else{
                j = next[j];
            }
        }return next;
        }
}