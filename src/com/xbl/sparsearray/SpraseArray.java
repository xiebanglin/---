package com.xbl.sparsearray;

/**
 * 稀疏数组
 */
public class SpraseArray {
    public static void main(String[] args) {
        int cherryArray[][] = new int[11][11];
        cherryArray[1][2]=1;
        cherryArray[2][3]=2;
        cherryArray[3][3]=2;

        System.out.println("原始二维数组：");
        for (int i = 0; i <cherryArray.length ; i++) {
            for (int j = 0; j <cherryArray[i].length ; j++) {
                System.out.printf("%d\t", cherryArray[i][j]);
            }
            System.out.println();
        }

        toSparseArray(cherryArray);
    }

    /**
     * 原始数组转稀疏数组
     * @param cherryArray
     */
    public static void toSparseArray(int [][] cherryArray){
        int num = 0;
        for (int i = 0; i < cherryArray.length; i++) {
            for (int j = 0; j <cherryArray[i].length ; j++) {
                if(cherryArray[i][j] != 0){
                    num ++;
                }
            }
        }

        int[][] sparseArray = new int[num + 1][3];
        sparseArray[0][0] = cherryArray.length;
        sparseArray[0][1] = cherryArray[0].length;
        sparseArray[0][2] = num;
        int rowNum = 1;
        for (int i = 0; i < cherryArray.length; i++) {
            for (int j = 0; j <cherryArray[i].length ; j++) {
                if(cherryArray[i][j] != 0){
                    sparseArray[rowNum][0] = i;
                    sparseArray[rowNum][1] = j;
                    sparseArray[rowNum][2] = cherryArray[i][j];
                    rowNum ++;
                }
            }
        }

        System.out.println("原始数组-->稀疏数组：");
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j <sparseArray[i].length ; j++) {
                System.out.printf("%d\t", sparseArray[i][j]);
            }
            System.out.println();
        }

        toNormalArray(sparseArray);
    }

    /**
     * 稀疏数组转原始数组
     */
    public static void toNormalArray(int [][] sparseArray){

        int[][] normalArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i <sparseArray.length ; i++) {
            normalArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("稀疏数组-->原始数组：");
        for (int i = 0; i < normalArray.length; i++) {
            for (int j = 0; j <normalArray[i].length ; j++) {
                System.out.printf("%d\t", normalArray[i][j]);
            }
            System.out.println();
        }
    }
}
