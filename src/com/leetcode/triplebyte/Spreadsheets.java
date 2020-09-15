package com.leetcode.triplebyte;

import com.leetcode.Helper.PrintUtils;

public class Spreadsheets {

    private int row;
    private int col;
    private String[][] matrix;
    private int maxLength;

    public Spreadsheets(int row, int col) {
        this.row = row;
        this.col = col;
        this.maxLength = 0;
        this.matrix = new String[row][col];
        for(int i = 0; i < this.row; i++) {
            for(int j = 0; j < this.col; j++) {
                matrix[i][j] = "";
            }
        }

    }



    public void updateContent(String content, int row, int col) {
        if (validMatrix(row, col) == false) {
            return;
        }
        this.matrix[row][col] = content;
        if (content.length() >= this.maxLength) {
            this.maxLength = content.length();
        }
    }

    public void printSpreadsheets() {
        for(int i = 0; i < this.row; i++) {
            for(int j = 0; j < this.col; j++) {
                System.out.print(this.matrix[i][j]);
                if (j + 1 < this.col) {
                    System.out.print("|");
                } else {
                    System.out.println();
                }
            }
        }
    }

    private boolean validMatrix(int row, int col) {
        if (this.matrix == null || this.matrix.length == 0 || this.matrix[0].length == 0) {
            return false;
        }

        int _row = this.row;
        int _col = this.col;
        if (row < 0 || row >= _row || col < 0 || col >= _col) {
            return false;
        }
        return true;
    }

    public void prettyPrint() {
        int[] maxLength = new int[this.row];
        for(int i = 0; i < this.col; i++) {
            int maxColLength = 0;
            for(int j = 0; j < this.row; j++) {
                int length = matrix[j][i].length();
                if (length >= maxColLength) {
                    maxColLength = length;
                    maxLength[j] = maxColLength;
                }
            }
        }

        for(int i = 0; i < this.row; i++) {
            for(int j = 0; j < this.col; j++) {
                System.out.print(this.matrix[i][j]);
                int limit = maxLength[i];
                int diff = limit - this.matrix[i][j].length();
                for(int k = 0; k < diff; k++) {
                    System.out.print(" ");
                }
                if (j + 1 < this.col) {
                    System.out.print("|");
                } else {
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        Spreadsheets obj = new Spreadsheets(4, 3);
        obj.updateContent("bob", 0, 0);
        obj.updateContent("10", 0, 1);
        obj.updateContent("foo", 0, 2);
        obj.updateContent("alice", 1, 0);
        obj.updateContent("5", 1, 1);
        obj.printSpreadsheets();
        obj.prettyPrint();
    }
}
