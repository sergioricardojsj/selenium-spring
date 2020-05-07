package com.home.teste.configuration;

import com.home.teste.TesteApplicationTests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

    private static final Logger logger = LoggerFactory.getLogger(TesteApplicationTests.class);

    public static void logInfo(String info) {
        try {
            logger.info(info);
        } catch (Exception e) {

        }
    }

    public static void logErro(String error) {
        try {
            logger.error(error);
        } catch (Exception e) {

        }
    }

}
