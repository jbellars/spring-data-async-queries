package com.infiniteskills.springdata.async.data.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Defines custom methods that will be shared across all of our Spring Data repositories
 * @param <T> Domain class
 * @param <ID> unique identifier
 */
@EnableAsync
@NoRepositoryBean
@SuppressWarnings("unchecked")
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID>
{
	@Async("MyExecutor")
	List<T> findByIds(ID... ids);
}
