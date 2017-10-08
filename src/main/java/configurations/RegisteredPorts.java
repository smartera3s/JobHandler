package configurations;

public class RegisteredPorts {
	
	private static 	final	String env					=	RegisteredPorts.loadPorts();
	public	static 	final	String dataPersistence		=	RegisteredPorts.getPort("dataPersistence");
	public 	static	final  	String socialStreams		=	RegisteredPorts.getPort("socialStreams");
	public 	static  final 	String insightsService		=	RegisteredPorts.getPort("insightsService"); 
	

	public static String loadPorts(){
		
		return	EnvPropertiesReader.getInstance().getEnvironment();		
	}
	
	public static String getPort(String serviceName){

		if(RegisteredPorts.env.equals("docker")){
		
			return DockerPortMap.Ports.get(serviceName);
		
		}else{
			
			return "";
		}		
	}
	
}
