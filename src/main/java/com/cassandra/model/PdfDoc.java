package com.cassandra.model;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * Created by akhilesh on 1/2/18.
 */

@Table("pdfdoc")
public class PdfDoc implements Serializable {

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private UUID id;

    @Column
    private ByteBuffer document;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ByteBuffer getDocument() {
        return document;
    }

    public void setDocument(ByteBuffer document) {
        this.document = document;
    }
}
