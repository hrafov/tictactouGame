import java.util.*;
public class Main {
    static int[][] field = new int[3][3];
    static int[] intArray;
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        intArray = mapIntArrayFromString("_________");
        fieldOutput();
        mapFieldFromIntArray(intArray);
        boolean symbolX = true;
        String coordinateInput;
        do {
            do {
                System.out.println("Enter the coordinates: "); // like this: 1 3
                coordinateInput = new String(scanner.nextLine());
            } while (!userInputCoordinateCheck(mapStringArrayFromField(), coordinateInput));
                System.out.println(coordinateInput);
            newFieldWithOneMoreXor0(coordinateInput, symbolX);
            fieldOutput();
            if (symbolX) symbolX = false;
            else symbolX = true;
        } while(!stopGameFeedback(mapStringArrayFromField()));
    }

    static void mapIntArrayFromField() {
        intArray[0] = field[0][0];
        intArray[1] = field[0][1];
        intArray[2] = field[0][2];
        intArray[3] = field[1][0];
        intArray[4] = field[1][1];
        intArray[5] = field[1][2];
        intArray[6] = field[2][0];
        intArray[7] = field[2][1];
        intArray[8] = field[2][2];
    }

    static String[] mapStringArrayFromField() {
        String[] s = new String[9];
        s[0] = String.valueOf(field[0][0]);
        s[1] = String.valueOf(field[0][1]);
        s[2] = String.valueOf(field[0][2]);
        s[3] = String.valueOf(field[1][0]);
        s[4] = String.valueOf(field[1][1]);
        s[5] = String.valueOf(field[1][2]);
        s[6] = String.valueOf(field[2][0]);
        s[7] = String.valueOf(field[2][1]);
        s[8] = String.valueOf(field[2][2]);
        return s;
    }

    static int[] mapIntArrayFromString(String str) {
        String[] s = new String[9];
        int[] ints = new int[9];
        for (int i = 0; i < 9; i++) {
            s[i] = str.substring(i, i + 1);
        }
        if (s[0].equals("_")) ints[0] = 0;
        if (s[0].equals("X")) ints[0] = 1;
        if (s[0].equals("0")) ints[0] = 2;

        if (s[1].equals("_")) ints[1] = 0;
        if (s[1].equals("X")) ints[1] = 1;
        if (s[1].equals("0")) ints[1] = 2;

        if (s[2].equals("_")) ints[2] = 0;
        if (s[2].equals("X")) ints[2] = 1;
        if (s[2].equals("0")) ints[2] = 2;

        if (s[3].equals("_")) ints[3] = 0;
        if (s[3].equals("X")) ints[3] = 1;
        if (s[3].equals("0")) ints[3] = 2;

        if (s[4].equals("_")) ints[4] = 0;
        if (s[4].equals("X")) ints[4] = 1;
        if (s[4].equals("0")) ints[4] = 2;

        if (s[5].equals("_")) ints[5] = 0;
        if (s[5].equals("X")) ints[5] = 1;
        if (s[5].equals("0")) ints[5] = 2;

        if (s[6].equals("_")) ints[6] = 0;
        if (s[6].equals("X")) ints[6] = 1;
        if (s[6].equals("0")) ints[6] = 2;

        if (s[7].equals("_")) ints[7] = 0;
        if (s[7].equals("X")) ints[7] = 1;
        if (s[7].equals("0")) ints[7] = 2;

        if (s[8].equals("_")) ints[8] = 0;
        if (s[8].equals("X")) ints[8] = 1;
        if (s[8].equals("0")) ints[8] = 2;

        return ints;
    }

    static void mapFieldFromIntArray(int[] s) {
        field[0][0] = s[0];
        field[0][1] = s[1];
        field[0][2] = s[2];
        field[1][0] = s[3];
        field[1][1] = s[4];
        field[1][2] = s[5];
        field[2][0] = s[6];
        field[2][1] = s[7];
        field[2][2] = s[8];
    }

    static void newFieldWithOneMoreXor0(String coordinateInput, boolean symbolX) {
        if (coordinateInput.equals("1 3")) {
            if (symbolX) field[0][0] = 1;
            else field[0][0] = 2;
        }
        if (coordinateInput.equals("2 3")) {
            if (symbolX) field[0][1] = 1;
            else field[0][1] = 2;
        }
        if (coordinateInput.equals("3 3")) {
            if (symbolX) field[0][2] = 1;
            else field[0][2] = 2;
        }
        if (coordinateInput.equals("1 2")) {
            if (symbolX) field[1][0] = 1;
            else field[1][0] = 2;
        }
        if (coordinateInput.equals("2 2")) {
            if (symbolX) field[1][1] = 1;
            else field[1][1] = 2;
        }
        if (coordinateInput.equals("3 2")) {
            if (symbolX) field[1][2] = 1;
            else field[1][2] = 2;
        }
        if (coordinateInput.equals("1 1")) {
            if (symbolX) field[2][0] = 1;
            else field[2][0] = 2;
        }
        if (coordinateInput.equals("2 1")) {
            if (symbolX) field[2][1] = 1;
            else field[2][1] = 2;
        }
        if (coordinateInput.equals("3 1")) {
            if (symbolX) field[2][2] = 1;
            else field[2][2] = 2;
        }
    }

    static boolean userInputCoordinateCheck(String[] s, String coordinateInput) {
        if (!coordinateInput.substring(0, 1).matches("-?\\d+(\\.\\d+)?") ||
                !coordinateInput.substring(2, 3).matches("-?\\d+(\\.\\d+)?")) {
            System.out.println("You should enter numbers!");
            return false;
        }
        if (!(coordinateInput.substring(0, 1).contains("1") ||
                coordinateInput.substring(0, 1).contains("2") ||
                coordinateInput.substring(0, 1).contains("3"))
                ||
                !(coordinateInput.substring(2, 3).contains("1") ||
                        coordinateInput.substring(2, 3).contains("2") ||
                        coordinateInput.substring(2, 3).contains("3"))
        ) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        if (coordinateInput.equals("1 3") && !s[0].equals("0") ||
                coordinateInput.equals("1 2") && !s[3].equals("0") ||
                coordinateInput.equals("1 1") && !s[6].equals("0") ||
                coordinateInput.equals("2 3") && !s[1].equals("0") ||
                coordinateInput.equals("2 2") && !s[4].equals("0") ||
                coordinateInput.equals("2 1") && !s[7].equals("0") ||
                coordinateInput.equals("3 3") && !s[2].equals("0") ||
                coordinateInput.equals("3 2") && !s[5].equals("0") ||
                coordinateInput.equals("3 1") && !s[8].equals("0")) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        return true;
    }

    static boolean stopGameFeedback(String[] s) {
        if (!isOInRaw(s) && !isXInRow(s) && isSellEmpty(s)) {
            //System.out.println("Game not finished");
            return false;
        }
        if (!isOInRaw(s) && !isXInRow(s) && !isSellEmpty(s)) {
            System.out.println("Draw");
        }
        if ((differenceInXAndO(s) > 1) || (isOInRaw(s) && isXInRow(s))) {
            System.out.println("Impossible");
        } else {
            if (isXInRow(s)) {
                System.out.println("X wins");
            }
            if (isOInRaw(s)) {
                System.out.println("O wins");
            }
        }
        return true;
    }

    static int differenceInXAndO(String[] s) {
        int sumOs = 0;
        int sumXs = 0;
        for (int i = 0; i < 9; i++) {
            if (s[i].equals("O")) sumOs++;
            if (s[i].equals("X")) sumXs++;
        }
        return Math.abs(sumOs - sumXs);
    }

    static void fieldOutput() {
        mapIntArrayFromField();
        String[] s = new String[9];
        if (intArray[0] == 0) s[0] = "_";
        if (intArray[0] == 1) s[0] = "X";
        if (intArray[0] == 2) s[0] = "0";

        if (intArray[1] == 0) s[1] = "_";
        if (intArray[1] == 1) s[1] = "X";
        if (intArray[1] == 2) s[1] = "0";

        if (intArray[2] == 0) s[2] = "_";
        if (intArray[2] == 1) s[2] = "X";
        if (intArray[2] == 2) s[2] = "0";

        if (intArray[3] == 0) s[3] = "_";
        if (intArray[3] == 1) s[3] = "X";
        if (intArray[3] == 2) s[3] = "0";

        if (intArray[4] == 0) s[4] = "_";
        if (intArray[4] == 1) s[4] = "X";
        if (intArray[4] == 2) s[4] = "0";

        if (intArray[5] == 0) s[5] = "_";
        if (intArray[5] == 1) s[5] = "X";
        if (intArray[5] == 2) s[5] = "0";

        if (intArray[6] == 0) s[6] = "_";
        if (intArray[6] == 1) s[6] = "X";
        if (intArray[6] == 2) s[6] = "0";

        if (intArray[7] == 0) s[7] = "_";
        if (intArray[7] == 1) s[7] = "X";
        if (intArray[7] == 2) s[7] = "0";

        if (intArray[8] == 0) s[8] = "_";
        if (intArray[8] == 1) s[8] = "X";
        if (intArray[8] == 2) s[8] = "0";

        System.out.println("---------");
        System.out.println("| " + s[0] + " " + s[1] + " " + s[2] + " |");
        System.out.println("| " + s[3] + " " + s[4] + " " + s[5] + " |");
        System.out.println("| " + s[6] + " " + s[7] + " " + s[8] + " |");
        System.out.println("---------");
    }

    static boolean isXInRow(String[] s) {
        if (s[0].equals("1") && s[1].equals("1") && s[2].equals("1")) return true;
        if (s[3].equals("1") && s[4].equals("1") && s[5].equals("1")) return true;
        if (s[6].equals("1") && s[7].equals("1") && s[8].equals("1")) return true;
        if (s[0].equals("1") && s[3].equals("1") && s[6].equals("1")) return true;
        if (s[1].equals("1") && s[4].equals("1") && s[7].equals("1")) return true;
        if (s[2].equals("1") && s[5].equals("1") && s[8].equals("1")) return true;
        if (s[0].equals("1") && s[4].equals("1") && s[8].equals("1")) return true;
        if (s[2].equals("1") && s[4].equals("1") && s[6].equals("1")) return true;
        return false;
    }

    static boolean isOInRaw(String[] s) {
        if (s[0].equals("2") && s[1].equals("2") && s[2].equals("2")) return true;
        if (s[3].equals("2") && s[4].equals("2") && s[5].equals("2")) return true;
        if (s[6].equals("2") && s[7].equals("2") && s[8].equals("2")) return true;
        if (s[0].equals("2") && s[3].equals("2") && s[6].equals("2")) return true;
        if (s[1].equals("2") && s[4].equals("2") && s[7].equals("2")) return true;
        if (s[2].equals("2") && s[5].equals("2") && s[8].equals("2")) return true;
        if (s[0].equals("2") && s[4].equals("2") && s[8].equals("2")) return true;
        if (s[2].equals("2") && s[4].equals("2") && s[6].equals("2")) return true;
        return false;
    }

    static boolean isSellEmpty(String[] s) {
        for (String si: s) {
            if (si.equals("0")) {
                return true;
            }
        }
        return false;
    }
}
