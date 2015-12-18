
package mainproject;

import java.util.Scanner;

public class CreditCard extends Payment 
{
    public String nameOnCreditCard;
    public String creditCardNumber;
    public String dateofExpiry;
    public String cvvNumber;
    private static CreditCard instance;

    public String getNameOnCreditCard() 
    {
        return nameOnCreditCard;
    }

    public void setNameOnCreditCard(String nameOnCreditCard) 
    {
        this.nameOnCreditCard = nameOnCreditCard;
    }

    public String getCreditCardNumber() 
    {
        return "12345678";
    }

    public void setCreditCardNumber(String creditCardNumber) 
    {
        this.creditCardNumber = creditCardNumber;
    }

    public String getDateofExpiry() {
        return dateofExpiry;
    }

    public void setDateofExpiry(String dateofExpiry) {
        this.dateofExpiry = dateofExpiry;
    }

    public String getCvvNumber() {
        return "123";
    }

    public void setCvvNumber(String cvvNumber) {
        this.cvvNumber = cvvNumber;
    }
    
    @Override
    public void initPaymentType() 
    {
        System.out.println("Intializing Credit Card payment\n");
    }

    @Override
    public boolean payUsingSelectedPaymentType(String payerName, String payeeName, String paymentAmount) 
    {
        boolean paymentStatus;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter name on the credit card:");
        setNameOnCreditCard(in.nextLine());
        System.out.println("Please enter your credit card number:");
        setCreditCardNumber(in.nextLine());
        System.out.println("Please enter the expiry in mm/yy format:");
        setDateofExpiry(in.nextLine());
        System.out.println("Please enter CVV number");
        setCvvNumber(in.nextLine());
        if(getCreditCardNumber().equals("12345678") && getCvvNumber().equals("123"))
        {
            paymentStatus = true;
            System.out.println("Card authenticated");
            System.out.println("Logging into " +payerName+"'s Account\n");
            System.out.println("Intiating transfer");
            System.out.println("Transferring $" +paymentAmount +" to " +payeeName);
            System.out.println("Payment successfully made via Credit Card\n");
        }
        else
        {
            paymentStatus = false;
            System.out.println("Login failed");
            System.out.println("Please try again ...");
        }
	return paymentStatus;
    }
    
    public static CreditCard getInstance()
    {
        if(instance == null)
        {
            instance = new CreditCard();
        }
        return instance;
    }    
}
