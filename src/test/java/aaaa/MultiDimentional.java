package aaaa;

import java.io.*;
import java.util.*;

public class MultiDimentional {

    /*
Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0. The image you get is known to have a single rectangle of 0s on a background of 1s.

Write a function that takes in the image and returns one of the following representations of the rectangle of 0's: top-left coordinate and bottom-right coordinate OR top-left coordinate, width, and height.

image1 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 0, 0, 0, 1],
  [1, 1, 1, 0, 0, 0, 1],
  [1, 1, 1, 1, 1, 1, 1],
]

Sample output variations (only one is necessary):

findRectangle(image1) =>
  row: 2, column: 3, width: 3, height: 2
  2,3 3,5 -- row,column of the top-left and bottom-right corners

Other test cases:

image2 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 0],
]

findRectangle(image2) =>
  row: 4, column: 6, width: 1, height: 1
  4,6 4,6

image3 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 0, 0],
  [1, 1, 1, 1, 1, 0, 0],
]

findRectangle(image3) =>
  row: 3, column: 5, width: 2, height: 2
  3,5 4,6

image4 = [
  [0, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
]

findRectangle(image4) =>
  row: 0, column: 0, width: 1, height: 1
  0,0 0,0

image5 = [
  [0],
]

findRectangle(image5) =>
  row: 0, column: 0, width: 1, height: 1
  0,0 0,0

n: number of rows in the input image
m: number of columns in the input image


*/


    public static void main(String[] argv) {

        int[][] image1 = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };

        int[][] image2 = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0}
        };

        int[][] image3 = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 0, 0}
        };

        int[][] image4 = {
                {0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };

        int[][] image5 = {
                {0}
        };

        checkArray(image1);


    }

    public static void checkArray(int[][] arr) {
        String rowNum = null;
        String colNum = null;
        String heightNum = null;
        String widthNum = null;
        boolean rowCol = false;
        boolean widHei = false;
        int width = 0;
        int height = 0;
        for (int row = 0; row < arr.length; row++) {
            widHei = false;
            for (int col = 0; col < arr[row].length; col++) {
                if (rowCol && arr[row][col] == 0 && widHei) {
                        width++;
                    }

                else if (rowCol == false && arr[row][col] == 0) {
                    rowNum = "" + row;
                    colNum = "" + col;
                    rowCol = true;
                    widHei = true;
                    width++;
                    height++;
                    }
                else if(widHei==false && arr[row][col] == 0 ){
                    height++;
                    break;
                }
            }
            heightNum = "" + height;
            widthNum = "" + width;
        }
        System.out.println("row number is " + rowNum + " column number is " + colNum + " width is " + widthNum + " height is " + heightNum);

    }


}


