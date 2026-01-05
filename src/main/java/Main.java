import java.util.*;
public class Main {	
	
	static Scanner reader=new Scanner(System.in);
	public static void main(String[] args) {
	    
		Queue<Character> q1 = new Queue<Character>();
		q1.insert('a');
		q1.insert('a');
		q1.insert('c');
		q1.insert('c');
		Queue<String> q2 = new Queue<String>();
		q2.insert("ab");
		q2.insert("a");
		q2.insert("a");
		q2.insert("gsh");
		Queue<Integer> q3 = new Queue<Integer>();
		q3.insert(3);
		q3.insert(5);
		q3.insert(8);
		q3.insert(9);
		Queue<Integer> q4 = new Queue<Integer>();
		q4.insert(2);
		q4.insert(4);
		q4.insert(7);
		q4.insert(2);
		q4.insert(2);
		q4.insert(4);
		q4.insert(7);
		q4.insert(2);
		//System.out.println(ex1(q1));
		//System.out.println(ex2(q2));
		//System.out.println(ex3(q3));
		//System.out.println(ex4(q3));
		//System.out.println(ex5(q3,q4));
		System.out.println(ex6(q4));
	}
	
	/////////////////////////////////////////////
	
	public static Queue<String> ex(Queue<String> q) {
	    Queue<String> h = new Queue<String>();
	    Queue<String> p = new Queue<String>();
	     while (!q.isEmpty())
	     {
	         p.insert(q.head());
	         h.insert(q.remove());
	     }
	     while (!p.isEmpty())
	     {
	         q.insert(p.remove());
	     }
	     return h;
	}
	
	public static Queue<Integer> exInt(Queue<Integer> q) {
	    Queue<Integer> h = new Queue<Integer>();
	    Queue<Integer> p = new Queue<Integer>();
	     while (!q.isEmpty())
	     {
	         p.insert(q.head());
	         h.insert(q.remove());
	     }
	     while (!p.isEmpty())
	     {
	         q.insert(p.remove());
	     }
	     return h;
	}
	
	///o(n)
	public static Queue<Integer> ex1(Queue<Character> q) {
	    Queue<Integer> m = new Queue<Integer>();
	    char last = q.remove();
	    int current = 1;
	    while (!q.isEmpty())
	    {
	        if (q.head()==last)
	        {
	            current++;
	        }
	        else
	        {
	            m.insert(current);
	            current = 1;
	            last = q.head();
	        }
	        q.remove();
	    }
	    m.insert(current);
	    return m;
    }
    
    public static boolean isIn(Queue<String> h, String x) 
    {
        Queue<String> q = ex(h);
        boolean exists = false;
        while (!q.isEmpty()) 
        {
            String item = q.remove();
            if (item.equals(x)) 
            {
                return true;
            }
        }
        return false;
    }
    
    //o(n^2)
    public static boolean ex2(Queue<String> q) 
    {
        String current;
        
	    while (!q.isEmpty())
	    {
	        current = q.remove();
	        if (isIn(q,current))
	        {
	            return true;
	        }
	    }
	    return false;
    }
    
    public static boolean isInInt(Queue<Integer> h, Integer x) 
    {
        Queue<Integer> q = exInt(h);
        while (!q.isEmpty()) 
        {
            if (q.remove().equals(x)) 
            {
                return true;
            }
        }
        return false;
    }
    
    //o(n^2)
    public static Queue<Integer> ex3(Queue<Integer> h) 
    {
	    Queue<Integer> q = exInt(h);
	    Queue<Integer> m = new Queue<Integer>();
        int current;
        
	    while (!q.isEmpty())
	    {
	        current = q.remove();
	        if (!isInInt(q,current))
	        {
	            m.insert(current);
	        }
	    }
	    return m;
    }
    
    //o(n^2)
    public static Queue<Integer> ex4(Queue<Integer> h) 
    {
	    Queue<Integer> q = exInt(h);
	    Queue<Integer> m = new Queue<Integer>();
	    Queue<Integer> finel = new Queue<Integer>();
        int min;
        
	    while (!q.isEmpty())
	    {
	        min = q.remove();
	        while (!q.isEmpty())
	        {
	            if (q.head()<min)
	            {
	                m.insert(min);
	                min=q.head();
	            }
	            else
	            {
	                m.insert(q.head());
	            }
	            q.remove();
	        }
	        finel.insert(min);
	        q = exInt(m);
	        
	        while (!m.isEmpty())
	        {
	            m.remove();
	        }
	    }
	    return finel;
    }
    
    //o(n+m)
    public static Queue<Integer> ex5(Queue<Integer> h,Queue<Integer> n) 
    {
	    Queue<Integer> q = exInt(h);
	    Queue<Integer> m = exInt(n);
	    Queue<Integer> finel = new Queue<Integer>();
	    while (!q.isEmpty() && !m.isEmpty())
	    {
	        if (q.head()<m.head())
	        {
	            finel.insert(q.remove());
	        }
	        else
	        {
	            finel.insert(m.remove());
	        }
	    }
	    
	    while (!m.isEmpty())
	    {
	         finel.insert(m.remove());
	    }
	    while (!q.isEmpty())
	    {
	         finel.insert(q.remove());
	    }
	    return finel;
    }
    
    //o(n)
    public static int ex6(Queue<Integer> h) 
    {
	    Queue<Integer> q = exInt(h);
	    int sum = 0;
	    int max = 0;
	    int curM = 0;
	    int curS = 0;
	    while (!q.isEmpty())
	    {
	        if (q.head()%2==0)
	        {
	            curM++;
	            curS+=q.head();
	        }
	        else
	        {
	            if (curM>max)
	            {
	                sum = curS;
	                max = curM;
	            }
	            curM=0;
	            curS=0;
	        }
	        q.remove();
	    }
	    return sum;
    }

	public static Queue<Integer> ex(Queue<Integer> q) {
	    Queue<Integer> h = new Queue<Integer>();
	    Queue<Integer> p = new Queue<Integer>();
	     while (!q.isEmpty())
	     {
	         p.insert(q.head());
	         h.insert(q.remove());
	     }
	     while (!p.isEmpty())
	     {
	         q.insert(p.remove());
	     }
	     return h;
	}
	
	public static int max(Queue<Integer> p) 
	{
	    Queue<Integer> q = ex(p);
	    int max = q.remove();
	    int current;
	    while (!q.isEmpty())
	    {
	        current = q.remove();
	        
	        if (current>max)
	            max = current;
	    }
	    return max;
    }
    
    public static int dig(int num) 
    {
	    int digit = 0;
	    while (num!=0)
	    {
	        digit++;
	        num = num/10;
	    }
	    return digit;
    }
    
    public static int loc(int num,int x) 
    {
        if (dig(num)<x)
            return 0;
            
        int digit = 0;
            
	    while (x!=-1)
	    {
	        x--;
	        digit = num%10;
	        num = num/10;
	    }
	    return digit;
    }
    
    public static Queue<Integer> sort(Queue<Integer> q) 
    {
        Queue<Integer>[]a = new Queue [10];
        for (int i = 0; i< 10; i++){
            a[i] = new Queue<Integer>();
        }
            
        int x = dig(max(q));
        int num;
        
        for (int i = 0; i< x;i++)
        {
            while (!q.isEmpty())
	        {
	            num = q.remove();
	            a[loc(num,i)].insert(num);
	        }
	        
	        for (int j = 0; j< 10;j++)
            {
                while (!a[j].isEmpty())
	            {
	                q.insert(a[j].remove());
	            }
            }
        }
            
        return q;    
        
    }
	
}
