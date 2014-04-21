package Task20;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by vipmax on 21.04.2014.
 */
public class Task20 {


    private Matrix matrix;
    private Matrix resultMatrix;
    private List<String> buildInfo;

    public Task20() {
        new Task20Form(this);
    }

    public static void main(String[] args) {
//        Matrix matrix = new Matrix(4, 3);
//        System.out.println(matrix);
//        Stack<Matrix> matrixStack = getAllSubMatrix(matrix);

//        System.out.println("В main стеке:");
//        try {
//            matrixStack.forEach(matr -> System.out.println("***********\n" + matr));
//        } catch (Exception e) {
//
//        }
//        matrix = getSubMatrix(matrix);
//        System.out.println("matrix \n" + matrix + "\nколичество одинаковых элементов = " + matrix.countOfIdenticalElements());
    }

    private static Stack<Matrix> getAllSubMatrix(Matrix matrix) {
        Stack<Matrix> matrixStack = new Stack<>();

        for (int x = 0; x < matrix.data.length; x++)
            for (int y = 0; y < matrix.data[x].length; y++)
                for (int i = 0; i < matrix.data.length; i++) {
                    for (int j = 0; j < matrix.data[i].length; j++) {

                        Matrix subMatrix = null;
                        try {
                            subMatrix = matrix.getSubMatrix(x, y, i + 1, j + 1);
                            if ((subMatrix == null)) {
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

    public Matrix getMatrix() {
        return matrix;
    }

    public List<String> getBuildInfo() {
        return buildInfo;
    }

    private Matrix getSubMatrix(Matrix matrix) {
        Stack<Matrix> matrixStack = new Stack<>();
        buildInfo = new ArrayList<>();
        Matrix resultMatrix = matrix.getSubMatrix(0, 0, 1, 1);
        buildInfo.add("Исходния матрица\n"+matrix.toString()+"\nначинаю анализ \n");
//        System.out.println("resultMatrix = " + resultMatrix);
        Integer resultCountOfIdenticalElements1 = resultMatrix.countOfIdenticalElements();

        for (int x = 0; x < matrix.data.length; x++)
            for (int y = 0; y < matrix.data[x].length; y++)
                for (int i = 0; i < matrix.data.length; i++) {
                    for (int j = 0; j < matrix.data[i].length; j++) {

                        Matrix subMatrix = null;
                        try {
                            subMatrix = matrix.getSubMatrix(x, y, i + 1, j + 1);
                            if ((subMatrix == null)) {
                                continue;
                            }


                            String s = "Анализирую  " + subMatrix.data[0][0] + ". количество одинаковых элементов= " + subMatrix.countOfIdenticalElements() + "\n" + subMatrix;
                            buildInfo.add(s);
//                            System.out.println(s);
                            if (subMatrix.equals(matrix)) {
                                s = "такая же как исходная матрица, и мы ее пропускаем, иначе не было бы смысла";
                                buildInfo.add(s);
//                                System.out.println(s);
                                continue;
                            }
                            Integer countOfIdenticalElements = subMatrix.countOfIdenticalElements();
                            if (countOfIdenticalElements > resultCountOfIdenticalElements1) {
                                resultCountOfIdenticalElements1 = countOfIdenticalElements;
                                resultMatrix = subMatrix;
                                s = "resultMatrix = \n" + resultMatrix + "\nНашли больше. Теперь количество одинаковых элементов = " + resultMatrix.countOfIdenticalElements()+ "*********************";
                                buildInfo.add(s);
//                                System.out.println(s);
                            }

                        } catch (Exception e) {
                        }

                    }
                }
        buildInfo.add("Итоговая матрица \n"+resultMatrix.toString()+"\n" + "Максимальное количество одинаковых элементов = " + resultMatrix.countOfIdenticalElements());
        return resultMatrix;
    }

    public Matrix getResultMatrix() {
        return resultMatrix;
    }

    public void build(Integer row, Integer col) {
        matrix = new Matrix(row, col);
        resultMatrix = getSubMatrix(matrix);

    }
}


