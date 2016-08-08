package com.example;

import org.cassandraunit.spring.CassandraDataSet;
import org.cassandraunit.spring.CassandraUnit;
import org.cassandraunit.spring.CassandraUnitDependencyInjectionTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/*
 * https://github.com/jsevellec/cassandra-unit/wiki/Spring-for-Cassandra-unit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest({ "spring.data.cassandra.port=9142",
        "spring.data.cassandra.keyspace-name=keyspaceToCreate" })
@EnableAutoConfiguration
@ComponentScan
@ContextConfiguration
@TestExecutionListeners({ CassandraUnitDependencyInjectionTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class })
@CassandraDataSet(value = { "setupTables.cql" }, keyspace = "keyspaceToCreate")
@CassandraUnit
public class ApplicationTests {

    @Autowired
    MyCassandraRepository repo;

    @Test
    public void contextLoads() {

        System.out.println(repo.findAll());

    }

}
