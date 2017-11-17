package task2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Yevgeny on 16.11.2017.
 */
public class Matrix {
    public static void main(String[] args) {
        int[][] arrayNullColRow = {{0,0,0,7},{0,2,-3,7},{0,0,-3,0},{0,0,0,0}};
        int[][] customArray = {{1,-2,0,5},{-1,5,2,-2},{1,0,0,6},{5,-6,-8,90}};
        int[][] customArray2 = {{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4}};
        int[][] customArray3 = {{0,0,1,1},{2,0,2,0},{3,0,3,8},{0,0,0,4}};
        Scanner scanner = new Scanner(System.in);                                   //array NxN from console [п.9]
        System.out.println("Ввести размер матрицы");
        int sizeArray = scanner.nextInt();
        int[][] array = fillArray(sizeArray);
        printMatrix(array);
        LeftToRight(54,4); //Выводит числа от 1 до K (54) в виде матрицы NxN (4 x 4) слева направо [п.8]
        UpDown(30,5);//Выводит числа от 1 до K (30) в виде матрицы NxN (5 x 5) сверху вниз [п.8]
        System.out.println("Упорядоченные строки матрицы в порядке возрастания значений:");
        sortedRowMatrix(array); //печатает исходную и упорядоченную матрицы(строки в порядке возрастания) [п.9.1]
        sortedColMatrix(array);//печатает исходную и упорядоченную матрицы(столбцы в порядке возрастания) [п.9.1]
        shiftLeft(array,1);//циклический сдвиг заданной матрицы на k (1) позиций влево [п.9.2]
        shiftRight(array,1);//циклический сдвиг заданной матрицы на k (1) позиций вправо [п.9.2]
        moveDown(array,1);//циклический сдвиг заданной матрицы на k (1) позиций вниз [п.9.2]
        moveUp(array,1);//циклический сдвиг заданной матрицы на k (1) позиций вверх [п.9.2]
        inDecrease(array); //находит наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд [п.9.3]
        sumArray(customArray);// находит сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки [п.9.4]
        System.out.println("----Матрица для вращения:----");
        printMatrix(customArray2);
        rotateMatrix(customArray2,90);//вращает матрицу на 90 градусов [п.9.5]
        rotateMatrix(customArray2,180);//вращает матрицу на 180 градусов [п.9.5]
        rotateMatrix(customArray2,270);//вращает матрицу на 90 градусов [п.9.5]
        printMatrix(array);
        subtractionOfAverage(array); // строит матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое [п.9.6]
        System.out.println("-----------");
        printMatrix(arrayNullColRow);
        System.out.println("-----------");
        printMatrix(transpose(uplotnenie(transpose(uplotnenie(arrayNullColRow)))) ); //уплотнение матриицы [п.9.7]
        System.out.println("-----------");
        printMatrix(zeroToRight(customArray3)); //элементы, равные нулю, располагаются после всех остальных [п.9.8]
    }

    public static void LeftToRight(int k, int n) {   //матрица от 1 до K в виде NxN слева направо
        System.out.println("матрица от 1 до "+k+ " в виде "+ n + "x" + n+ " слева направо");
        int l = 1;
        int[][] matrix = new int[n][n];
        while ( l < k && (l<(n*n))){
            for (int j = 0; (j < n && l<=k); j++) {
                for (int i = 0; (i < n &&l<=k); i++) {
                    matrix[i][j] = l;
                    l += 1;
                }
            }
        }
        for (int j = 0; j <n ; j++) {
            for (int i = 0; i <n ; i++) {
                System.out.printf("%2d ",matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void UpDown(int k, int n) {   //матрица от 1 до K в виде NxN сверху вниз
        System.out.println("матрица от 1 до "+k+ " в виде "+ n + "x" + n+ " сверху вниз");
        int l = 1;
        int[][] matrix = new int[n][n];
        while ( l < k && (l<(n*n))){
            for (int j = 0; (j < n && l<=k); j++) {
                for (int i = 0; (i < n &&l<=k); i++) {
                    matrix[j][i] = l;
                    l += 1;
                }
            }
        }
        for (int j = 0; j <n ; j++) {
            for (int i = 0; i <n ; i++) {
                System.out.printf("%2d ",matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static void sortedColMatrix(int[][] array) { //Упорядочить столбцы матрицы в порядке возрастания значений.
        System.out.println("----Input Matrix----");
        printMatrix(array);

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                for (int rowTwo = row + 1; rowTwo < array.length; rowTwo++) {
                    if (array[rowTwo][col] < array[row][col]) {
                        int temp = array[row][col];
                        array[row][col] = array[rowTwo][col];
                        array[rowTwo][col] = temp;

                    }
                }
            }
        }
        System.out.println("----Sorted by Column Matrix------");
        printMatrix(array);
    }

    public static void sortedRowMatrix(int[][] array) {  //Упорядочить строки матрицы в порядке возрастания значений.
        System.out.println("----Input Matrix-----");
        printMatrix(array);

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                for (int colTwo = col + 1; colTwo < array[0].length; colTwo++) {
                    if (array[row][colTwo] < array[row][col]) {
                        int temp = array[row][col];
                        array[row][col] = array[row][colTwo];
                        array[row][colTwo] = temp;

                    }
                }
            }
        }
        System.out.println("----Sorted by Row Matrix------");
        printMatrix(array);
    }
    public static void shiftLeft(int[][] array, int q) {  //Сдвиг влево
        System.out.println("----Input Matrix-----");
        printMatrix(array);
        int temp, i, j;
        for (int r = 0; r < q; r++) {
            for (i = 0; i < array.length; i++) {
                temp = array[i][0];
                for (j = 0; j < array.length - 1; j++) {
                    array[i][j] = array[i][j + 1];
                }
                array[i][j] = temp;
            }
        }
        System.out.println("----After left shift----");
        printMatrix(array);

    }
    public static void shiftRight(int[][] array, int q) {  //Сдвиг вправо
        System.out.println("----Input Matrix-----");
        printMatrix(array);
        int temp, i, j;
        for (int r = 0; r < q; r++) {
            for (i = 0; i < array.length; i++) {
                temp = array[i][array.length - 1];
                for (j = array.length - 1; j > 0; j--) {
                    array[i][j] = array[i][j - 1];
                }
                array[i][j] = temp;
            }
        }
        System.out.println("----After right shift----");
        printMatrix(array);

    }
    public static void moveDown(int[][] array,int q) { //сдвиг вниз
        System.out.println("----Input Matrix-----");
        printMatrix(array);
        int temp, i, j;
        for (int r = 0; r < q; r++) {
            for (i = 0; i < array.length; i++) {
                temp = array[array.length - 1][i];
                for (j = array.length - 1; j > 0; j--) {
                    array[j][i] = array[j - 1][i];
                }
                array[j][i] = temp;
            }
        }
        System.out.println("----After shift down----");
        printMatrix(array);
    }
    public static void moveUp(int[][] array, int q) { //сдвиг вверх
        System.out.println("----Input Matrix-----");
        printMatrix(array);
        int temp, i, j;
        for (int r = 0; r < q; r++) {
            for (i = 0; i < array.length; i++) {
                temp = array[0][i];
                for (j = 0; j < array.length - 1; j++) {
                    array[j][i] = array[j + 1][i];
                }
                array[j][i] = temp;
            }
        }
        System.out.println("----After shift up----");
        printMatrix(array);
    }
    public static void inDecrease(int[][] array) {
        int[] f = new int[array.length * array.length];//преобразование в одномерный массив
        int c = 0;int r=0;int max=0;int h=0;int m=0;int min=0;int h1=0;
        for(int[]x:array){
            for(int z:x){
                f[c++] =z;
            }
        }
        for (int g=0;g<f.length-1;g++){
            if(f[g]<f[g+1]){//если последующий элемент больше
                r+=1;
                if(r>max){max=r;h=g+1;}//запоминаем количество возрастаний и индекс последнего возрастающего элем
            }else{r=0;}//возрастание прервалась
            if(f[g]>f[g+1]){
                m+=1;
                if(m>min){min=m;h1=g+1;}//запоминаем количество возрастаний и индекс последнего убыв элем
            } else{m=0;}// убывание прервалась
        }
        System.out.println("Наибольшее число возрастающих элементов матрицы:");
        int[]l=new int[max+1];
        System.arraycopy(f,(h-max),l,0,(max+1));//копирую последовательность возр элем в новый массив
        System.out.println(Arrays.toString(l)+" "+(max+1));
        System.out.println("Наибольшее число убывающих элементов матрицы:");
        int[]t=new int[min+1];
        System.arraycopy(f,(h1-min),t,0,(min+1));//копирую последовательность убыв элем в новый массив
        System.out.println(Arrays.toString(t)+" "+(min+1));
    }
    public static void sumArray(int[][] array){ //считает сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки.
        System.out.println("Сумма элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки");
        for (int[]x:array) {
            sum(x);
        }
    }
    static void sum(int[] simpleArray) {   //считает сумму элементов одномерного массива, расположенных между первым и вторым положительными элементами
        int indexStart = 0, indexEnd = 0;
        for (int i = 0; i < simpleArray.length; i++) {
            if (simpleArray[i] > 0) { indexStart = i; break; }
        }

        for (int i = indexStart+1; i < simpleArray.length ; i++) {
            if (simpleArray[i] > 0) { indexEnd = i; break; }
        }

        int sum = 0;

        for (int i = indexStart + 1; i < indexEnd; i++)
            sum += simpleArray[i];

        System.out.println(sum);//выведет 0, если индексы были равны.

    }
    public static void rotateMatrix(int[][] matrix, int degree){

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] rotated = null;

        for(int i=0; i<row; i++){

            for(int j=0; j<col; j++){

                if (degree == 90) {
                    if(rotated == null) rotated = new int[col][row];
                    rotated[col-j-1][i] = matrix[i][j];
                }

                if (degree == 180) {
                    if(rotated == null) rotated = new int[row][col];
                    rotated[row-i-1][col-j-1] = matrix[i][j];
                }

                if (degree == 270) {
                    if(rotated == null) rotated = new int[col][row];
                    rotated[j][row-i-1] = matrix[i][j];
                }
            }
        }
        System.out.println("Matrix rotated " + degree + ":");
        printMatrix(rotated);
    }
    public static void subtractionOfAverage(int[][] array) { //Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое.
        for (int i = 0; i <array.length ; i++) {
            int av  = getAvRow(array[i]);
            for (int j = 0; j <array[0].length ; j++) {
                int temp = array[i][j]-av;
                array[i][j] = temp;
            }
        }
        System.out.println("После вычитания:");
        printMatrix(array);
    }
    public static int getAvRow(int[] row) {
        int sum=0;
        for (int i:row) {
            sum +=i;
        }
        int ave = sum/row.length;
        return ave;
    }
    public static int[][] transpose(int[][] m) {   //поворот матрицы
        int r = m.length;
        int c = m[0].length;
        int[][] t = new int[c][r];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                t[j][i] = m[i][j];
            }
        }
        return t;
    }

    public static int[][] uplotnenie (int[][] array){  //удаление нулевой строки

        boolean[] deleteTheseRow = new boolean[array.length];
        int countRow = 0;

        int rows = array.length;
        int cols = array[0].length;
        for(int i=0;i<rows;i++){
            boolean allZerosRow = true;
            for(int j=0;j<cols;j++){
                if (array[i][j] != 0){
                    allZerosRow = false;
                    break;
                }
            }
            deleteTheseRow[i] = allZerosRow;
            if (allZerosRow){
                countRow++;
            }
        }
        //
        if (countRow == 0){
            return array;
        }else if (countRow == array.length){
            return new int[0][0];
        }else{
            int[][] newMatrix = new int[rows - countRow][cols];
            int idx = -1;
            for(int i=0;i<rows;i++){
                if (!deleteTheseRow[i]){
                    idx++;
                    newMatrix[idx] = array[i];
                }
            }
            return newMatrix;
        }

    }
    public static int[][] zeroToRight(int[][] b) { // Преобразовать строки матрицы таким образом, чтобы элементы, равные нулю, располагались после всех остальных.
        for (int i = 0; i < b.length; i++) {
            int n = 0;
            int[] c = new int[b.length];
            for (int j = 0; j < b.length; j++) {
                if (b[i][j] != 0) {
                    c[n++] = b[i][j];
                }
            }
            b[i] = Arrays.copyOf(c, c.length);
        }
        return b;
    }

    public static int[][] fillArray(int sizeArray) {                   //заполнение двумерного массива случайными числами
        Random h = new Random();
        int array[][] = new int[sizeArray][sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            for (int j = 0; j <sizeArray; j++) {
                array[i][j] = h.nextInt()%100;
            }
        }
        return array;
    }

    public static void printMatrix (int[][] array){         //печать двумерного массива
        int row = array.length;
        int columns = array[0].length;
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <columns ; j++) {
                System.out.printf("%2d ",array[i][j]);
            }
            System.out.println();
        }
    }
}
