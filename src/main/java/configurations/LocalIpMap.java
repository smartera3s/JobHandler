package configurations;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LocalIpMap {
	
	public static final Map<String, String> IPs;
	static {
	    final Map<String, String> ips = new HashMap<String, String>();
	    ips.put("baseUrl","http://0.0.0.0");
	    ips.put("account_management_ip","http://localhost:3000");
	    ips.put("socialStream_service_ip","http://localhost:3001");
	    ips.put("monitoring_service_ip","http://MonitoringService.services.socialhub.markite.ch");
	    ips.put("customer_interaction_ip","http://0.0.0.0:3002");
	    ips.put("social_posting_ip","http://localhost:3011");
	    ips.put("user_engagement_service_ip","http://localhost:4001");
	    ips.put("user_can_do","/ability/can");
	    IPs = Collections.unmodifiableMap(ips);
	}

}
