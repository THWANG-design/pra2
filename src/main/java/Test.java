import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Test {

    public static class findWords {
        boolean flag = false;
        public boolean findWords(char[][]set, String word){
            boolean[][]map = new boolean[set.length][set[0].length];
            for(int i = 0 ; i < set.length; i ++){
                for(int j = 0; j < set[0].length; j ++){
                    if(set[i][j] == word.charAt(0)){
                        dfs(set, word, i, j, 0, map);
                        if(flag)
                            return true;

                    }
                }
            }
            return  false;

        }

        public void dfs(char[][]set, String word, int start , int end,int count,boolean[][] map){

            if(start < 0 || end < 0 || start > set.length -1 || end > set[0].length - 1 || set[start][end] != word.charAt(count) || map[start][end])
                    return ;

            map[start][end] = true;
            count++;
            if(count == word.length()){
                flag = true;
                return;
            }

            dfs(set, word, start + 1, end , count, map);
            dfs(set, word, start - 1, end , count, map);
            dfs(set, word, start , end + 1, count, map);
            dfs(set, word, start , end - 1, count, map);

            map[start][end] = false;



        }


    }

    public static void main(String[] args) {
        findWords solution = new findWords();
        char[][]set = new char[][]{{'X','Y','Z','E'}, {'S','F','Z','S'},{'X','D','E','E'}};
        boolean flag = solution.findWords(set, "SFZSEZYXS");
        System.out.println(flag);

    }

}
