import java.util.Scanner;

class bankAccount 
{
    private String name,accNo;
    protected double balance;
    public bankAccount()
    {
        name="";
        accNo="";
        balance=0;

    }
    public bankAccount(String n,String an,double b)
    {
        name = n;
        accNo = an;
        balance = b;
    }
    public void read()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account holder name: ");
        name = sc.nextLine();
        System.out.println("Enter your 11 digit account number: ");
        accNo = sc.next();
        System.out.println("Enter balance: ");
        balance = sc.nextDouble();
        //sc.close();
    }
    public void disp()
    {
        System.out.println("Hi.."+name+" welcome to XYZ bank");
        System.out.println("Your Ac/No. is XXXXXXX"+accNo.substring((accNo.length()-4)));
    }
}

class ATM extends bankAccount
{
    public ATM()
    {
        super();
    }
    public ATM(String n,String an,double b)
    {
        super(n,an,b);
    }
    public void withdraw(double amount)
    {
        System.out.println("Rs. "+amount+" debited");
        balance-=amount;
    }
    public void deposit(double amount)
    {
        System.out.println("Rs. "+amount+" credited");
        balance+=amount;
    }
    public double checkBalance()
    {
        return balance;
    }
}
public class ATM_interface {

    public static void main(String[] args) {
        ATM a1 = new ATM();
        a1.read();
        Scanner sc1 = new Scanner(System.in);
        int ch;
        double amount;
        a1.disp();
        do{
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check balance");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            ch=sc1.nextInt();
            switch (ch) {
                case 1:
                    while(true)
                    {
                        System.out.println("Enter amount: ");
                        amount=sc1.nextDouble();
                        if(amount<100)
                            System.out.println("Transaction failed!! Deposit amount is minimum 100");
                        else
                        {
                            a1.deposit(amount);
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) 
                    {
                        System.out.println("Enter amount: ");
                        amount=sc1.nextDouble();
                        if(a1.checkBalance()<amount)
                            System.out.println("Transaction failed!! Insufficient balance.");
                        else
                        {
                            a1.withdraw(amount);
                            break;
                        }
                    }
                    break;
                case 3:
                    //a1.checkBalance();
                    System.out.println("Your account balance is: "+a1.checkBalance());
                    break;
                case 4:
                    System.out.println("Bye...");
                    break;
                default:
                    System.out.println("wrong choice");
                    break;
            }
        }while(ch!=4);
        sc1.close();       
    }
}