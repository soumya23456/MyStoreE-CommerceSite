//package Grid;
//
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeOptions;
//
//public class OptionsManager {
//
//	    //Get Chrome Options
//	    public static ChromeOptions getChromeOptions() {
//	        ChromeOptions options = new ChromeOptions();
//	        options.addArguments("--start-maximized");
////	        options.addArguments("--ignore-certificate-errors");
////	        options.addArguments("--disable-popup-blocking");
//	        //options.addArguments("--incognito");
//	        return options;
//	    }
//	    
//	    //Get edge Options
//	    public static EdgeOptions getEdgeOptions() {
//	    	EdgeOptions options = new EdgeOptions();
//	        options.addArguments("--start-maximized");
////	        options.addArguments("--ignore-certificate-errors");
////	        options.addArguments("--disable-popup-blocking");
//	        //options.addArguments("--incognito");
//	        return options;
//	    }
//
//	    //Get Firefox Options
////	    public static FirefoxOptions getFirefoxOptions () {
////	        FirefoxOptions options = new FirefoxOptions();
////	        FirefoxProfile profile = new FirefoxProfile();
//	        //Accept Untrusted Certificates
////	        profile.setAcceptUntrustedCertificates(true);
////	        profile.setAssumeUntrustedCertificateIssuer(false);
//	        //Use No Proxy Settings
////	        profile.setPreference("network.proxy.type", 0);
//	        //Set Firefox profile to capabilities
////	        options.setCapability(FirefoxDriver.PROFILE , profile);
////	        return options;
////	    }
//	}
//
