package common.utilities;

import org.apache.logging.log4j.*;

public class Logging {

    /*@Author-Avinash M(AVM031)
     * This class has all the functions defined for logging.
     */

    private static final Logger log = LogManager.getLogger(Logging.class);
    public static void info(String message) {
        log.info(message);
    }
    public static void warn(String message) {
        log.warn(message);
    }
    public static void error(String message) {
        log.error(message);
    }
    public static void fatal(String message) {
        log.fatal(message);
    }
    public static void debug(String message) {
        log.debug(message);
    }
}