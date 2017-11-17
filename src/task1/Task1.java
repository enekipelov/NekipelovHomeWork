package task1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Yevgeny on 18.11.2017.
 */

public class Task1 {
    public static void main(String[] args) {
        //task_1_1();
        //task_1_2(args);
        //task_1_3();
        //task_1_4(args);
        //task_1_5(args);
        Scanner scanner = new Scanner(System.in);                                   //array from console
        System.out.println("Enter amount of numbers for executing:");
        int numb = scanner.nextInt();
        System.out.println("Enter " + numb + " integer numbers");
        int[] nums = new int[numb];
        for (int i = 0; i < numb; i++) {
            nums[i] = scanner.nextInt();
        }
        //task_6_1(nums);
        //task_6_2(nums);
        //task_6_3(nums);
        //task_6_4(nums);
        //task_6_5(nums);
        //task_6_6(nums);
        //task_6_7(nums);


    }

    private static void task_6_7(int[] nums) {
        for (int i = 1; i<nums.length-1; i++){      //   Task6.7
            int sum = (nums[i-1]+nums[i+1])/2;
            if ( sum == nums[i])
                System.out.println(nums[i]);
        }
    }

    private static void task_6_6(int[] nums) {
        String number;                                                   //task 6.6
        int n0,n1,n2,n3,n4,n5;
        for (Integer i:nums){
            if (i.toString().length() ==6 && i>0) {
                number = i.toString();
                n0 = Character.getNumericValue(number.charAt(0));
                n1 = Character.getNumericValue(number.charAt(1));
                n2 = Character.getNumericValue(number.charAt(2));
                n3 = Character.getNumericValue(number.charAt(3));
                n4 = Character.getNumericValue(number.charAt(4));
                n5 = Character.getNumericValue(number.charAt(5));
                if ((n0+n1+n2) == (n3+n4+n5)) {
                    System.out.println(i + " - счастливое число");
                }
            }
        }
    }

    private static void task_6_5(int[] nums) {
        String number;                                                   //task 6.5
        for (Integer i:nums){
            if (i.toString().length() ==3 && i>0) {
                number = i.toString();
                if (number.charAt(0) != number.charAt(1) && number.charAt(0) != number.charAt(2) && number.charAt(1) != number.charAt(2)) {
                    System.out.println(i + " -3-х значные числа с разными числами");
                }
            }
        }
    }

    private static void task_6_4(int[] nums) {
        int n = 0;                                        //Task6.4
        for (int i:nums) {
            if (i % 5 == 0 && i % 7 == 0) {
                n++;
                System.out.print(i + " ");
            }
        }
        if (n >0) {System.out.println(" -делятся на 5 и на 7 без остатка");}
        else System.out.println("Чисел, делящихся на 5 и на 7 без остатка, нет");
    }

    private static void task_6_3(int[] nums) {
        int n = 0;                                        //Task6.3
        for (int i:nums) {
            if (i % 3 == 0 || i % 9 == 0) {
                n++;
                System.out.print(i + " ");
            }
        }
        if (n >0) {System.out.println(" - делятся на 3 или 9 без остатка");}
        else System.out.println("Чисел, делящихся на 3 или 9 без остатка, нет");
    }

    private static void task_6_2(int[] nums) {
        int maxValue = nums[0];                                //Task6.2
        for (int j: nums) {
            if (j > maxValue) {maxValue = j;}
        }
        System.out.println("Max value: " + maxValue);

        int minValue = nums[0];
        for (int j: nums) {
            if (j < minValue) {minValue = j;}
        }
        System.out.println("Min value: " + minValue);
    }

    private static void task_6_1(int[] nums) {
        for (int j :nums ) {                              //Task6.1
            if (j % 2 == 0) {
                System.out.print(j + " ");
            }
        }
        System.out.println(" - even");

        for (int j :nums ) {
            if (j % 2 != 0) {
                System.out.print(j + " ");
            }
        }
        System.out.println(" - odd");
    }

    private static void task_6() {
        Scanner scanner = new Scanner(System.in);                                   //array from console
        System.out.println("Enter amount of numbers for executing:");
        int numb = scanner.nextInt();
        System.out.println("Enter " + numb + " integer numbers");
        int[] nums = new int[numb];
        for (int i = 0; i < numb; i++) {
            nums[i] = scanner.nextInt();
        }
    }

    private static void task_1_5(String[] args) {
        int sum = 0;                //Task1.5 , add number row to command line
        int mult = 1;
        for (int i=0; i<args.length; i++) {
            sum += Integer.parseInt(args[i]);
            mult *= Integer.parseInt(args[i]);

        }
        System.out.println("sum = " + sum);
        System.out.println("mult = " + mult);
    }

    private static void task_1_4(String[] args) {
        String passw = Arrays.toString(args).replace("[","").replace("]",""); //Task1.4  , add 'password' to command line
        String sample = "password";

        if (sample.equals(passw)){
            System.out.println("Passwords are equals");
            System.out.println(passw);}
        else {
            System.out.println("Passwords are not equals");
            System.out.println(passw);
        }
    }

    private static void task_1_3() {
        Random randomInt = new Random();                         //Task1.3
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the amount of numbers should be printed: ");

        int number = scan.nextInt();
        System.out.println("Enter the range of random values:");
        int range = scan.nextInt();
        System.out.println("New line list:");
        for (int i = number; i > 0; i--) {
            System.out.println(randomInt.nextInt(range));

        }
        System.out.println("One line list:");
        for (int i = number; i > 0; i--) {
            System.out.print(randomInt.nextInt(range) + " ");
        }
    }

    public static void task_1_2(String[] args) {
        for (int i = args.length; i >0 ; i--) {               //Task1.2. add params to com line
            System.out.println(i);
        }
    }

    private static void task_1_1() {
        Scanner scan = new Scanner(System.in);                //Task1.1
        System.out.println("Enter your name:");
        String name = scan.next();
        System.out.println("Hello, " + name + "!");
    }

    public static int minValue(int[] array) {  //Task6.2

        int minValue = array[0];
        for (int j: array) {
            if (j < minValue) {minValue = j;}
        }
        return minValue;

    }
    public static int maxValue(int[] array){     //Task6.2
        int maxValue = array[0];
        for (int j: array) {
            if (j > maxValue) {maxValue = j;}
        }
        return maxValue;
    }
}
