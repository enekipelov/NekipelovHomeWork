package task2;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;

/**
 * Created by Yevgeny on 17.11.2017.
 */
public class Point_1_to_7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Сколько чисел?");
        int numb = scan.nextInt();
        System.out.println("Введи " + numb + " чисел");
        int nums[] = new int[numb];
        for (int i = 0; i < numb; i++) {
            nums[i] = scan.nextInt();
        }
        shortestValue(nums); //[п.1]
        longestValue(nums); //[п.1]
        fromSmallest(nums);//[п.2]
        fromBigest(nums);//[п.2]
        valBigThanAv(nums);//[п.3]
        valLessThanAv(nums);//[п.3]
        printOfLeastNumberOfDifVal(nums);//[п.4]
        printHalfEvenOdd(nums);//[п.5]
        printFirstValueThatInIncreaseOrder(nums); //[п.6]
        printOfFirstDiffDigNum(nums);//[п.7]

        /*System.out.println("Минимальное значение  = " + minValue(nums));
        System.out.println("Максимальное значение = " + maxValue(nums));
        shortestValue(nums);
        longestValue(nums);
        printFirstValueThatInIncreaseOrder(nums);
        fromSmallest(nums);*/
    }

    public static void longestValue(int[] array) { //находит самое длинное значение
        int lonVal = array[0];
        for (Integer j : array) {
            Integer abslong;
            int znak;
            znak = j > 0 ? 1 : -1;
            abslong = j < 0 ? -j : j;
            if (abslong.toString().length() > Integer.toString(abs(lonVal)).length()) {
                lonVal = abslong * znak;
            }
        }
        System.out.println("Первое самое длинное число = " + lonVal + ", его длина = " + Integer.toString(abs(lonVal)).length());
    }


    public static void shortestValue(int[] array) { //находит самое короткое значение
        int shortVal = array[0];
        for (Integer j : array) {
            Integer abslong;
            int znak;
            znak = j > 0 ? 1 : -1;
            abslong = j < 0 ? -j : j;
            if (abslong.toString().length() < Integer.toString(abs(shortVal)).length()) {
                shortVal = abslong * znak;
            }
        }
        System.out.println("Первое самое короткое число = " + shortVal + ", его длина = " + Integer.toString(abs(shortVal)).length());
    }

    public static void valBigThanAv(int[] array) {                //печатает значания больше среднего
        System.out.println("Значения больше среднего:");
        for (int f : array) {
            if (f > averageVal(array)) {
                System.out.println(f + ",длина = " + Integer.toString(abs(f)).length());
            }

        }
    }

    public static void valLessThanAv(int[] array) {                //печатает значания меньше среднего
        System.out.println("Значения меньше среднего:");
        for (int f : array) {
            if (f < averageVal(array)) {
                System.out.println(f + ",длина = " + Integer.toString(abs(f)).length());
            }
        }
    }

    public static int averageVal(int[] array) {   //находит среднее значение
        int count = array.length;
        int sum = 0;
        int av;
        for (int k : array) {
            sum += k;
        }
        av = sum / count;
        return av;
    }

    public static void fromSmallest(int[] array) {   //печатает значения от меньшего к большему
        for (int i = 1; i < array.length; i++) {
            for (int j = i; (j >= 1) && (array[j] < array[j - 1]); j--) {
                int a = array[j];
                array[j] = array[j - 1];
                array[j - 1] = a;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void fromBigest(int[] array) {   //печатает значения от большего к меньшему
        for (int i = 1; i < array.length; i++) {
            for (int j = i; (j >= 1) && (array[j] > array[j - 1]); j--) {
                int a = array[j];
                array[j] = array[j - 1];
                array[j - 1] = a;
            }
        }
        System.out.println(Arrays.toString(array));
    }
    public static int numberOfDiffVal (Integer value){    //Нахождение количества разных цифр в числе
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0, count9 = 0, count0 = 0;
        int sumCount;
        for (int i = 0; i < Integer.toString(abs(value)).length() ; i++) {
            switch (Integer.toString(abs(value)).charAt(i)) {
                case '1':
                    count1 = 1;
                    break;
                case '2':
                    count2 = 1;
                    break;
                case '3':
                    count3 = 1;
                    break;
                case '4':
                    count4 = 1;
                    break;
                case '5':
                    count5 = 1;
                    break;
                case '6':
                    count6 = 1;
                    break;
                case '7':
                    count7 = 1;
                    break;
                case '8':
                    count8 = 1;
                    break;
                case '9':
                    count9 = 1;
                    break;
                case '0':
                    count0 = 1;
                    break;
                default:
                    sumCount = 9999999;
            }
        }
        sumCount = count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9 + count0;
        return sumCount;
    }

    public static void printOfLeastNumberOfDifVal(int[] array) {  //печать числа массива, в котором наименьшее количество разных цифр
        int m = numberOfDiffVal(array[0]);
        int mNum = 0;
        for (int i = 0; i < array.length; i++) {
            if (numberOfDiffVal(array[i]) < m) {
                m = numberOfDiffVal(array[i]);
                mNum = i;
            }
        }
        System.out.println("Число, в котором наименьшее количество различных цифр = " + array[mNum] + ",цифр - " + m);
    }

    public static void printHalfEvenOdd (int[] array) {     //печатает кол-во четных и среди них кол-во чисел с один кол-вом чет и нечет
        int countHalfEvenAndOdd = 0;
        int countEven = 0;
        for (int i:array) {
            if (i%2 == 0) {
                countEven +=1;
                if (isHalfEvenEqOdd(i)) countHalfEvenAndOdd +=1;
            }

        }
        System.out.println("Количество четных = " + countEven);
        System.out.println("Среди них с равным количеством чет и неч цифр = " + countHalfEvenAndOdd);
    }

    public static boolean isHalfEvenEqOdd(Integer value) {     //проверяет, содержит ли число равное количество чет и нечет цифр
        int countEven = 0;
        int countOdd = 0;

        for (int i = 0; i < Integer.toString(abs(value)).length() ; i++) {
            if ( Character.getNumericValue(Integer.toString(abs(value)).charAt(i))%2 == 0 ) {countEven +=1; }
            else countOdd +=1;

        }
        if (countEven == countOdd )
            return true;
        else    return false;
    }



    public static void printFirstValueThatInIncreaseOrder (int[] array){  //печатает первое число в котором цифры идут в порядке возрастания
        for (int y:array ) {
            Integer absol = abs(y);
            if (absol.toString().equals(sortNumber(y))) {
                System.out.println("Первое число в котором цифры идут в порядке возрастания = "+y);
                break;
            }

        }
    }
    public static String sortNumber(int number) {          //возвращает отсортированное в порядке возрастание число в виде строки
        String stringNumber = Integer.toString(abs(number));
        int arrayNumber[] = new int[stringNumber.length()];
        for (int i = 0; i < stringNumber.length(); i++) {
            arrayNumber[i] = Character.getNumericValue(stringNumber.charAt(i));
        }
        for (int i = 1; i < arrayNumber.length; i++) {
            for (int j = i; (j >= 1) && (arrayNumber[j] < arrayNumber[j - 1]); j--) {
                int a = arrayNumber[j];
                arrayNumber[j] = arrayNumber[j - 1];
                arrayNumber[j - 1] = a;
            }
        }
        String finalStringNumber  = "";
        for (int r:arrayNumber) {
            finalStringNumber += r;
        }
        return finalStringNumber;
    }
    public static boolean isDigInNumIsDiff (Integer value){    //проверяет, состоит ли число из разных цифр(правда) или нет(ложь)
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0, count9 = 0, count0 = 0;
        for (int i = 0; i < Integer.toString(abs(value)).length() ; i++) {
            switch (Integer.toString(abs(value)).charAt(i)) {
                case '1':
                    count1 += 1;
                    break;
                case '2':
                    count2 += 1;
                    break;
                case '3':
                    count3 += 1;
                    break;
                case '4':
                    count4 += 1;
                    break;
                case '5':
                    count5 += 1;
                    break;
                case '6':
                    count6 += 1;
                    break;
                case '7':
                    count7 += 1;
                    break;
                case '8':
                    count8 += 1;
                    break;
                case '9':
                    count9 += 1;
                    break;
                case '0':
                    count0 += 1;
                    break;
            }
        }
        if (count0 <2 && count1<2 && count2<2 && count3<2 && count4<2 && count5<2 && count6<2 && count7<2 && count8<2 && count9<2)
            return true;
        else
            return false;
    }
    public static void printOfFirstDiffDigNum (int[] array) {    //печатает первое число с разными цифрами
        boolean c = false;
        for (int u:array) {

            if (isDigInNumIsDiff(u)) {
                System.out.println("Первое число, в котором только разные цифры = "+u);
                c = true;
                break;
            }
        }
        if (!c)
            System.out.println("Все числа содержат повторяющиеся цифры");
    }

    public static int minValue(int[] array) {

        int minValue = array[0];
        for (int j : array) {
            if (j < minValue) {
                minValue = j;
            }
        }
        return minValue;

    }

    public static int maxValue(int[] array) {
        int maxValue = array[0];                                //Task6.2
        for (int j : array) {
            if (j > maxValue) {
                maxValue = j;
            }
        }
        return maxValue;
    }
}
