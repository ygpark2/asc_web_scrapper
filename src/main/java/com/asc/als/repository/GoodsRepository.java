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
package com.asc.als.repository;

import org.springframework.data.mybatis.repository.MybatisRepository;
import com.asc.als.domain.Goods;

/**
 * Repository interface for {@code Goods}.
 *
 * @author 박 영규
 * @since 2.0.0
 */
public interface GoodsRepository extends MybatisRepository<Goods, Long> {

}