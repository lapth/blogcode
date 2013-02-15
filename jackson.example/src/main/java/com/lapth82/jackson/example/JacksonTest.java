package com.lapth82.jackson.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.lapth82.jackson.example.bean.Group;
import com.lapth82.jackson.example.bean.User;

public class JacksonTest {

	private String initJson() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File("./testfile/sample.json")));
		
		String json = br.readLine();
		br.close();
		
		return json;
	}
	
	private List<Group> initGroup() {
		
		// group 1
		User user11 = new User("user 1", "password 1");
		User user12 = new User("user 2", "password 2");
		List<User> lstUser1 = new ArrayList<User>();
		lstUser1.add(user11);
		lstUser1.add(user12);
		
		Group group1 = new Group("group 1", lstUser1);
		
		// group 2
		User user21 = new User("user 3", "password 3");
		User user22 = new User("user 4", "password 4");
		List<User> lstUser2 = new ArrayList<User>();
		lstUser2.add(user21);
		lstUser2.add(user22);
		
		Group group2 = new Group("group 2", lstUser2);

		List<Group> lstGroup = new ArrayList<Group>();
		lstGroup.add(group1);
		lstGroup.add(group2);
		
		return lstGroup;
	}
	
	public String convertToJson(List<Group> lstGroup) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(lstGroup);
		
		return json;
	}
	
	public List<Group> convertToObeject(String json) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		List<Group> lstGroup = 
				mapper.readValue(
						json, 
						new TypeReference<List<Group>>(){}
		);
		
		return lstGroup;
	}
	
	public static void main(String[] args) throws Exception {
		JacksonTest jt = new JacksonTest();
		String json = jt.convertToJson(jt.initGroup());
		
		System.out.println(json);
		
		List<Group> lstGroup = jt.convertToObeject(jt.initJson());
		for (Group group : lstGroup) {
			System.out.print(group + "\n");
		}
	}

}
