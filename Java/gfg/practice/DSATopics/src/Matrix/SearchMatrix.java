package Matrix;

public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int startrow = 0, endrow = m-1;
        while(startrow <= endrow) {
            int mid = (startrow + endrow) / 2;
            if(matrix[mid][0] == target) {
                return true;
            } else if(matrix[mid][0] > target) {
                endrow = mid - 1;
            } else {
                if(matrix[mid][n-1] >= target) {
                    // search this array
                    for(int i = 0; i < n; i++) {
                        if(matrix[mid][i] == target) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    startrow = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;

        System.out.println(searchMatrix(matrix, target));
    }
}
