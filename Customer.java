/* static synchronization */
class Bank extends Thread
{
    int bal=5000;
    int withdraw;

    Bank(int withdraw)
    {
        this.withdraw=withdraw; // withdraw=5000
    }
    public synchronized void run()  // t1 or t2
    {
        String name=Thread.currentThread().getName();
        if(withdraw<=bal)  // 5000<=5000
        {
            System.out.println(name+" withdrawn money");
            bal=bal-withdraw;  // bal=5000-5000=0
        }
        else
        {
            System.out.println("Insufficient Balance");
        }
    }
}
class Customer 
{
    public static void main(String[] args) {
        
        Bank obj=new Bank(5000);  // obj has one lock

        Thread t1=new Thread(obj);
        Thread t2=new Thread(obj);

        t1.setName("Raju");
        t2.setName("Sunita");
 
        t1.start();  t2.start();       
    }
}
