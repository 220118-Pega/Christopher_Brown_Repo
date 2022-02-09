package com.revature.stacklite.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.revature.stacklite.models.Request;

public class RequestDAO implements DAO<Request, Integer>
{
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	@Override
	public Request findById(Integer id) 
	{
		try (Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query = "select * from requests where ticket_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,  id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				return new Request(rs.getString("ticket_id"), rs.getString("employee_id"), rs.getString("amount"), rs.getString("date"), rs.getString("status"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("Error with connecting to the DB");
		}
		return null;
	}

	@Override
	public List<Request> findAll() 
	{
		List<Request> requests = new ArrayList<Request>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query = "select * from requests";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				requests.add(new Request(rs.getString("ticket_id"), rs.getString("employee_id"), rs.getString("amount"), rs.getString("date"), rs.getString("status")));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("Something went wrong", e);
		}
		return requests;
	}

	@Override
	public void add(Request newObject) 
	{
		try(Connection conn= ConnectionFactory.getInstance().getConnection())
		{
			String query = "insert into requests (employee_id, amount, date, status) values (?, ?, ?, ?);";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, newObject.employeeId);
			pstmt.setString(2, newObject.amount);
			pstmt.setString(3, newObject.date);
			pstmt.setString(4, String.valueOf(newObject.approvalStatus));
			pstmt.execute();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void update(int id, String status) 
	{
		try(Connection conn= ConnectionFactory.getInstance().getConnection())
		{
			String query = "update requests set status = '?' where ticket_id = ?;";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, status);
			pstmt.setInt(2, id);
			pstmt.execute();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) 
	{
		try(Connection conn= ConnectionFactory.getInstance().getConnection())
		{
			String query = "delete from requests where ticket_id = ?;";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.execute();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
