package ru.geekbrains.gb;

public class Main {

    public static void main(String[] args) {
        String[][] arrRight = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][]arrWrong = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] arrWrong2 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "kkkk", "4"}
        };

        System.out.println(sumNumbers(arrWrong2));
    }

    private static int sumNumbers(String[][] arrStr){
        checkSize(arrStr.length);
        for (String[] strings : arrStr) {
            checkSize(strings.length);
        }
        //А таким был мой вариант перед разбором дз(
        //if (!(arrStr.length == arrStr[0].length && arrStr.length == 4))
        //    throw new ArrayIndexOutOfBoundsException();

        int sum = 0;
        for (int i = 0; i < arrStr.length; i++) {
            for (int j = 0; j < arrStr[1].length; j++) {
                  try {
                    sum += Integer.parseInt(arrStr[i][j]);
                  } catch (NumberFormatException e){
                      i++; j++;
                      String message = String.format("Row - %s , Column - %s is not a number!", i , j);
                      throw new MyArrayDataException(message, e);
                  }
            }
        }
        return sum;
    }

    private static void checkSize(int length){
        if (length != 4){
            throw new MyArraySizeException("Size incorrect! Must be 4x4!");
        }
    }
}
