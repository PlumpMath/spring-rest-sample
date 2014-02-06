package com.haleenenterprise.web.config;

import org.junit.Assert;
import org.junit.Test;

public class TestConfig {

    @Test
    public void indepthTest(){
        Config config = new Config();
        config.setFoo("foo");
        
        Assert.assertEquals("should be foo... obviously", "foo", config.getFoo());
    }

}
