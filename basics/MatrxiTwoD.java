import java.util.Scanner;


public class MatrxiTwoD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row size: ");
        int m = sc.nextInt();
        System.out.println("enter no of columns: ");
        int n = sc.nextInt();
        System.out.println("enter m * n elements: ");
        int[][] mat = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println("print matrix: ");
        printMat(mat);

    }
    public static void printMat(int[][] mat) {
        int n = mat.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    } 
}
