import java.util.Scanner;
public class kanpsack {
    public static void main(String[] args) {
        int j=0;
        float max,sum=0;
        System.out.println("Enter the number of weight: ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int  a[][]=new int[2][20];
        System.out.println("Entert the wight: ");
        for(int i=0;i<n;i++)
        a[0][i]=sc.nextInt();
        System.out.println("Entert the profit: ");
        for(int i=0;i<n;i++)
        a[1][i]=sc.nextInt();
        System.out.println("Entert the bag capacity: ");
        int max_q=sc.nextInt();
        int m=max_q;
        while(m>=0)
        {
            max=0;
            for(int i=0;i<n;i++){
                if(((float)a[1][i])/((float)a[0][i])>max){
                max=((float)a[1][i])/((float)a[0][i]);
                    j=i;
            }
            }
            if(a[0][j]>m)
            {
                System.out.println("Quatity of "+(j+1+"added is "+m));
                sum+=m*max;
                m=-1;
            }
            else{
                System.out.println("Quatity of "+(j+1+"added is "+ a[0][j]));
                m-=a[0][j];
                sum+=(float)a[1][j];
                a[1][j]=0;
                
            }
            System.out.println("profit"+sum);
        }
        
    }
    
}
