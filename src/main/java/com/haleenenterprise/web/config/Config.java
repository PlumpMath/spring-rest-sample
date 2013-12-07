package com.haleenenterprise.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration("myConfig")
public class Config {

    private String foo;

    public String getFoo() {
        return foo;
    }

    @Value("${foo.bar}")
    public void setFoo(String foo) {
        this.foo = foo;
    }

}
