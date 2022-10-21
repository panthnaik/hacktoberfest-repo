import java.util.Scanner;
class knap{
    void solve(int wt[],int pt[],int W,int N)
    {
        int i,j;
        int sol[][]=new int[N+1][W+1];
        for(i=0;i<=N;i++)
        {
            for(j=0;j<=W;j++)
            {
                if(i==0 || j==0 )
                sol[i][j]=0;
                else if(wt[i]>j)
                sol[i][j]=sol[i-1][j];
                else
                sol[i][j]=Math.max(sol[i-1][j],(sol[i-1][j -wt[i]]+pt[i]));
            }
        }
        System.out.println("optimal solution"+sol[N][W]);
        int selected[]=new int[N+1];
        for(i=0;i<=N+1;i++)
        selected[i]=0;
        i=N;
        j=W;
        while(i>0 && j>0)
        {
            if(sol[i][j]-sol[i-1][j]!=0)
            {
                selected[i]=1;
                j=j-wt[i];
            }
            i--;
        }
        System.out.println("selected array: ");
        for(i=0;i<=N;i++)
        {
            if(selected[i]==1)
            System.out.print(i+"\t");

        }
    }
}
public class sixa {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of Elments: ");
        int n=sc.nextInt();
        int wt[]=new int[n+1];
        int pt[]=new int[n+1];
        System.out.println("Entre the weight :");
        for(int i=1;i<=n;i++)
        wt[i]=sc.nextInt();
        System.out.println("Entre the profit :");
        for(int i=1;i<=n;i++)
        pt[i]=sc.nextInt();
        System.out.println("Enter the capacity:");
        int W=sc.nextInt();
        knap k=new knap();
        k.solve(wt,pt,W,n);
    }
}
