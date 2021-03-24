import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class QueueUsingStacks
{
    public static void main(String args[])
    {
        //Taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        //Taking input the number of testcases
        int t = sc.nextInt();
        while(t>0)
        {
            //Creating a new object of class StackQueue
            StackQueue g = new StackQueue();

            //Taking input the total number of Queries
            int q = sc.nextInt();
            while(q>0)
            {
                int QueryTyoe = sc.nextInt();

                //If QueryTyoe is 1 then
                //we call the Push method
                //of class StackQueue
                //else we call the Pop method
                if(QueryTyoe == 1)
                {
                    int a = sc.nextInt();
                    g.Push(a);
                }else
                if(QueryTyoe == 2)
                    System.out.print(g.Pop()+" ");
                q--;

            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


class StackQueue
{
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();


    /* The method insert to push element
       into the queue */
    void Push(int x)
    {
        s1.push(x);
    }

    void Push2(int x) {
        if(!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(x);

        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }


    /* The method remove which return the
      element popped out of the queue*/
    int Pop()
    {
        if(s2.isEmpty()) {
            if(s1.isEmpty()) {
                return -1;
            }


            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            int temp = s2.pop();

            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return temp;
        }
        return -1;
    }

    int Pop2() {
        // Your code here
        if(s1.isEmpty()) {
            return -1;
        }
        int temp = s1.peek();
        s1.pop();
        return temp;
    }
}
