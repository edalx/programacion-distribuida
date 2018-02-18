package com.eacuji.dao;

import com.eacuji.entities.Data;
import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<Data, Long> {
}
