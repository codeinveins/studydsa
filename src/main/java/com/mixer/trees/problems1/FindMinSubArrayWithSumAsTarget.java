package com.mixer.trees.problems1;

import java.util.*;

public class FindMinSubArrayWithSumAsTarget {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the array: ");
        int a[] = Arrays.stream(s.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Enter the target value: ");
        int tar = s.nextInt();

        System.out.println(Arrays.toString(findMinSubArray(a, tar)));
    }

    private static int[] findMinSubArray(int arr[], int target) {
        List<Result> r = new ArrayList<>();

        for(int i=0,j=1; j<arr.length;) {
            int sum = 0, ti=i;
            while(ti<=j) {
                sum += arr[ti++];
            }
            //System.out.println(i + " -- " + j + " -- " + sum);
            if(sum > target) {
                i++;
            } else if(sum < target) {
                j++;
            } else {
                //System.out.println(i + " & " + j + " is possible combination.");
                r.add(new Result(j-i, i, j));
                i++;j++;
            }
        }

        Collections.sort(r);
        System.out.println("Array starting from index " + r.get(0).startindex + " to index " + r.get(0).endindex + " in original array is the answer.");
        return Arrays.copyOfRange(arr, r.get(0).startindex, r.get(0).endindex+1);
    }
}

class Result implements Comparable {
    int length;
    int startindex;
    int endindex;

    public Result(int length, int startindex, int endindex) {
        this.length = length;
        this.startindex = startindex;
        this.endindex = endindex;
    }

    public int getLength() {
        return length;
    }

    public int getStartindex() {
        return startindex;
    }

    public int getEndindex() {
        return endindex;
    }

    @Override
    public String toString() {
        return "Result{" +
                "length=" + length +
                ", startindex=" + startindex +
                ", endindex=" + endindex +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Result obj = ((Result)o);
        if(this.length > obj.length)
            return 1;
        else if(this.length < obj.length)
            return -1;
        else return 0;
    }
}
