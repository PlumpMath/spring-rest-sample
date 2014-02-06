package com.haleenenterprise.web.controller;

import com.haleenenterprise.web.config.Config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;



@Controller
@RequestMapping("sample/**")
public class SampleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private Config config;

    @RequestMapping(value="echo/{word}", method = RequestMethod.GET)
    public @ResponseBody Object word(@PathVariable("word") final String word) {
        LOGGER.info("word");
        return new HashMap<String, String>(){{
            put("result", word);
        }};
    }

    @RequestMapping(value="foo", method = RequestMethod.GET)
    public @ResponseBody Object foo() {
        return config.getFoo();
    }

}
