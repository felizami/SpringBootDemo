/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.controller;

import com.anuz.dummyapi.util.SynchronizedDemo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author anuz
 */
@RestController
@RequestMapping(value = "/")
public class DefaultController {

    private static Logger logger = LogManager.getLogger();

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public ResponseEntity index() {
        return ResponseEntity.ok("hello!, I'm feeling great");
    }

    @RequestMapping(value = "click_me", method = RequestMethod.GET)
    public ModelMap index1() {
        ModelMap map = new ModelMap();
        map.addAttribute("clickMe", "I'm feeling great");
        return map;
    }

    @RequestMapping(value = "logTest", method = RequestMethod.GET)
    public String logTest() {

        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");
        
        return "log test";
    }
    
    
    @RequestMapping(value = "raceCondition", method = RequestMethod.GET)
    public int raceCondition() {
        
        return SynchronizedDemo.demo();
//        return "log test";
    }
    
    
    
    

}
