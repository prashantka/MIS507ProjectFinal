package mainproject;

import java.util.Scanner;

public class Paypal extends Payment 
{
    public String paypalUserName;
    public String paypalPassword;

    //Declaring constructor as private as singleton design pattern is used to get instance.
    private Paypal(){
    	
    }
    
    public String getPaypalUserName() 
    {
        return paypalUserName;
    }

    public void setPaypalUserName(String paypalUserName) {
        this.paypalUserName = paypalUserName;
    }

    public String getPaypalPassword() 
    {
        return paypalPassword;
    }

    public void setPaypalPassword(String paypalPassword) 
    {
        this.paypalPassword = paypalPassword;
    }
    
    private static Paypal instance;
    @Override
    public void  initPaymentType () 
    {
	System.out.println("Intializing Paypal\n");
    }
    @Override
    public boolean payUsingSelectedPaymentType(String payerName, String payeeName, String paymentAmount) 
    {
        boolean paymentStatus;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your Paypal username:");
        setPaypalUserName(in.nextLine());
        System.out.println("Please enter your Paypal password:");
        setPaypalPassword(in.nextLine());
        if(getPaypalPassword().equals("paypalpassword"))
        {
            paymentStatus = true;
            System.out.println("Login successful");
            System.out.println("Logging into " +payerName+"'s Paypal Account\n");
            System.out.println("Intiating transfer");
            System.out.println("Transferring $" +paymentAmount +" to " +payeeName);
            System.out.println("Payment successfully made via Paypal\n");
        }
        else
        {
            paymentStatus = false;
            System.out.println("Login failed");
            System.out.println("Please try again ...");
        }
        return paymentStatus;  
    }
    
    public static Paypal getInstance()
    {
        if(instance == null){
            instance = new Paypal();
        }
        return instance;
    }
}
