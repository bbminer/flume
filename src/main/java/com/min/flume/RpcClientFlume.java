package com.min.flume;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.api.RpcClient;
import org.apache.flume.api.RpcClientFactory;
import org.apache.flume.event.EventBuilder;

public class RpcClientFlume {
	private RpcClient rpcClient;
	@SuppressWarnings("unused")
	private int port;
	@SuppressWarnings("unused")
	private String hostName;

	// 创建连接
	public RpcClientFlume(String hostName, int port) {
		// TODO Auto-generated constructor stub
		this.hostName = hostName;
		this.port = port;
		// 客户端
		this.rpcClient = RpcClientFactory.getDefaultInstance(hostName, port);
	}

	// 发送event
	public void sendEvent(String body) {
		Event event = EventBuilder.withBody(body, Charset.forName("utf-8"));
		try {
			rpcClient.append(event);
		} catch (EventDeliveryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 发送header event
	public void sendHeaderEvent(String body, String topic) {
		Event event = EventBuilder.withBody(body, Charset.forName("utf-8"));
		Map<String, String> map = new HashMap<String, String>();
		map.put("topic", topic);
		event.setHeaders(map);
		try {
			rpcClient.append(event);
		} catch (EventDeliveryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		RpcClientFlume cFlume = new RpcClientFlume("centos131", 44444);
		//cFlume.sendEvent("asdfgh");
		//cFlume.sendEvent("zxcvb");
		
		cFlume.sendHeaderEvent("qwert", "t1");
		cFlume.sendHeaderEvent("poiuy", "t1");
		cFlume.sendHeaderEvent("mnbv", "t2");
		cFlume.sendHeaderEvent("lkjh", "t2");
		
		cFlume.rpcClient.close();
	}
}
