package edu.bupt.wangfu;

import edu.bupt.wangfu.mgr.base.Configuration;
import edu.bupt.wangfu.mgr.base.RtMgr;
import edu.bupt.wangfu.webservice.WsnProcessImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by LCW on 2016-6-19.
 */
public class Start {
	public static void main(String[] args) {
		Configuration.configure();//这里进行配置，配置文件的内容写到SysInfo里
		System.out.println("init started");

		new Thread(new mgrInstance()).start();

		WsnProcessImpl wsnprocess = new WsnProcessImpl();
		wsnprocess.init();//在这里启动第一个RtMgr，负责维护拓扑和计算路由
		Endpoint.publish(args[0], wsnprocess);
	}

	private static class mgrInstance implements Runnable {
		public void run() {
			RtMgr.getInstance();
			System.out.println("init finished");
		}
	}
}
