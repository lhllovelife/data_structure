package cn.andylhl.leetcode.array;

/***
 * @Title: TransposeMatrix867
 * @Description: 转置矩阵
 * @author: lhl
 * @date: 2021/3/20 17:16
 */
public class TransposeMatrix867 {


    /**
     * 转置矩阵：
     * @param matrix
     * @return
     */
    public int[][] transpose(int[][] matrix) {

        int m = matrix.length; // 矩阵行数
        int n = matrix[0].length; // 矩阵列数
        // 准备一个二维数组用于存储结果
        int[][] result = new int[n][m];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TransposeMatrix867 transposeMatrix867 = new TransposeMatrix867();

        int[][] matrix = new int[][] { {1,2,3},{4,5,6}};
        int[][] transpose = transposeMatrix867.transpose(matrix);

        for (int i = 0; i < transpose.length; i++) {
            for (int  j = 0; j < transpose[0].length; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }

    }

}
