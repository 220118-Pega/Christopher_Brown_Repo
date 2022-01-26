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
		ReimbursementDL reimbursementsDL = new ReimbursementDL();
		boolean running = true;
		int login = 0;
		
		while(running) 
		{		
			String userInput = "";
			
			System.out.println("Welcome to Stacklite ");
			//login
			if (login == 0)
			{
				System.out.println("Enter Login");
				System.out.println("[0] Employee");
				System.out.println("[1] Manager");
				userInput = myscanner.nextLine();
				
				switch (userInput)
				{
					case "0":
						login = 1;
						break;
						
					case "1":
						login = 2;
						break;
					default:
						System.out.println("Unrecognized input. Try again.");
						break;
				}
			}
			
			//Employee menu
			if (login == 1)
			{				
				System.out.println("What would you like to do?");
				System.out.println("[0] Create a reinbursement request");
				System.out.println("[1] View all your requests");
				System.out.println("[x] Exit");
			}
			//Manager menu
			else if (login == 2)
			{
				System.out.println("What would you like to do?");
				System.out.println("[0] Create an reinbursement request");
				System.out.println("[1] View all requests");
				System.out.println("[2] Approve/decline requests by id");
				System.out.println("[3] Filter requests by status");
				System.out.println("[4] Coffee break");
				System.out.println("[x] Exit");
			}
			userInput = myscanner.nextLine();
			
			switch (userInput) 
			{
				case "0"://Add request
					String typeTemp;
					String amountTemp;
					String dateTemp;
						
					System.out.println("Enter the transaction type.");
					System.out.println("[0] Goods");
					System.out.println("[1] Services");
					System.out.println("[2] Lodging");
					userInput = myscanner.nextLine();					
					typeTemp = userInput; //needs input validation and convert input to int or enum
					
					System.out.println("Enter the transaction ammount: ");
					userInput = myscanner.nextLine(); //needs input validation
					amountTemp = userInput;

					System.out.println("Enter the transaction date: ");
					userInput = myscanner.nextLine();
					dateTemp = userInput; //needs input validation	
					
					ReimbursementDL.addRequest(typeTemp, amountTemp, dateTemp);	
					break;
					
				case "1": //View all requests
					System.out.println("All requests: ");
					if (login == 1) //employee
					{
						reimbursementsDL.printList(); //fix to "by same id" only
					}
					else if (login == 2) //employee
					{
						reimbursementsDL.printList();
					}
					break;
					
				case "2": //Manager--approve/decline requests
					System.out.println("Enter the id number of the reimbursement to approve/decline: ");
					userInput = myscanner.nextLine();
					int id = Integer.parseInt(userInput);//needs input validation
					
					System.out.println("Current appproval status: " + reimbursementsDL.readApprovalStatus(id));
					System.out.println("[0] Change to approved");
					System.out.println("[1] Change to declined");	
					userInput = myscanner.nextLine();	
					
					switch (userInput)
					{
						case "0":
							reimbursementsDL.approve(id);
							System.out.println("Status changed to approved.");
							break;
							
						case "1":
							reimbursementsDL.decline(id);
							System.out.println("Status changed to declined.");
							break;
							
						default:
							System.out.println("Unrecognized input. Try again.");
							break;
					}
					break;
					
				case "3": //Manager--filter requests by status
					break;
					
				case "4": //For lols
					System.out.println("       )  (");
					System.out.println("    __(____)_");
					System.out.println(" .-'---------|");
					System.out.println("( C|/\\/\\/\\/\\/|");
					System.out.println(" '-./\\/\\/\\/\\/|");
					System.out.println("   '_________'");
					System.out.println("    '-------'");
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