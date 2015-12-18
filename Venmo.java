
package mainproject;


import java.util.Scanner;
/*
 * 
 * */
public class Venmo extends Payment 
{
    public String venmoUserName;
    public String venmoPassword;
    private static Venmo instance;
	
    private Venmo(){
		
	}
	
    public String getVenmoUserName() 
    {
        return venmoUserName;
    }

    public void setVenmoUserName(String venmoUserName) 
    {
        this.venmoUserName = venmoUserName;
    }

    public String getVenmoPassword() 
    {
        return venmoPassword;
    }

    public void setVenmoPassword(String venmoPassword) 
    {
        this.venmoPassword = "venmopassword";
    }
    
    @Override
    public void  initPaymentType () 
    {
	System.out.println("Intializing Venmo\n");
    }
    public boolean payUsingSelectedPaymentType(String payerName, String payeeName, String paymentAmount) 
    {
        boolean paymentStatus;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your Venmo username:");
        setVenmoUserName(in.nextLine());
        System.out.println("Please enter your Venmo password:");
        setVenmoPassword(in.nextLine());
        if(getVenmoPassword().equals("venmopassword"))
        {
            paymentStatus = true;
            System.out.println("Login successful");
            System.out.println("Logging into " +payerName+"'s Venmo Account\n");
            System.out.println("Intiating transfer");
            System.out.println("Transferring $" +paymentAmount +" to " +payeeName);
            System.out.println("Payment successfully made via Venmo\n");
        }
        else
        {
            paymentStatus = false;
            System.out.println("Login failed");
            System.out.println("Please try again ...");
        }
	return paymentStatus;        
    }
    
    public static Venmo getInstance()
    {
        if(instance == null)
        {
            instance = new Venmo();
        }
        return instance;
    }
}
