package com.datajabs.datajabsinstitute.repository;

import com.datajabs.datajabsinstitute.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
