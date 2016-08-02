package com.example;

import org.cassandraunit.spring.CassandraDataSet;
import org.cassandraunit.spring.CassandraUnit;
import org.cassandraunit.spring.CassandraUnitDependencyInjectionTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/*
 * https://github.com/jsevellec/cassandra-unit/wiki/Spring-for-Cassandra-unit
 */
@RunWith(SpringJUnit4ClassRunner.class)
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
