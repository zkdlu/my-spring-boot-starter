package com.zkdlu.myspringbootstarter;

public class Hello {
    private HelloConfig helloConfig;

    public Hello(HelloConfig helloConfig) {
        this.helloConfig = helloConfig;
    }

    public String hello() {
        return helloConfig.get("zkdlu.hello") + " : " + helloConfig.getProperty("zkdlu.hello");
    }
}
