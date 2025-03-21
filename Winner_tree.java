public class Winner_tree {
    
}


//hackerank 
//cheat
// import java.io.*;
// import java.util.*;

public class Solution {

    // Function to find the second minimum score
    public static int findSecondMinimum(int[] arr) {
        // Step 1: Sort the array
        Arrays.sort(arr);
        
        // Step 2: Check if the second minimum exists
        if (arr.length < 2 || arr[0] == arr[1]) {
            return -1; // No second minimum exists
        }
        
        // Step 3: Return the second minimum score
        return arr[1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the input
        String[] input = br.readLine().split(" ");
        
        int n = input.length; // The number of participants
        int[] arr = new int[n];
        
        // Convert the string array to integer array
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // Find the second minimum score
        int secondMin = findSecondMinimum(arr);

        // Output the result
        System.out.println(secondMin);
    }
}
