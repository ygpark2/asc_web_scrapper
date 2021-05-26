/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.asc.als.domain;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mybatis.domain.Audit;

import java.util.ArrayList;
import java.util.List;

/**
 * Goods category, for test case use.
 *
 * @author 박 영규
 * @since 2.0.0
 */
@Entity
@Table(name = "t_category")
@Data
@NoArgsConstructor
public class Category extends Audit<Long, Long> {

	private String name;

	private String cid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	private Category parent;

	@OneToMany(mappedBy = "parent")
	private List<Category> child = new ArrayList<>();

	public Category(String name, String cid, Category parent) {
		this.name = name;
		this.cid = cid;
		this.parent = parent;
	}

	public void addChildCategory(Category child) {
		this.child.add(child);
		child.setParent(this);
	}

}
