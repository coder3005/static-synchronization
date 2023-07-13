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

        Bank obj2=new Bank(5000);  // obj2 has one lock

        Thread t3=new Thread(obj2);
        Thread t4=new Thread(obj2);

        t3.setName("Rahul");
        t4.setName("Anita");


        t1.start();  t2.start();
        t3.start();  t4.start();
    }
}
