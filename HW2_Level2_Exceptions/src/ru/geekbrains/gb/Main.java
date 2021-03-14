package ru.geekbrains.gb;

public class Main {

    public static void main(String[] args) {
        String arrRight[][] = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String arrWrong[][] = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String arrWrong2[][] = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "k", "4"}
        };
        try{
            System.out.println(sumNumbers(arrWrong2));
        } catch (ArrayIndexOutOfBoundsException e){
            throw new MyArraySizeException("Size incorrect! Must be 4x4!", e);
        } catch (NumberFormatException e){
            throw new MyArrayDataException("Incorrect input! You need to use only numbers!", e);
        }
    }

    private static int sumNumbers(String arrStr[][]){
        if (!(arrStr.length == arrStr[0].length && arrStr.length == 4))
            throw new ArrayIndexOutOfBoundsException();

        int sum = 0;
        for (int i = 0; i < arrStr.length; i++) {
            for (int j = 0; j < arrStr[0].length; j++) {
                  try {
                    sum += Integer.parseInt(arrStr[i][j]);
                  } catch (NumberFormatException e){
                      j++; i++;
                      throw new NumberFormatException("Column: " + j + " row: " + i + " is not a number!");
                  }

            }
        }
        return sum;
    }
}
