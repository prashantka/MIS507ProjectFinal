
package mainproject;

 import java.util.Scanner;

 
 /*
  * UserAccount stores the key fields of the persons involved in the split.This includes userid, first name,last name,
 * email, amount owed, amount receivable,payable to, receivable by, flag to check if any money is receivable and 
 * email body*/
 
public class UserAccount implements Observer{
    
    private int userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private double amountOwed;
    private double amountReceivable;
    private String payableTo;
    private String receivableBy;
    private boolean isReceivable;
    private String emailbody;


  public UserAccount(int userId, String userFirstName, String userLastName, String userEmail, double amountOwed, double amountReceivable, String payableTo, String receivableBy){
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.amountOwed = amountOwed;
        this.amountReceivable = amountReceivable;
        this.payableTo = payableTo;
        this.receivableBy = receivableBy;
    }

  //get set methods for all the fields
  
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }

    public double getAmountReceivable() {
        return amountReceivable;
    }

    public void setAmountReceivable(double amountReceivable) {
        this.amountReceivable = amountReceivable;
    }

    public String getPayableTo() {
        return payableTo;
    }

    public void setPayableTo(String payableTo) {
        this.payableTo = payableTo;
    }

    public String getReceivableBy() {
        return receivableBy;
    }

    public void setReceivableBy(String receivableBy) {
        this.receivableBy = receivableBy;
    }
   
    public boolean isReceivable() {
  		return isReceivable;
  	}

  	public void setReceivable(boolean isReceivable) {
  		this.isReceivable = isReceivable;
  	}
  		
  //The update method is called in the publisher to notify the amount owed and the person to be paid.
	public void update(String notification) {
		if(!isReceivable()){
			emailbody = "Hello " +getUserFirstName() +",\n"+"You owe "+getPayableTo()+" $"+getAmountOwed();
			EmailNotification.sendEmail(getUserEmail(),"Payment Details",emailbody );
		}
	      
	      
	    }
	
	//This method is used to notify that a user has been added to the group
	public void add(String notification) {
	      emailbody = "Hello "+getUserFirstName()+"\n"+
	                     "You have been added to the group "+notification+"\n";
	      EmailNotification.sendEmail(getUserEmail(),"Addition to Group",emailbody );
	    }
	
	//This method is used to send reminders to everyone who has not settled their dues
	public void remind(String notification) {
	      emailbody = "Hello "+getUserFirstName()+"\n"+
	                     "You owe "+getPayableTo()+" $"+getAmountOwed()+"\n";
	      EmailNotification.sendEmail(getUserEmail(),"Gentle Reminder to pay",emailbody );
	    }

	 //This method is used to convey the message that payment has been successful
	public void paysuccess(String notification) {
		if(!isReceivable()){
	      emailbody = "Hello "+getUserFirstName()+"\n"+
	                     "Your payment to "+getPayableTo()+"of $"+getAmountOwed()+" is successful "+"\n";
         EmailNotification.sendEmail(getUserEmail(),"Payment Success",emailbody );
		}
	    }
    
}
