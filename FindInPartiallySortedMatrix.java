/**
 * Created by Administrator on 2017/3/2.
 */
class Index {
    public int row;
    public int col;

    public Index () {
        this.row = 0;
        this.col = 0;
    }

    public Index (int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class FindInPartiallySortedMatrix {

    public Index find (int[][] matrix, int rows, int cols, int key) {
        if (matrix != null && rows > 0 && cols > 0) {
            int row = 0;
            int col = cols - 1;
            while (row < rows && col >= 0) {
                if (matrix[row][col] == key)
                    return new Index(row, col);
                else if (matrix[row][col] > key)
                    --col;
                else
                    ++row;
            }
        }
        return new Index(-1, -1);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                          {5, 6, 7, 8},
                          {9, 10, 11, 12},
                          {13, 14, 15, 16}};

        FindInPartiallySortedMatrix f = new FindInPartiallySortedMatrix();
        Index index = f.find(matrix, 4, 4, 16);
        System.out.print(index.row + " " + index.col);

    }
}