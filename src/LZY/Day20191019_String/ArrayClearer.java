package LZY.Day20191019_String;

/**
 * 清除行列 2019.10.23
 */
public class ArrayClearer {
    public static void main(String[] args) {
        int[][] arr = {{1,1,1},{0,1,1},{1,0,1}};
        int[][] result = clearer(arr, 3);
        for (int i = 0; i<result.length; i++) {
            for (int j = 0; j<result.length; j++) {
                System.out.println(result[i][j]+",");
            }
        }
    }

    private static int[][] clearer(int[][] mat, int n) {
        int[] line = new int[n];
        int[] column = new int[n];
        for (int i = 0; i<line.length && i<column.length; i++) {
            line[i] = -1;
            column[i] = -1;
        }
        int count1 = 0, count2 = 0;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (mat[i][j] == 0) {
                    line[count1] = i;
                    column[count2] = j;
                    count1++;
                    count2++;
                }
            }
        }

        for (int i = 0; i<line.length; i++) {
            for (int j = 0; j<n; j++) {
                if (line[i] != -1)
                    mat[line[i]][j] = 0;
            }
        }
        for (int i = 0; i<column.length; i++) {
            for (int j = 0; j<n; j++) {
                if (column[i] != -1)
                    mat[j][column[i]] = 0;
            }
        }
        return mat;
    }
}
