package common.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


/*@Author-Avinash M(AVM031)
 * This class initializes the config.property file values.
 * 
 */
public class ConfigProperties {

    private static String maersk_host_url_local;
    private static String maersk_host_url_cdt;
    private static String maersk_host_url_pre_prod;
    private static String maersk_host_url_prod;

    private static String sealand_host_url_local;
    private static String sealand_host_url_cdt;
    private static String sealand_host_url_pre_prod;
    private static String sealand_host_url_prod;

    private static String safmarine_host_url_local;
    private static String safmarine_host_url_cdt;
    private static String safmarine_host_url_pre_prod;
    private static String safmarine_host_url_prod;

    private static String reportConfigPath;
    private static Properties mProperties = new Properties();

    public static final String maersk_local_host_url = "maersk_local_host_url";
    public static final String maersk_cdt_host_url = "maersk_cdt_host_url";
    public static final String maersk_pre_prod_host_url = "maersk_pre_prod_host_url";
    public static final String maersk_prod_host_url = "maersk_prod_host_url";

    public static final String sealand_local_host_url = "sealand_local_host_url";
    public static final String sealand_cdt_host_url = "sealand_cdt_host_url";
    public static final String sealand_pre_prod_host_url = "sealand_pre_prod_host_url";
    public static final String sealand_prod_host_url = "sealand_prod_host_url";

    public static final String safmarine_local_host_url = "safmarine_local_host_url";
    public static final String safmarine_cdt_host_url = "safmarine_cdt_host_url";
    public static final String safmarine_pre_prod_host_url = "safmarine_pre_prod_host_url";
    public static final String safmarine_prod_host_url = "safmarine_prod_host_url";

    public static final String UIAUTOMATION_BASE_DIR = "user.dir";
    public static final String CONFIG_FILE_PATH = System.getProperty(UIAUTOMATION_BASE_DIR);
    public static final String FILE_SEP = File.separator;

    public ConfigProperties() {
        try {

            String fileName = "config.properties";

            if (CONFIG_FILE_PATH != null) {
                fileName = CONFIG_FILE_PATH + FILE_SEP + "src" + FILE_SEP + "main" + FILE_SEP + "resources" + FILE_SEP + fileName;

            }
            mProperties.load(new FileReader(fileName));

            maersk_host_url_local = mProperties.getProperty(maersk_local_host_url);
            maersk_host_url_cdt = mProperties.getProperty(maersk_cdt_host_url);
            maersk_host_url_pre_prod = mProperties.getProperty(maersk_pre_prod_host_url);
            maersk_host_url_prod = mProperties.getProperty(maersk_prod_host_url);

            sealand_host_url_local = mProperties.getProperty(sealand_local_host_url);
            sealand_host_url_cdt = mProperties.getProperty(sealand_cdt_host_url);
            sealand_host_url_pre_prod = mProperties.getProperty(sealand_pre_prod_host_url);
            sealand_host_url_prod = mProperties.getProperty(sealand_prod_host_url);

            safmarine_host_url_local = mProperties.getProperty(safmarine_local_host_url);
            safmarine_host_url_cdt = mProperties.getProperty(safmarine_cdt_host_url);
            safmarine_host_url_pre_prod = mProperties.getProperty(safmarine_pre_prod_host_url);
            safmarine_host_url_prod = mProperties.getProperty(safmarine_prod_host_url);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getHostUrl(String env, String brand) {
        if (env.equalsIgnoreCase("LOCAL")) {
            if (brand.equalsIgnoreCase("MAERSK")) {
                return maersk_host_url_local;
            } else if (brand.equalsIgnoreCase("SEALAND")) {
                return sealand_host_url_local;
            } else if (brand.equalsIgnoreCase("SAFMARINE")) {
                return safmarine_host_url_local;
            }

        }else if (env.equalsIgnoreCase("CDT")) {
            if (brand.equalsIgnoreCase("MAERSK")) {
                return maersk_host_url_cdt;
            } else if (brand.equalsIgnoreCase("SEALAND")) {
                return sealand_host_url_cdt;
            } else if (brand.equalsIgnoreCase("SAFMARINE")) {
                return safmarine_host_url_cdt;
            }

        } else if (env.equalsIgnoreCase("PRE_PRODUCTION")) {
            if (brand.equalsIgnoreCase("MAERSK")) {
                return maersk_host_url_pre_prod;
            } else if (brand.equalsIgnoreCase("SEALAND")) {
                return sealand_host_url_pre_prod;
            } else if (brand.equalsIgnoreCase("SAFMARINE")) {
                return safmarine_host_url_pre_prod;
            }

        } else if (env.equalsIgnoreCase("PRODUCTION")) {
        	if (brand.equalsIgnoreCase("MAERSK")) {
                return maersk_host_url_prod;
            } else if (brand.equalsIgnoreCase("SEALAND")) {
                return sealand_host_url_prod;
            } else if (brand.equalsIgnoreCase("SAFMARINE")) {
            	return safmarine_host_url_prod;
            }
            return env;
        }
        return env;
    }

    public static String getreportConfigPath() {
        return reportConfigPath;
    }


    public String getProperty(String key) {
        return mProperties.getProperty(key);
    }
}