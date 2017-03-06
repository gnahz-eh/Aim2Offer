import java.util.*;

/**
 * Created by Administrator on 2017/3/6.
 */
public class PrintMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null) return res;
        int row = matrix.length;
        int col = 0;
        if (row != 0) {
            col = matrix[0].length;
            circleIn(matrix, res, 0, row - 1, 0, col - 1);
        }
        return res;
    }

    private void circleIn(int[][] matrix, List<Integer> res, int row_from, int row_to, int col_from, int col_to) {
        if (row_from > row_to || col_from > col_to) return;

        for (int j = col_from; j <= col_to; ++j)
            res.add(matrix[row_from][j]);
        for (int i = row_from + 1; i <= row_to; i++)
            res.add(matrix[i][col_to]);
        for (int j = col_to - 1; j >= col_from && row_from != row_to; --j)
            res.add(matrix[row_to][j]);
        for (int i = row_to - 1; i >= row_from + 1 && col_from != col_to; --i)
            res.add(matrix[i][col_from]);

        circleIn(matrix, res, row_from+1, row_to-1, col_from+1, col_to-1);
        return;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3,10},
                        {4,5,6,11},
                        {7,8,9,12}};
        PrintMatrix p = new PrintMatrix();
        List<Integer> res = p.spiralOrder(nums);
        for (int e : res)
            System.out.print(e + " ");
    }
}
