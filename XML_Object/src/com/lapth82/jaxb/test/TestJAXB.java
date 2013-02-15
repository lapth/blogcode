package com.lapth82.jaxb.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.lapth82.jaxb.bean.Group;

public class TestJAXB {

	public static void main(String[] args) throws Exception {
		JAXBContext jc = JAXBContext.newInstance(Group.class);
		
		Unmarshaller unMarshaller = jc.createUnmarshaller();
		Group group = (Group) unMarshaller.unmarshal(new File("xml/sample.xml"));
		
		group.getLstUser().get(1).setUserName("My Name");
		group.getLstUser().get(1).setPassword("My password");
		
		Marshaller marshaller = jc.createMarshaller();
		
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		marshaller.marshal(group, System.out);
	}
}
