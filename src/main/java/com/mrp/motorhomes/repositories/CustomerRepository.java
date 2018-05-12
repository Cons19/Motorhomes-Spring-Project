package com.mrp.motorhomes.repositories;

import com.mrp.motorhomes.model.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerRepository extends CrudRepository<Customer> {

	/**
	 * 
	 * @param item
	 */
	@Override
	public void create(Customer item) {
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO customers(firstName, lastName, email, address, phone, ssn) VALUES (? ,? ,? ,? ,? ,?)");
			preparedStatement.setString(1, item.getFirstName());
			preparedStatement.setString(2, item.getLastName());
			preparedStatement.setString(3, item.getEmail());
			preparedStatement.setString(4, item.getAddress());
			preparedStatement.setString(5, item.getPhone());
			preparedStatement.setString(6, item.getSsn());
			preparedStatement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Customer> readAll() {
		ArrayList<Customer> customers = new ArrayList<>();
		
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM customers");
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				customers.add(new Customer(
						resultSet.getInt("id"),
						resultSet.getString("firstName"),
						resultSet.getString("lastName"),
						resultSet.getString("email"),
						resultSet.getString("address"),
						resultSet.getString("phone"),
						resultSet.getString("ssn")
				));
			}
			return customers;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 *
	 * @param id
	 */
	@Override
	public Customer read(int id) {
		try {
			preparedStatement = connection.prepareStatement("SELECT  * FROM customers WHERE  id=?");
			preparedStatement.setInt(1, id);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return new Customer(
						resultSet.getInt("id"),
					    resultSet.getString("firstName"),
					    resultSet.getString("lastName"),
					    resultSet.getString("email"),
					    resultSet.getString("address"),
					    resultSet.getString("phone"),
					    resultSet.getString("ssn")
				);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param item
	 */
	@Override
	public void update(Customer item) {
		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE customers SET firstName=?, lastName=?, email=?, address=?, phone=?, ssn=? WHERE id=?");
			preparedStatement.setString(1, item.getFirstName());
			preparedStatement.setString(2, item.getLastName());
			preparedStatement.setString(3, item.getEmail());
			preparedStatement.setString(4, item.getAddress());
			preparedStatement.setString(5, item.getPhone());
			preparedStatement.setString(6, item.getSsn());
			preparedStatement.setInt   (7, item.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param id
	 */
	@Override
	public void delete(int id) {
		try{
			preparedStatement = connection.prepareStatement("DELETE FROM customers WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}