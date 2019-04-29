package com.github.huhangchn;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

public class Test1 extends Tester {

    @Autowired
    DataSource dataSource;

    @Test
    public void test(){
        System.out.println("dataSource = " + dataSource);
    }
}
