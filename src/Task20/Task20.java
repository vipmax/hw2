package Task20;


import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * Created by vipmax on 21.04.2014.
 */
public class Task20 {


    public static void main(String[] args) {
        Matrix matrix = new Matrix(5,5);
        System.out.println(matrix);
        Stack<Matrix> matrixStack = getAllSubMatrix(matrix);

//        System.out.println("В main стеке:");
//        try {
//            matrixStack.forEach(matr -> System.out.println("***********\n" + matr));
//        } catch (Exception e) {
//
//        }
        matrix = getSubMatrix(matrix);
        System.out.println("matrix \n" + matrix+"\nколичество одинаковых элементов = "+matrix.countOfIdenticalElements());
    }

    private static Stack<Matrix> getAllSubMatrix(Matrix matrix) {
        Stack<Matrix> matrixStack = new Stack<>();

        for (int x = 0; x < matrix.data.length; x++)
            for (int y = 0; y < matrix.data[x].length;y++)
                for (int i = 0; i < matrix.data.length; i++) {
                    for (int j = 0; j < matrix.data[i].length; j++) {

                        Matrix subMatrix = null;
                        try {
                            subMatrix = matrix.getSubMatrix(x, y, i + 1, j + 1);
                            if ((subMatrix == null) ) {
//                                System.out.println("subMatrix==null");
                                continue;
                            }
                            if (matrixStack.contains(subMatrix)) {
//                                System.out.println("matrixStack.contains(subMatrix)");
                                continue;
                            }
//                            System.out.println("*********** for " + subMatrix.data[0][0] + "\n" + subMatrix);

                            matrixStack.add(subMatrix);
                        } catch (Exception e) {
//                        e.printStackTrace();
                        }

                    }

                }

//        System.out.println("В стеке:");
//        try {
//            matrixStack.forEach(matr -> System.out.println("***********\n" + matr));
//        } catch (Exception e) {
//
//        }
        return matrixStack;
    }

    private static Matrix getSubMatrix(Matrix matrix) {
        Stack<Matrix> matrixStack = new Stack<>();
        Matrix resultMatrix = matrix.getSubMatrix(0,0,1,1);
        System.out.println("resultMatrix = " + resultMatrix);
        Integer resultCountOfIdenticalElements1 = resultMatrix.countOfIdenticalElements();

        for (int x = 0; x < matrix.data.length; x++)
            for (int y = 0; y < matrix.data[x].length;y++)
                for (int i = 0; i < matrix.data.length; i++) {
                    for (int j = 0; j < matrix.data[i].length; j++) {

                        Matrix subMatrix = null;
                        try {
                            subMatrix = matrix.getSubMatrix(x, y, i + 1, j + 1);
                            if ((subMatrix == null) ) {
                                continue;
                            }

                            System.out.println("*********** for " + subMatrix.data[0][0] + ". количество одинаковых элементов= "+subMatrix.countOfIdenticalElements()+ "\n" + subMatrix);
                            if (subMatrix.equals(matrix)) {
                                System.out.println("такая же как исходная матрица, и мы ее пропускаем, иначе не было бы смысла");
                                continue;
                            }
                            Integer countOfIdenticalElements = subMatrix.countOfIdenticalElements();
                            if (countOfIdenticalElements > resultCountOfIdenticalElements1 ) {
                                resultCountOfIdenticalElements1 = countOfIdenticalElements;
                                resultMatrix = subMatrix;
                                System.out.println("resultMatrix = " + resultMatrix + "\nколичество одинаковых элементооооооооооооооооооооооооооооов= "+resultMatrix.countOfIdenticalElements());
                            }

                        } catch (Exception e) {
                        }

                    }
                }
        return  resultMatrix;
    }
}


