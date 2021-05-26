/*
 *
 *   Copyright 2017 the original author or authors.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package com.asc.als.config;

import java.util.Arrays;
import java.util.Calendar;

import com.asc.als.domain.Address;
import com.asc.als.domain.Shop;
import com.asc.als.repository.ShopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);


	private final ShopRepository shopRepository;

	public DatabaseLoader(ShopRepository shopRepository) {
		this.shopRepository = shopRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		try {

			Shop first = new Shop("Walmart", "shop@walmart.com");
			first.setActive(true);
			first.setDuration(9);
			first.setIntroduce("I am the 300th shop of Walmart.");
			first.setAddress(new Address("USA", "NY", "Queen", "351"));
			first.setBrandEstablishmentTime(new Calendar.Builder().setDate(1962, 1, 1).build().getTime().getTime());
			first.setOpeningTime(new Calendar.Builder().setDate(2010, 10, 1).build().getTime());

			Shop second = new Shop("Costco", "costco@gmail.com");
			second.setActive(false);
			second.setDuration(9);
			second.setIntroduce("I am the 20th shop of Costco.");
			second.setAddress(new Address("USA", "WA", "Issaquah", "908"));
			second.setBrandEstablishmentTime(new Calendar.Builder().setDate(1976, 1, 1).build().getTime().getTime());
			second.setOpeningTime(new Calendar.Builder().setDate(2009, 5, 15).build().getTime());

			Shop third = new Shop("Carrefour", "carrefour@gmail.com");
			third.setActive(true);
			third.setDuration(12);
			third.setAddress(new Address("FR", "Boulogne", "Golden", "18"));
			third.setBrandEstablishmentTime(new Calendar.Builder().setDate(1959, 1, 1).build().getTime().getTime());
			third.setOpeningTime(new Calendar.Builder().setDate(2011, 6, 25).build().getTime());

			Shop fourth = new Shop("Auchan", "shop@auchan.com");
			fourth.setActive(true);
			fourth.setDuration(11);
			fourth.setAddress(new Address("FR", "London", "Oushang", "93"));
			fourth.setBrandEstablishmentTime(new Calendar.Builder().setDate(1961, 1, 1).build().getTime().getTime());
			fourth.setOpeningTime(new Calendar.Builder().setDate(2010, 3, 15).build().getTime());

			this.shopRepository.saveAll(Arrays.asList(first, second, third, fourth));

		}
		catch (Exception e) {
			logger.error("Can't load database data because of " + e.getMessage());
			throw e;
		}
	}

}
