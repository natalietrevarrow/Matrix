public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {0, 1, 2, 3, 4}, 
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15}
        };
        MatrixSearch(matrix, 4);
    }
    
    public static int[] MatrixSearch(int[][] arr, int key) {
        System.out.println("key is: " + key);
        int numRows = arr.length;
        int numColumns = arr[0].length; 
        int arrLength = numRows*numColumns;
        int[] target = new int[2];
        int[] linear = new int[arrLength];

        //make linear version of array
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numColumns; j++) {
                linear[(i*numColumns)+j] = arr[i][j];
            }
        }

        //binary search in linear array version
        int begin = 0;
        int end = arrLength;
        int middle = (end-begin)/2;
            while(begin < end-1) {

                //is key in the middle, if so done
                if(key == linear[middle]) {
                    target[0] = middle/numColumns;
                    target[1] = middle%numColumns;
                    System.out.println("key in linear is at: " + middle);
                    System.out.println("key in matrix is at: [" + target[0] + "," + target[1]+ "]");
                    return target;
                }

                //if key is smaller than middle
                if(key < linear[middle]) {
                    end = middle;
                    middle = (end+begin)/2;
                }

                //if key is larger than middle
                if(key > linear[middle]) {
                    begin = middle;
                    middle = middle + ((end-begin)/2);
                }
                
            }
            System.out.println("key is not in matrix");
            return target;
        }
    }

