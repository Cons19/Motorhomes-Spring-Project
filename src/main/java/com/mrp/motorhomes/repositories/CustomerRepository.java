package com.mrp.motorhomes.repositories;

import com.mrp.motorhomes.model.Customer;

import java.util.ArrayList;

public class CustomerRepository extends CrudRepository<Customer> {

	/**
	 * 
	 * @param item
	 */
	@Override
	public void create(Customer item) {
		// TODO - implement CustomerRepository.create
		throw new UnsupportedOperationException();
	}
	
	@Override
	public ArrayList<Customer> readAll() {
		// TODO - implement CustomerRepository.readAll
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	@Override
	public Customer read(int id) {
		// TODO - implement CustomerRepository.read
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	@Override
	public void update(Customer item) {
		// TODO - implement CustomerRepository.update
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	@Override
	public void delete(int id) {
		// TODO - implement CustomerRepository.delete
		throw new UnsupportedOperationException();
	}

}