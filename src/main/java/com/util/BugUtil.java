package com.util;

import org.apache.log4j.Logger;
public class BugUtil {
    private  static Logger logger = Logger.getLogger(BugUtil.class);
    public static void addBug(Throwable e) {
        logger.error(e);
    }
}
