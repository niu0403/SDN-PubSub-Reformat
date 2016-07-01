package edu.bupt.wangfu.info.msg.device;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/*import org.apache.servicemix.wsn.router.router.WsnGlobleUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by root on 15-10-5.
 *//*
public class Controller {
	public String url;

	private Map<String, Switch> switchMap = new ConcurrentHashMap<String, Switch>();

	public Controller(String controllerAddr) {
		this.url = controllerAddr;
	}

	public boolean isAlive() {
		return true;
	}

	public Map<String, Switch> getSwitchMap() {
		return switchMap;
	}

	public void setSwitchMap(Map<String, Switch> switchMap) {
		this.switchMap = switchMap;
	}

//	public void reflashSwitchMap() {
//
//		switchMap = WsnGlobleUtil.getRealtimeSwitchs(this);
//
//	}

}
*/


/**
 * Created by root on 15-10-5.
 */
public class Controller {
	public String url;


	//all switches in the group
	private Map<String, Switch> switchMap = new ConcurrentHashMap<>();


	private Switch repSwitch;


	//switchs connected to other groups, cross-group route calc need
	private Map<String, Switch> boardSwitch = new ConcurrentHashMap<>();

	private List<String> topics = new ArrayList<>();


	public Controller(String controllerAddr) {
		this.url = controllerAddr;
		if (!controllerAddr.startsWith("http://"))
			this.url = "http://" + controllerAddr;
	}

	public Switch getRepSwitch() {
		return repSwitch;
	}

	public void setRepSwitch(Switch repSwitch) {
		this.repSwitch = repSwitch;
	}

	public boolean isAlive() {
		return true;
	}

	public List<String> getTopics() {
		return topics;
	}

	public void setTopics(List<String> topics) {
		this.topics = topics;
	}

	public Map<String, Switch> getHeadSwitch() {
		return boardSwitch;
	}

	public void setHeadSwitch(Map<String, Switch> headSwitch) {
		this.boardSwitch = headSwitch;
	}

	public Map<String, Switch> getSwitchMap() {
		return switchMap;
	}

	public void setSwitchMap(Map<String, Switch> switchMap) {
		this.switchMap = switchMap;
	}

	/*public void reflashSwitchMap() {
		switchMap = WsnGlobleUtil.getRealtimeSwitchs2(this);
	}*/

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}