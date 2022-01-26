package com.revature.stacklite.models;

public class Request 
{	
	public String transactionType;
	public String amount;
	public String date;
	public enum status{approved, pending, declined};
	public status approvalStatus;
	
	public Request(String transactionType, String amount, String date)
	{
		this.transactionType = transactionType;
		this.amount = amount;
		this.date = date;
		this.approvalStatus = status.pending;
	}
}