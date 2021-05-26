package com.asc.als.service.impl;

import com.asc.als.domain.Category;
import com.asc.als.repository.CategoryRepository;
import com.asc.als.service.DefaultBaseService;
import com.asc.als.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * .
 *
 * @author 박 영규
 */
@Service
@Transactional(readOnly = true)
public class CategoryServiceImpl extends DefaultBaseService<CategoryRepository, Category, Long> implements CategoryService {

	protected CategoryServiceImpl(CategoryRepository repository) {
		super(repository);
	}

}
