package com.greatlearning.assignment3.Ques2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Driver {

    public Integer totalFloors;
    public Integer[] totalFloorSize;

   
    public void getInputs() {
        System.out.println("enter the total no of floors in the building");
        Scanner sc = new Scanner(System.in);
        totalFloors = sc.nextInt();
        totalFloorSize = new Integer[totalFloors];

        for (int i = 1; i <= totalFloors; i++) {
            System.out.println("enter the floor size given on day : " + i);
            totalFloorSize[i - 1] = sc.nextInt();
        }
    }

    public void calculateAndPrintOrderOfConstruction(Integer[] totalFloorSize) {
        System.out.println("The order of construction is as follows");

        int j = 0;
        Integer[] totalFloorSizeSorted = totalFloorSize.clone();
        Arrays.sort(totalFloorSizeSorted, Collections.reverseOrder());
        
        Stack < Integer > myStack = new Stack < Integer > ();

        for (int i = 0; i < totalFloorSize.length; i++) {
            if (totalFloorSize[i] == totalFloorSizeSorted[j]) {
                if (i == totalFloorSize.length - 1) j = i;
                else j = i + 1;

                // Print the current floor as well as entire Stack till it's empty and entry is > than next element in sorted list.
                System.out.println("Day: " + (i + 1));
                if (myStack != null) {
                    System.out.print(totalFloorSize[i] + " ");
                    while (!myStack.isEmpty()) {
                        int val = myStack.pop();
                        if (val >= totalFloorSizeSorted[j]) {
                            System.out.print(val + " ");
                        } else {
                            myStack.push(val);
                            j -= myStack.size();
                            break;
                        }
                    }
                    System.out.println("");
                } else {
                    System.out.println(totalFloorSize[i]);
                }
            } else
            {
                System.out.println("Day: " + (i + 1));
                myStack.push(totalFloorSize[i]);
            }
        }
    }
}