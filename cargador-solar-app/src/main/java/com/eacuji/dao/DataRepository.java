package com.eacuji.dao;

import com.eacuji.dto.Data;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DataRepository extends CrudRepository<Data, Long> {

    //@Query("select d from Data d where d.usbId = :usbId order by d.createdAt DESC")
    //Data findLast(@Param("usbId") Integer id);

    Data findTopByUsbIdOrderByCreatedAtDesc(Integer usbId);
}
