import java.util.Arrays;

public class PLF_2_2_A_Freistetter {
    public static void main(String[] args) {
        char[][] a1 = new char[3][5];
        for (char[] value : a1) {
            Arrays.fill(value, 'a');
        }
        a1[1][3] = '#';
        for (char[] chars : a1) {
            for (char aChar : chars) {
                System.out.printf("%2c", aChar);
            }
            System.out.println();
        }
        System.out.println();
        char[][] a2 = rotLeft(a1);
        for (char[] chars : a2) {
            for (char aChar : chars) {
                System.out.printf("%2c", aChar);
            }
            System.out.println();
        }
        System.out.println();
        int[][] a3 = new int[3][5];
        for (int[] value : a3) {
            Arrays.fill(value, 0);
        }
        a3[1][3] = 5;
        for (int[] ints : a3) {
            for (int anInt : ints) {
                System.out.printf("%2d", anInt);
            }
            System.out.println();
        }
        System.out.println();
        int[][] a4 = trans(a3);
        for (int[] ints : a4) {
            for (int anInt : ints) {
                System.out.printf("%2d", anInt);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean containsNot(char[][] a, char ch){
        for (char[] chars : a) {
            for (char aChar : chars) {
                if (aChar == ch) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void fill(int[][][] a, int value){
        for (int[][] ints : a) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, value);
            }
        }
    }

    public static double[] rowPositiveSum(double[][] a){
        double[] rDouble = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j]>0){
                    rDouble[i] += a[i][j];
                }
            }
        }
        return rDouble;
    }

    public static char[][] rotLeft(char[][] a){
        char[][] rotated = new char[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                rotated[a[0].length-j-1][i]=a[i][j];
            }
        }
        return rotated;
    }

    public  static boolean isNull(int[][] a, int row, int col){
        try{
            return a[row][col] == 0;
        }catch (ArrayIndexOutOfBoundsException e){
            return true;
        }
    }

    public static int countNeighboursAndMe(int[][] a, int row, int col) {
        int rInt = 0;
        for (int i = row-1; i <= row+1; i++) {
            for (int j = col-1; j <= col+1; j++) {
                if (!isNull(a,i,j)){
                    rInt++;
                }
            }
        }
        return rInt;
    }
    public static  boolean contains(int[][] a, int n){
        for (int[] ints : a) {
            for (int anInt : ints) {
                if (anInt == n) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void replace(int[][][] a, int oldValue, int newValue){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <a[i].length; j++) {
                for (int k = 0; k < a[i][j].length; k++) {
                    if (a[i][j][k] == oldValue){
                        a[i][j][k] = newValue;
                    }
                }
            }
        }
    }

    public static int[] countLetterPerRow(char[][] a){
        int[] rInt = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (Character.isLetter(a[i][j])){
                    rInt[i]++;
                }
            }
        }
        return rInt;
    }

    public static int[][] trans(int[][] a){
        int[][] transed = new int[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                transed[j][a.length-i-1]=a[i][j];
            }
        }
        return transed;
    }

    public static boolean isBomb(char[][] a, int row, int col){
        try{
            return a[row][col] == 'B';
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    public static int countBombs(char[][] a, int row, int col){
        int rInt = 0;
        for (int i = row-1; i <= row+1; i++) {
            for (int j = col-1; j <= col+1; j++) {
                if (isBomb(a,i,j)){
                    rInt++;
                }
            }
        }
        return rInt;
    }
}