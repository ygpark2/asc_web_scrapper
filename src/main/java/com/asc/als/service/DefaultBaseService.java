package com.asc.als.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mybatis.repository.MybatisRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class DefaultBaseService<R extends MybatisRepository<T, ID>, T, ID> implements BaseService<T, ID> {

	private final R repository;

	protected DefaultBaseService(R repository) {
		this.repository = repository;
	}

	@Override
	public List<T> findAll() {
		return this.getRepository().findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<T> find(Example<T> example, Pageable pageable) {
		return this.getRepository().findAll(example, pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> find(Example<T> example) {
		return this.getRepository().findAll(example);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> find(Example<T> example, Sort sort) {
		return this.getRepository().findAll(example, sort);
	}

	@Override
	@Transactional(readOnly = true)
	public T getById(ID id) {
		return this.getRepository().getById(id);
	}

	@Transactional
	public void save(T user) {
		this.getRepository().save(user);
	}

	@Override
	@Transactional
	public <S extends T> List<S> saveAll(Iterable<S> entities) {
		return this.getRepository().saveAll(entities);
	}

	@Override
	@Transactional
	public <S extends T> List<S> saveAll(S... entities) {
		return this.getRepository().saveAll(entities);
	}

	@Override
	@Transactional
	public T insertSelective(T entity) {
		return this.getRepository().insertSelective(entity);
	}

	@Override
	@Transactional
	public T updateSelective(T entity) {
		return this.getRepository().updateSelective(entity);
	}

	@Override
	@Transactional
	public T updateSelective(ID id, T entity) {
		return this.getRepository().updateSelective(id, entity);
	}

	@Override
	@Transactional
	public void deleteById(ID id) {
		this.getRepository().deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public <S extends T> T findOne(Example<S> example) {
		return this.repository.findOne(example).orElse(null);
	}

	protected R getRepository() {
		return this.repository;
	}

}
