package com.revature.stacklite.models;

public class Request 
{	
	public int ticket_id;
	public int employeeId;
	public String amount;
	public String date;
	public enum status{approved, pending, declined};
	public status approvalStatus;
	
	public Request()
	{
		this.setTicket_id(0);
		this.employeeId = 0;
		this.amount = null;
		this.date = null;
		this.approvalStatus = status.pending;
	}
	
	public Request(int employeeId, String amount, String date)
	{
		this.setTicket_id(0);
		this.employeeId = employeeId;
		this.amount = amount;
		this.date = date;
		this.approvalStatus = status.pending;
	}
	
	public Request(String employeeId, String amount, String date)
	{
		this.employeeId = Integer.parseInt(employeeId);
		this.amount = amount;
		this.date = date;
		this.approvalStatus = status.pending;
	}
	
	public Request(String ticket_id, String employeeId, String amount, String date, String status)
	{
		this.setTicket_id(Integer.parseInt(ticket_id));
		this.employeeId = Integer.parseInt(employeeId);
		this.amount = amount;
		this.date = date;
		this.approvalStatus = approvalStatus.valueOf(status); // Possible problems converting string to enum?
	}
	
	public int getEmployeeId() 
	{
		return employeeId;
	}

	public void setEmployeeId(int employeeId) 
	{
		this.employeeId = employeeId;
	}

	public String getAmount() 
	{
		return amount;
	}

	public void setAmount(String amount) 
	{
		this.amount = amount;
	}

	public String getDate() 
	{
		return date;
	}

	public void setDate(String date) 
	{
		this.date = date;
	}

	public status getApprovalStatus() 
	{
		return approvalStatus;
	}

	public void setApprovalStatus(status approvalStatus) 
	{
		this.approvalStatus = approvalStatus;
	}
	
	public String toString() 
	{
		return "Request [amount=" + amount + ", date=" + date +  ", status=" + approvalStatus + "]";
	}

	public int getTicket_id() 
	{
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) 
	{
		this.ticket_id = ticket_id;
	}
}