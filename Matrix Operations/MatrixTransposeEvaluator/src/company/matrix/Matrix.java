package company.matrix;

/**
 * @author Rajat Biswas
 * Created on: 07-09-20
 * Do not modify.
 */
public class Matrix {
    private int[][] array;
    private final int row;
    private final int column;

    /*
    Explicit constructor when invoked will
    initialize row, column and array fields.
     */
    public Matrix(int row, int column) {
        this.column = column;
        this.row = row;
        this.array = new int[row][column];
    }

    public void setArray(int[][] array) {                                   //Setter function to enter value to the array.
        this.array = array;
    }

    /*
    Function when invoked will give out the
    logic: if row is equal to column or, not.
    */
    public boolean isSquare() {
        /*
        Alternate logic
        if (column == row) {
            return true;
        } else {
            return false;
        }
         */
        return column == row;
    }

    /*
    Function to give out transpose of a matrix.
     */
    public int[][] getTranspose() {
        if (!isSquare()) {
            return null;                                                        //will return null if the matrix is not square.
        } else {
            int[][] dummy = new int[row][column];                               //Making a copy of array field.
            for (int i = 0; i < row; i++) {                                     //loop to traverse the first index of the 2D array.
                for (int j = 0; j < column; j++) {                              //loop to traverse the second index of the 2D array.
                    dummy[i][j] = array[j][i];                                  //Swapping the row with the column(Transpose logic).
                }
            }

            return dummy;
        }
    }
}
