import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class arrarylist {

    static List<String>list;
    public static List<String> addOperators(String num, int target) {
        list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        dfs(num, 0,target, sb, 0, 0);

        return list;

    }


    public static void dfs(String num, int index, int target, StringBuffer sb, long res, long prev){

        if(index == num.length()){
            if(res == target){
                list.add(sb.toString());
            }
            return;

        }


        for(int i = index + 1; i <= num.length(); i++){
            String cur = num.substring(index, i);
            int curNum = Integer.parseInt(cur);
            if(index == 0){
                sb.append(cur);
                dfs(num, i, target, sb, curNum, curNum);
                sb.delete(sb.length() - cur.length(), sb.length());
            }
            else{
                sb.append("*");
                sb.append(cur);
                dfs(num, i, target, sb, res - curNum + curNum * prev, curNum * prev);
                sb.delete(sb.length() - cur.length() - 1, sb.length());
                sb.append("+");
                sb.append(cur);
                dfs(num, i, target, sb, res + curNum, curNum);
                sb.delete(sb.length() - cur.length() - 1, sb.length());
                sb.append("-");
                sb.append(cur);
                dfs(num, i, target, sb, res - curNum, -curNum);
                sb.delete(sb.length() - cur.length() - 1, sb.length());


            }

        }

    }

    public static void main(String[] args) {
        addOperators("123", 7);



    }
}
