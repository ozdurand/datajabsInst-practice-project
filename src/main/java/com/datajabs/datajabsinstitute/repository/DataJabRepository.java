package com.datajabs.datajabsinstitute.repository;

import com.datajabs.datajabsinstitute.model.DataJabClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataJabRepository extends JpaRepository<DataJabClass, Integer> {
}
