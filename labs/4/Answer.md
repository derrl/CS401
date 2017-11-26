## Question1:

- The Big-O of MethodA is: &ensp;&ensp; $\qquad\qquad n^3$

- The Big-O of MethodB is: &nbsp;&emsp;$\qquad\qquad n^2$

- The Big-O of MethodC is: $\quad 100n\log_2 n \sim n \log n$

## Question2:

#### There are a part of code in my BubbleSort.java file:

```
   void sort(ArrayList<Employee> qqq){

        int n,i;
        Employee c = new Employee(null, null);

        for(n = 1; n <= qqq.size() - 1; n++) {
            for(i = 0; i <= qqq.size() - n - 1; i++) {
                long a = Long.parseLong(qqq.get(i).id, 10);
                long b = Long.parseLong(qqq.get(i+1).id, 10);
                if(a > b) {
                    c = qqq.get(i);
                    qqq.set(i, qqq.get(i+1));
                    qqq.set(i+1, c);
                }
            }
        }
    }
```

#### Big-O of my Bubblesort is: $\quad  n^2$
