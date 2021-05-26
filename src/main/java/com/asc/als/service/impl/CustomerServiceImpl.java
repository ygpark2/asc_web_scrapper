package com.asc.als.service.impl;

import com.asc.als.repository.CustomerRepository;
import com.asc.als.domain.Customer;
import com.asc.als.domain.Name;
import com.asc.als.service.CustomerService;
import com.asc.als.service.DefaultBaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * .
 *
 * @author 박 영규
 */
@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl extends DefaultBaseService<CustomerRepository, Customer, Name>
		implements CustomerService {

	protected CustomerServiceImpl(CustomerRepository repository) {
		super(repository);
	}

}
