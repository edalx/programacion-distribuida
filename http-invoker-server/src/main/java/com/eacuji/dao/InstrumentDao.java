package com.eacuji.dao;

import com.eacuji.entities.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by eacuji on 26/12/2017.
 */
@Repository
public interface InstrumentDao extends JpaRepository<Instrument, String> {

    @Query("select i from Instrument i left join i.singers s where s.id = :id")
    List<Instrument> findBySingerId(@Param("id") Long id);
}
