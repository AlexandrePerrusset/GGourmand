package com.infotel.gg.ES;

import java.net.InetAddress;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.stereotype.Component;

@Component
public class EsClientProvider {

	private static Logger log = LogManager.getLogger(EsClientProvider.class);
	
	private static final String CLUSTER_NAME = "IronMan";
	public static final String INDEX_NAME = "bat";

	private Client client;

	@PostConstruct
	public void init() throws Exception {
		try {
			Settings settings = Settings.builder()
					.put("cluster.name", CLUSTER_NAME)
					.put("client.transport.sniff", true)
					.build();

			InetSocketTransportAddress addr = 
					new InetSocketTransportAddress(InetAddress.getByName("172.16.2.31"), 9300);

			client = new PreBuiltTransportClient(settings)
			        		.addTransportAddress(addr);			
			
		} catch (Exception e) {
			log.error("Echec connexion sur ES", e);
		}		
	}
	
	@PreDestroy
	public void destroy() throws Exception {
		if (client != null) {
			client.close();
		}
	}
	
	public Client getClient() {
		return client;
	}
	
}
