package Task20;

import java.util.*;

/**
 * Матрица
 * @author vipmax
 */
public class Matrix {
    int[][] data;


    public Matrix(Integer row, Integer col) {
        this(new int[row][col]);

        Random random = new Random();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                data[i][j] = random.nextInt(10);
            }
        }
    }

    private Matrix(int[][] data) {
        this.data = data;

    }

    /**
     * Возвразает подматрицу
     * @param x стока левого верхнего угла
     * @param y столбец левого верхнего угла
     * @param rows  стока правого нижнего угла
     * @param columns столбец правого нижнего угла
     * @return
     */
    public Matrix getSubMatrix(int x, int y, int rows, int columns) {


        int[][] newData;
        try {
            newData = new int[rows - x][columns - y];
        } catch (Exception e) {
            return null;
        }

        for (int i = 0; i < newData.length; i++) {
            for (int j = 0; j < newData[i].length; j++) {
                newData[i][j] = data[x + i][y + j];
            }
        }

        return new Matrix(newData);
    }

    /**
     * определяет количество одниаковых эдементов в матрице
     * @return количество одниаковых эдементов в матрице
     */
    public Integer countOfIdenticalElements() {
        Map<Integer, Integer> integerIntegerMap = new Hashtable<>();
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[i].length; j++) {
                if (integerIntegerMap.containsKey(data[i][j])) {
                    integerIntegerMap.put(data[i][j], integerIntegerMap.get(data[i][j]) + 1);
                    continue;
                }
                integerIntegerMap.put(data[i][j], 1);
            }
        }

        Iterator<Integer> iterator = integerIntegerMap.values().iterator();
        Integer maxCountOfIdenticalElements = iterator.next();
        while (iterator.hasNext()) {
            Integer val = iterator.next();
            if (val > maxCountOfIdenticalElements) {
                maxCountOfIdenticalElements = val;
            }
        }

        return maxCountOfIdenticalElements;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++)
                sb.append(data[i][j]).append(" ");
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix = (Matrix) o;
        if (matrix.data.length != this.data.length || matrix.data[0].length != this.data[0].length) return false;


        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data.length; j++) {
                if (this.data[i][j] != matrix.data[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode () {
            return Arrays.hashCode(data);
        }
    }
