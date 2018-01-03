package com.cassandra.repository;

import com.cassandra.model.PdfDoc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by akhilesh on 1/2/18.
 */
@Repository
public interface PdfDocRepo extends CrudRepository<PdfDoc, UUID>{
}
