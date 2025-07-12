package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Country {
    public static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
    private String name;
    private String code;
    public Country(){
        LOGGER.debug("Inside Country Constructor.");
    }

    public String getCode(){
        LOGGER.debug("Inside getCode");
        return code;
    }
    public void setCode(String code){
        LOGGER.debug("Inside setCode");
        this.code = code;
    }
    public String getName(){
        LOGGER.debug("Inside getName");
        return name;
    }
    public void setName(String name){
        this.name= name;
    }
    @Override
    public String toString(){
        return "{ code='" + code + ", name=" + name +" }";
    }
}
