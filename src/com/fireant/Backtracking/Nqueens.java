package com.fireant.Backtracking;

/**
 * Created by pskumar on 1/4/17.
 */
public class Nqueens {

    int [][]m = new int[5][5];
    int n = 4;

    public static void main(String []args) {
        Nqueens nq = new Nqueens();
        nq.constructMatrix();
        nq.printMatrix();
        if (nq.constructNqueens(0)) {
            nq.printMatrix();
        }
    }

    public void printMatrix() {
        System.out.println();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(m[i][j] + "    ");
            }
            System.out.println();
        }
    }

    public void constructMatrix() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                m[i][j] = 0;
            }
        }
    }

    public boolean constructNqueens(int row) {
        if (row >= n)
            return true;
        for (int i = 0; i < n; i++) {
                if(isQueenSafe(row, i)) {
                    if(row == n) {
                        printMatrix();
                    } else {
                        m[row][i] = 1;
                        if(constructNqueens(row + 1)) {
                            return true;
                        }
                        m[row][i] = 0;
                    }
                }
        }
        return false;
    }
    public boolean isQueenSafe(int row, int col) {
         /* Check this row on left side */
        for (int i = 0; i < row; i++)
            if (m[i][col] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (int i=row, j=col; i>=0 && j>=0; i--, j--)
            if (m[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (int i=row, j=col; j>=0 && i<n; i++, j--)
            if (m[i][j] == 1)
                return false;
        return true;
    }

 }
