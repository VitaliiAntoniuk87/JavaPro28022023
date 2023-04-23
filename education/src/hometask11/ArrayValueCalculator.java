package hometask11;


public class ArrayValueCalculator {

    public static void main(String[] args) {

        String[][] inputStringData = {{"5", "7", "3", "17"},
                {"7", "2", "1", "12"},
                {"7", "d", "6", "8"},
                {"5", "7", "3", "9"}};
        try {
            System.out.println(doCalc(inputStringData));
        } catch (ArraySizeException | ArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int doCalc(String[][] inputStringData) throws ArraySizeException, ArrayDataException {
        int sum = 0;
        if (inputStringData.length == 4 && inputStringData[0].length == 4 && inputStringData[1].length == 4
                && inputStringData[2].length == 4 && inputStringData[3].length == 4) {
            for (int i = 0; i < inputStringData.length; i++) {
                for (int j = 0; j < inputStringData[0].length; j++) {
                    try {
                        sum += Integer.parseInt(inputStringData[i][j]);
                    } catch (NumberFormatException e) {
                        throw new ArrayDataException("Invalid data at array element:" + "[" + i + "]" + "[" + j + "]");
                    }
                }
            }
        } else {
            throw new ArraySizeException("Incorrect array size! Only 4 x 4 is allowed");
        }
        return sum;
    }
}
