package com.jersey.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jean on 7/21/17.
 */
@Controller
public class Test {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody String test() {
        return "test";
    }
}
