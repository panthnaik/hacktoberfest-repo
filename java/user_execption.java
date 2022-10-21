class myexception extends Exception
{
    myexception(String msg)
    {
        super(msg);
    }
}
class user_execption
{
    public static void main(String[] args) {
       int age=16;
        try
        {
            if(age<18)
            throw new myexception("ur small");
        }
        catch(myexception m)
        {
            System.out.println(m.getMessage());
        }
        
    }
}
