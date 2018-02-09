package com.eacuji.dao;

import com.eacuji.dto.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by eacuji on 25/12/2017.
 */
@Repository
public interface AlbumDao extends JpaRepository<Album, Long> {

    @Query("select a from Album a left join a.singer s where s.id = :id")
    List<Album> findBySingerId(@Param("id") Long id);
}
