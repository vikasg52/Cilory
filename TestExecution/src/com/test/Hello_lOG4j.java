package com.test;
import org.apache.log4j.Logger;
    import org.apache.log4j.BasicConfigurator;
    
    public class Hello_lOG4j {
    
      private static final Logger logger = Logger.getLogger(Hello_lOG4j.class);
    
      public static void main(String argv[]) {
    	BasicConfigurator.configure();
    	logger.debug("Hello world.");
    	logger.info("What a bea'tiful day.");
      }
    }
