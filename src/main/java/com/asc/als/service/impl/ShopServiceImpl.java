package com.asc.als.service.impl;

import com.asc.als.repository.ShopRepository;
import com.asc.als.domain.Shop;
import com.asc.als.service.DefaultBaseService;
import com.asc.als.service.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * .
 *
 * @author 박 영규
 */
@Service
@Transactional(readOnly = true)
public class ShopServiceImpl extends DefaultBaseService<ShopRepository, Shop, Long> implements ShopService {

	protected ShopServiceImpl(ShopRepository repository) {
		super(repository);
	}

}
