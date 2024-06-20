package com.bezkoder.spring.datajpa.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.datajpa.model.Cow;
@Repository
public interface Cowrepository extends JpaRepository<Cow, String> {
	//List<CowEntity> findByPublished(boolean published);
		//List<CowEntity> findByTitleContaining(String title);
	//Cow findbyId(String id);
	
	<S extends Cow> S save(S entity);
}
