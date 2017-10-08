package configurations;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DockerPortMap {
	
	public static final Map<String, String> Ports;
	static {
	    final Map<String, String> ports = new HashMap<String, String>();
	    ports.put("dataPersistence","8183");
	    ports.put("socialStreams","3007");
	    ports.put("insightsService","3006");
	    
	    Ports = Collections.unmodifiableMap(ports);
	}
}
