package configurations;

public class RegisteredIPs {
	
	private static 	final	String env	=	RegisteredIPs.loadIPs();
	public	static 	final	String account_management_ip		=	RegisteredIPs.getIp("account_management_ip");
	public 	static	final  	String socialStream_service_ip		=	RegisteredIPs.getIp("socialStream_service_ip");
	public 	static  final 	String monitoring_service_ip		=	RegisteredIPs.getIp("monitoring_service_ip"); 
	public 	static  final	String customer_interaction_ip 		=	RegisteredIPs.getIp("customer_interaction_ip");
	public 	static  final 	String social_posting_ip 			=	RegisteredIPs.getIp("social_posting_ip");
	public 	static  final 	String user_engagement_service_ip	=	RegisteredIPs.getIp("user_engagement_service_ip");
	public 	static  final 	String user_can_do					=	RegisteredIPs.getIp("user_can_do");
	

	public static String loadIPs(){
		
		return	EnvPropertiesReader.getInstance().getEnvironment();		
	}
	
	public static String getIp(String serviceName){

		if(RegisteredIPs.env.equals("docker")){
		
			return DockerIpMap.IPs.get(serviceName);
		}else if(RegisteredIPs.env.equals("local")){
			
			return LocalIpMap.IPs.get(serviceName);
		}
		
		return null;
	}
	
	
}
