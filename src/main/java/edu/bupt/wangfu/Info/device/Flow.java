package edu.bupt.wangfu.info.device;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Flow {
	public int flow_id;
	public int table_id;

	public JSONObject jsonContent;
	public String xmlContent;

	public void setXmlContent(String xmlContent, int flowcount, String tableId) {
		//这里是测试，不想在这里写太多xml格式的东西
		File file = new File("Template.txt");
		BufferedReader reader;
		String s = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			s = reader.readLine();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		s = s.replace("%FLOWNAME%", "flowmod" + flowcount++);
		s = s.replace("%ID%", String.valueOf(flowcount));
		s = s.replace("%TABLE_ID%", "0");

		this.xmlContent = xmlContent;
	}
}
