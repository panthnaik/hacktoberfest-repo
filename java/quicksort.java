import java.util.Random;
import java.util.Scanner;
class quisor
{
    int partition(int []a,int low,int high)
    {
        int p,i,j;
        p=a[low];
        i=low+1;
        j=high;
        while(low<high)
        {
            while(p>=a[i] && i<high)
            i++;
            while(p<a[j])
            j--;
            if(i<j)
            {
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
            else
            {
                int temp=a[low];
                a[low]=a[j];
                a[j]=temp;
                return j;
            }
        }
        return j;
    }
    void sort(int []a,int low,int high)
    {
        if(low<high)
        {
            int pos=partition(a,low,high);
            sort(a, low, pos-1);
            sort(a, pos+1, high);
        }
    }
}
public class quicksort {
    public static void main(String[] args) {
        int a[]=new int[1000];
        int n=0;
        System.out.println("1.Enter the number from keboard\n2.Genarate Random numbers");
        Scanner sc=new Scanner(System.in);
        int ch=sc.nextInt();
        switch(ch)
        {
            case 1:System.out.println("Enter the number of elements: ");
            n=sc.nextInt();
            System.out.print("ENter the number: ");
            for(int i=0;i<n;i++)
            {
                
                a[i]=sc.nextInt();
            }
            break;
            case 2:System.out.println("Enter the number of elements: ");
            n=sc.nextInt();
            Random ra=new Random(1000);
            for(int i=0;i<n;i++)
            {
                a[i]=ra.nextInt(100);
            }
        }
        System.out.println("Array elements to be sorted are: ");
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+"\t");
        }
        long strat=System.nanoTime();
        quisor qs=new quisor();
        qs.sort(a, 0,n-1);
        long end=System.nanoTime();
        System.out.println("Array elements after sorted are: ");
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+"\t");
        }
        System.out.println("Time taken by the qoick sort is :"+(end-strat));
    }
    
}
