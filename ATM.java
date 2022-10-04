

//ATM INTERFACE
import java.util.Scanner;

class ATM {

    public int amount, id,Balance = 5000,trans=0;
    String trans_History;

    void transaction() {
        if(trans==0)
        {
            System.out.println("NO TRANSACTION");
        }
        else{
            System.out.println("\nTransaction"+trans_History);
        }
    }

    void withdraw(int amount, int Balance) {
        System.out.println("Enter amount in multiple of 100=");
        Scanner s = new Scanner(System.in);
        amount = s.nextInt();
        if(amount<=Balance)
        {
            Balance= Balance - amount;
            System.out.println("WITHDRAWAL SECCESSFULL");
            System.out.println("collect your money");
            System.out.println("Total amount=");
            System.out.print(Balance);
            trans+=1;

            String str=("Rs "+amount+" withdrawal");
            trans_History=trans_History.concat(str);
        }
        else{
            System.out.println("Insufficient Balance.");
        }


        s.close();
    }

    void deposite(int amount, int Balance) {
        System.out.println("Enter amount=");
        Scanner s = new Scanner(System.in);
        amount = s.nextInt();
        Balance = Balance + amount;
        System.out.println("DEPOSITE SECCESSFULL");
        System.out.println("Total amount=");
        System.out.print(Balance);
        trans++;
        String str=("Rs "+amount+" Deposite.");
        trans_History=trans_History.concat(str);

        s.close();
    }

    void transfer(String account_no,int amount) {
        System.out.println("Enter account_no where to transfer=");
        Scanner s= new Scanner(System.in);
        account_no=s.nextLine();
        System.out.println("Enter amount=");
        amount=s.nextInt();
        if(amount<=Balance)
        {
            System.out.println("Rs "+amount+" Transfer to  "+account_no);
            trans++;
            String str=("Rs "+amount+" Transfer to  "+id);
            trans_History=trans_History.concat(str);
        }
        else{
            System.out.println("Insufficient Amount.");
        }

        s.close();
    }

    public static void main(String args[]) {
        ATM o = new ATM();
        int pin, amount = 0, Balance = 5000;
        String id;
        String rid = "12345678901";
        System.out.println("Enter your data:");
        System.out.println("Enter your 11 digit id:");
        Scanner s = new Scanner(System.in);
        id = s.nextLine();
        System.out.println("Enter Pin:");
        pin = s.nextInt();


        if (pin == 1234 && id.equals(rid))
        {
            System.out.println("1.Transaction History");
            System.out.println("2.Withdraw");
            System.out.println("3.Deposite");
            System.out.println("4.Transfer");
            System.out.println("5.Quit");
            int tra;
            System.out.println("Enter Trasaction:");
            tra = s.nextInt();


            switch (tra)
            {
                case 1:
                    o.transaction();

                    break;
                case 2:
                    o.withdraw(amount, Balance);

                    break;
                case 3:
                    o.deposite(amount, Balance);

                    break;
                case 4:
                    o.transfer(id,amount);

                    break;
                case 5:
                    System.exit(0);


                default:
                    System.out.println("invalid data..");

                    break;
            }
        }
        else {
            if (!id.equals(rid)) {
                System.out.println("invalid id...");
            } else {
                System.out.println("incorrect pin...");
            }
        };
        s.close();


    }


}