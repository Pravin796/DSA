package com.pravin.Recursion;

public class Praactice {
    public static void main(String[] args) {
        // int arr[] = {1,2,3,4,5};
        String str = "madam";

        // int secmax = Integer.MIN_VALUE;
        // for(int i=0;i<arr.length;i++){
        //     int max = arr[0];
        //     if(arr[i] > max){
        //         secmax = max;
        //         max = arr[i];
        //     }
        // }
        //     System.out.println(secmax);
        // System.out.println(fact(5));
        // reversearr(arr, 0);
        // System.out.println(Arrays.toString(arr));

        System.out.println(checkplindrome(str, 0));

        int [] arr = {4,5,6,7,0,1,2,3};
        System.out.println(binarySearch(arr, 1, 0, 7));
    }

    static int fact(int n){
        if(n == 0) return 1;

        return n * fact(n-1);
    }

    static void reversearr(int [] arr, int l , int r){
        if(l >= r) return;

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

        reversearr(arr, l+1, r-1);
    }

    static void reversearr(int [] arr, int i){
        if(i >= arr.length/2) return;

        int temp = arr[i];
        arr[i] = arr[arr.length-i-1];
        arr[arr.length-i-1] = temp;

        reversearr(arr, i+1);
    }

    static boolean checkplindrome(String str, int i, int j){
        if(i >= j) return true;

        if(str.charAt(i) != str.charAt(j)) return false;

        return checkplindrome(str, i+1, j-1);
    }

    static boolean checkplindrome(String str, int i){
        if(i >= str.length()/2) return true;

        if(str.charAt(i) != str.charAt(str.length()-i-1)) return false;

        return checkplindrome(str, i+1);
    }


    static boolean checkArraySorted(int [] arr, int index){
        if(index == arr.length-1) return true;

        return arr[index] < arr[index+1] && checkArraySorted(arr, index+1);
    }

    static boolean findtarget(int []arr, int target, int index){
        if(index == arr.length) return false;

        return arr[index] == target || findtarget(arr, target, index+1);
    }

    static int findtargetIndex(int [] arr, int target, int index){
        if(index == arr.length) return -1;

        if(arr[index] == target){
            return index;
        }else{
            return findtargetIndex(arr, target, index+1);
        }
    }

    static int binarySearch(int [] arr , int target, int start, int end){
        if(start > end) return 0;

        int mid = start + (end - start)/2;

        if(arr[mid] == target) return mid;

        if(arr[start] <= arr[mid]){
            if(target >= arr[start] && target < arr[mid]){
                return binarySearch(arr, target, start, mid-1);
            }

            return binarySearch(arr, target, mid+1, end);
        }

        if(target > arr[mid] && target < arr[end]){
            return binarySearch(arr, target, mid+1, end);
        }

        return binarySearch(arr, target, start, mid-1);
    }

}
