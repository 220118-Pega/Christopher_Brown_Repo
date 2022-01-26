package com.revature.stacklite.dl;
import java.util.ArrayList;
import com.revature.stacklite.models.Request;
import com.revature.stacklite.models.Request.status;

public class ReimbursementDL 
{
	public static ArrayList<Request> listOfReimbursements = new ArrayList<Request>(); 
	static int idCount = 0;
	
	public static void addRequest(String transactionType, String amount, String date)
	{	
		listOfReimbursements.add(new Request(transactionType, amount, date));
		idCount++;
	}
	
	public void printList()
	{			
		for (int i = 0; i < listOfReimbursements.size();i++) 
	    { 		      
			Request temp = listOfReimbursements.get(i);
	        System.out.println("Id #:" + i + " Type:" + temp.transactionType + " Amount:" + temp.amount + " Date:" + temp.date);
	    }
	}
	
	public status readApprovalStatus(int id)
	{
		Request temp = listOfReimbursements.get(id);
		return temp.approvalStatus;
	}
	
	public void approve(int id)
	{
		Request temp = listOfReimbursements.get(id);
		temp.approvalStatus = status.approved;
	}
	
	public void decline(int id)
	{
		Request temp = listOfReimbursements.get(id);
		temp.approvalStatus = status.declined;
	}
}