package com.eacuji.dao;

import com.eacuji.entities.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by eacuji on 06/01/2018.
 */
@Repository
public interface SingerDao extends JpaRepository<Singer, Long> {
}
