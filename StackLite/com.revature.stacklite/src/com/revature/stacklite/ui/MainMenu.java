package com.revature.stacklite.ui;
import java.util.Scanner;
import com.revature.stacklite.dl.ReimbursementDL;

public class MainMenu 
{
	private Scanner myscanner;
	
	public MainMenu(Scanner myscanner) 
	{
		this.myscanner = myscanner;
	}
	
	public void start()
	{
		ReimbursementDL reimbursements = new ReimbursementDL();
		boolean running = true;
		while(running) 
		{		
			System.out.println("Welcome to Stacklite, what do you wanna do?");
			System.out.println("[0] Create an reinbursement request");
			System.out.println("[1] View all requests");
			System.out.println("[2] Approve requests by id");
			System.out.println("[x] Exit");

			String userInput = myscanner.nextLine();
			switch (userInput) 
			{
				case "0":
					String typeTemp;
					String amountTemp;
					String dateTemp;
					String input;
						
					System.out.println("Enter the transaction type.");
					System.out.println("[0] Goods");
					System.out.println("[1] Services");
					System.out.println("[2] Lodging");
					input = myscanner.nextLine();
					typeTemp = input; //needs input validation and convert input to int or enum
					
					System.out.println("Enter the transaction ammount: ");
					input = myscanner.nextLine(); //needs input validation
					amountTemp = input;
					
					System.out.println("Enter the transaction date: ");
					input = myscanner.nextLine();
					dateTemp = input; //needs input validation	
					
					ReimbursementDL.addRequest(typeTemp, amountTemp, dateTemp);	
					break;
					
				case "1":
					System.out.println("All requests: ");					
					reimbursements.printList();
					break;
					
				case "2":
					System.out.println("Enter the id number of the reimbursement to approve/decline: ");
					input = myscanner.nextLine();
					int id = Integer.parseInt(input);//needs input validation
					
					System.out.println("Current appproval status: " + reimbursements.readApprovalStatus(id));
					System.out.println("[0] Change to approved");
					System.out.println("[1] Change to declined");
					
					input = myscanner.nextLine();					
					switch (userInput)
					{
						case "0":
							reimbursements.approve(id);
							System.out.println("Status changed to approved.");
							break;
							
						case "1":
							reimbursements.decline(id);
							System.out.println("Status changed to declined.");
							break;
							
						default:
							System.out.println("Unrecognized input. Try again.");
							break;
					}
					break;
					
				case "x":
					System.out.println("Goodbye");
					running = false;
					break;
					
				default:
					System.out.println("Unrecognized input. Try again.");
					break;
			}
		}
	}
}