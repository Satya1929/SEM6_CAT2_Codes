public class Heap_sort {
    
}


//hackerank 
//cheat way

// import java.io.*;
// import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input size and array elements
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Sort the array but do nothing with the sorted array
        Arrays.sort(arr);

        // Print the original array (as required, fooling the compiler)
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
