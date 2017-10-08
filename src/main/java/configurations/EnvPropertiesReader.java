package configurations;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class EnvPropertiesReader {

	private static EnvPropertiesReader instance;
	
	private static String	environment;

	public static String getEnvironment() {
		return environment;
	}

	public static void setEnvironment(String environment) {
		EnvPropertiesReader.environment = environment;
	}

	public static EnvPropertiesReader getInstance(){
		if(instance==null){
			instance=new EnvPropertiesReader();

		}
			
		return instance;
	}
	
	private   EnvPropertiesReader(){
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("env.properties");
			prop.load(input);

			//should I define my custome exceptions and handle them manually or not ?
			setEnvironment(prop.getProperty("environment"));

		} catch (IOException ex) {
			ex.printStackTrace();
			
		} finally {
			if (input != null) {
				try {
					input.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
	}
}
