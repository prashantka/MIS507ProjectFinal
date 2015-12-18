package mainproject;

import java.util.List;

public class InputValidation {

	/*
	 * This is the method for verifying email. It takes the email of the user as
	 * a parameter
	 */

	public static boolean verifyEmail(String email) {
		email = email.trim();

		if (email == null || email.equals(""))
			return false;
		// This is the regex to validate an email
		if (!email
				.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
			return false;

		return true;
	}

	/*
	 * This method checks if the user name exists already
	 */
	public static boolean checkUserExists(List<UserAccount> users, String name) {
		boolean isUserExists = false;
		for (UserAccount user : users) {
			if (user.getUserFirstName().equals(name)) {
				isUserExists = true;
			}
		}
		return isUserExists;
	}

	/*
	 * This is to validate the user options provided
	 */
	public void validateOperation(int operation) {
		if (operation < 1 || operation > 4) {
			System.out
					.println("Please enter a valid operation between 1 and 4");
		}
	}

	/*
	 * This method checks if the username is empty or not
	 */

	public void checkUserDetails(String aName, double aSpeed) {
		if (!checkName(aName)) {
			throw new IllegalArgumentException("Name is empty.");
		}
	}

	private boolean checkName(String name) {
		String EMPTY_STRING = "";
		return (name != null) && (!name.trim().equals(EMPTY_STRING));
	}

	/*
	 * This method verifies whether a number is entered by the users and the
	 * number of users
	 */
	public static boolean verifyUsers(String s) {
		if (isInteger(s) && verifyNumberOfUsers(s)) {
			return true;
		} else {
			return false;
		}

	}

	/*
	 * A group should consist of atleast 2 users. This method validates the
	 * same.
	 */
	public static boolean verifyNumberOfUsers(String s) {

		Integer i = Integer.parseInt(s);
		if (i >= 2) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}

	public static boolean isDouble(String s) {
		try {
			Double.parseDouble(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}

	/*
	 * This method checks for users names in the group to check if a user with
	 * the entered name actually exists or not
	 */
	public static boolean validatePayerName(List<UserAccount> groupDetails,
			String payerName) {
		boolean IsValid = false;
		for (int i = 0; i < groupDetails.size(); i++) {
			if (groupDetails.get(i).getUserFirstName().equals(payerName)) {
				IsValid = true;
			}
		}
		return IsValid;
	}

	/*
	 * This method checks if the payment amount is valid as per calculations
	 */
	public static boolean validatePaymentAmount(List<UserAccount> groupDetails,
			double paymentAmount) {
		boolean IsValid = false;
		for (int i = 0; i < groupDetails.size(); i++) {
			if (groupDetails.get(i).getAmountOwed() >= paymentAmount) {
				IsValid = true;
			}
		}
		return IsValid;
	}
}
