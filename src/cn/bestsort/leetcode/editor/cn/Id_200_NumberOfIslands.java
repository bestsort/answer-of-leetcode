//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
//网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

  
package cn.bestsort.leetcode.editor.cn;

public class Id_200_NumberOfIslands{
        public static void main(String[] args) {
            Solution solution = new Id_200_NumberOfIslands()
                              .new Solution();
            String[] rs= {"11110",
                          "11010",
                          "11000",
                          "00000"};
            char[][] chars = new char[4][];
            for (int i = 0; i < rs.length; i++) {
                chars[i] = rs[i].toCharArray();
            }
            System.out.println(solution.numIslands(chars));
        }
        

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int res = 0;
    private int[][] dir = {{0,-1,0,1},
                           {-1,0,1,0}};
    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(IsLegal(i,j,grid)){
                    dfs(i,j,grid);
                    res++;
                }
            }
        }
        return res;
    }
    private boolean IsLegal(int i,int j,char[][] grid){
        return i >= 0 && i < grid.length &&
                j >= 0 && j < grid[i].length
                && grid[i][j] == '1';
    }
    private void dfs(int i,int j,char[][] grid){
        grid[i][j] = '2';
        for (int k = 0; k < 4; k++) {
            int bufI = i + dir[0][k];
            int bufJ = j + dir[1][k];
            if (IsLegal(bufI, bufJ, grid)) {
                grid[bufI][bufJ] = '2';
                dfs(bufI, bufJ, grid);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}