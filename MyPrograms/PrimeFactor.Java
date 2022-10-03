/* Cocept: 
    Q. What is prime factor of a number?
    Ans : prime factors are those factors of a number which are prime.
    e.g : 1 - prime factors - 1 has only one factor which 1, and it is considered as prime.
          2 - prime factors - 1,2 - Both are prime.
          3 - prime factors - 1,3 - Both are prime.
          4 - prime factors - 2
          16 - prime factors - 2
          24 -  prime factors - 2,3
    */


    /*Find the sum of all the numbers between the range l and r. Here each number is represented by the sum of its prime factors.
    Note : For example, 6 is represented by 5 because 6 has two prime factors 2 and 3 and 2 + 3 = 5.

    Example 1:

    Input: l = 1, r = 2
    Output: 3
    Explanation: 1->1, 2->2 and 1+2=3.

    Example 2:

    Input: l = 1, r = 6
    Output: 18
    Explanation: 1->1, 2->2, 3->3, 4->2
            5->5, 6->2+3=5, 1+2+3+2+5+5 = 18.

    Your Task:
    You dont need to read input or print anything. Complete the function sumOfAll() which takes
    l and r as input parameter and returns sum all the numbers ( as represented ) in the given
    range both L and R included.

    Expected Time Complexity: O(nloglogn)
    Expected Auxiliary Space: O(n)

    Constraints:
            1 <= l <= r <=104
    */

    /*
    Observations :
    We need to consider only prime factors of a given number.

    */



public class Demo {

    public static void main(String[] args) {

        System.out.println(sumOfAll(4,13));
    }
    

    public static int sumOfAll(int l, int r)
    {
        //For final sum
        int sum = 0;
        //Loop from given l to r range
        for(int i = l ; i <= r ; i++){
            int n = i;
            if(n == 1) sum++; // edge case if 1 in part of input
            //Loop starts from 2 to number, as number can be a factor of itself
            for(int j = 2 ; j <= n ; j++){
                // Check if number is dividable by j. If yes then consider j for sum once and divide
                // the number unite is not divisible by j anymore. This is required to eliminate
                // the future j which are multiple of current j.
                // For example : For 8 we will consider only 2(j) not 4(future j less than 8)
                //               For 54 we will consider 3 once and skip 9 and 27 as they are multiple of 3
                if( n % j == 0){
                    sum += j;
                    while(n%j == 0){
                        n = n/j;
                    }
                }
            }
        }
        return sum; // return

    }