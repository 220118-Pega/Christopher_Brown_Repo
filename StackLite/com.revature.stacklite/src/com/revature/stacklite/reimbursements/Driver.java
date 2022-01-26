package com.revature.stacklite.reimbursements;
import java.util.Scanner;
import com.revature.stacklite.ui.MainMenu;

/*
Project 0: Expense Reimbursement API
Executive Summary:
The Expense Reimbursement API will manage the process of reimbursing employees for expenses incurred while on company time. 
All employees in the company can submit requests for reimbursement and view their past tickets and pending requests. 
Finance managers can view all reimbursement requests and past history for all employees in the company. 
Finance managers are authorized to approve and deny requests for expense reimbursement.

--Requirements:
-Use three tier design architecture.
-Data is stored in a database.
-All tables need to be in 3rd Normal Form.
-Must use javalin on middle tier
-Must use JUnit test on the service class(s) and Postman or Swagger to test endpoints.
-Must use JDBC to talk to database.
-Logging must be implemented with Log4j and not by java.

--Stretch Goal (Optional requirements):
-Passwords shall be encrypted/hashed in Java and securely stored in the database.
-Users can upload a document or image of their receipt when submitting reimbursements.
-Have front end written in HTML, CSS, and JS or some other front end framework or library such as React or Angular

--User Stories:
Employee:
I can view past tickets (pending, approved rejected)
I can add a reimbursement request.
Employees must select the type of reimbursement as LODGING, TRAVEL, FOOD, or OTHER.
Reimbursement ticket must specify the amount to be reimbursed and a description that the employee may add (in addition to the type) and a time stamp associated with it.
Finance Manager:
As a finance manager, I can view all the reimbursements for all employees.
I can filter the requests by the status of the tickets (approved, rejected, pending)
*/

public class Driver 
{
	public static void main(String[] args) 
	{
		MainMenu menu = new MainMenu(new Scanner(System.in));
		menu.start();
	}
}