package com.greatlearning.assignment3.Ques2;

public class Main {

    public static int totalFloors;
    public static int[] totalFloorSize;

    public static void main(String[] args) {
        Driver myDriverObj = new Driver();
        myDriverObj.getInputs();
        myDriverObj.calculateAndPrintOrderOfConstruction(myDriverObj.totalFloorSize);
    }
}