package com.example;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("MY_CASSANDRA_ENTRY")
public class MyCassandraEntry {

    @PrimaryKey
    @Column("MY_CASS_STRING")
    String myCassString;

}
