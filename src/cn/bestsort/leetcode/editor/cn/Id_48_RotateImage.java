//给定一个 n × n 的二维矩阵表示一个图像。 
//
// 将图像顺时针旋转 90 度。 
//
// 说明： 
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组

  
package cn.bestsort.leetcode.editor.cn;


public class Id_48_RotateImage{
        public static void main(String[] args) {
            Solution solution = new Id_48_RotateImage()
                              .new Solution();
            int[][] matrix = {
                    {5, 1, 9,11},
                    {2, 4, 8,10},
                    {13, 3, 6, 7},
                    {15,14,12,16}
            };
            solution.rotate(matrix);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.print(String.format("%5d",matrix[i][j]));
                }
                System.out.println();
            }
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        Point[] points = new Point[4];
        int cnt = 0;
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            cnt++;
            points[0] = setPoint(i, i);
            // ur
            points[1] = setPoint(len - cnt, i);
            // dr
            points[2] = setPoint(len - cnt, len - cnt);
            // dl
            points[3] = setPoint(i, len - cnt);
            for (int j = 0; j < len - i * 2 - 1; j++) {
                swapMatrix(matrix, points);
                points[0].x++;
                points[1].y++;
                points[2].x--;
                points[3].y--;
            }
        }
    }
    public void swapMatrix(int[][] matrix, Point[] points){
        for (int i = 3; i > 0; i--) {
            swap(points[i].y,points[i].x, points[i-1].y, points[i-1].x ,matrix);
        }
    }
    private void swap(int i, int j, int k, int l,int[][] matrix){
        int buf = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = buf;
    }
    public Point setPoint(int x, int y){
        return new Point(x, y);
    }
    class Point{
        int x, y;
        Point(){}
        Point(int x, int y){this.x = x; this.y = y;}
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}