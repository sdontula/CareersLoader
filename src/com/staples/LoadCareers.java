package com.staples;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.io.IOUtils;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class LoadCareers {

	public static void main(String[] args) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setNamespaceAware(true);
			SAXParser saxParser = factory.newSAXParser();
			XMLReader xmlReader = saxParser.getXMLReader();
			xmlReader.setContentHandler(new JobsParser());
			//xmlReader.parse("c:\\file.xml");
			//xmlReader.parse("C:\\Documents and Settings\\DonSa001\\My Documents\\Documents\\Staples\\Carrers\\ExternalRequisition_US_20120627_094329.xml");			
			
			File file = new File("ExternalRequisition_US_20120627_094329.xml");
			//File file = new File("C:\\Documents and Settings\\DonSa001\\My Documents\\Documents\\Staples\\Carrers\\Document.txt");
			InputStream inputStream= new FileInputStream(file);			
			
			StringWriter writer = new StringWriter();
			IOUtils.copy(inputStream, writer, "UTF-8");
			String theString = writer.toString();
			
			theString = theString.replace("</field>","]]></field>");
	        theString = theString.replace("<field name=\"ContestNumber\">","<field name=\"ContestNumber\"><![CDATA["); 
	        theString = theString.replace("<field name=\"HiringManagerFirstName\">","<field name=\"HiringManagerFirstName\"><![CDATA[");
	        theString = theString.replace("<field name=\"HiringManagerLastName\">","<field name=\"HiringManagerLastName\"><![CDATA[");
	        theString = theString.replace("<field name=\"RecruiterFirstName\">","<field name=\"RecruiterFirstName\"><![CDATA[");
	        theString = theString.replace("<field name=\"RecruiterLastName\">","<field name=\"RecruiterLastName\"><![CDATA[");
	        theString = theString.replace("<field name=\"ContactEmailInternal\">","<field name=\"ContactEmailInternal\"><![CDATA[");
	        theString = theString.replace("<field name=\"PostingDate\">","<field name=\"PostingDate\"><![CDATA[");
	        theString = theString.replace("<field name=\"EmployeeStatus\">","<field name=\"EmployeeStatus\"><![CDATA[");
	        theString = theString.replace("<field name=\"InternalBonus\">","<field name=\"InternalBonus\"><![CDATA[");
	        theString = theString.replace("<field name=\"InternalBonusAmount\">","<field name=\"InternalBonusAmount\"><![CDATA[");
	        theString = theString.replace("<field name=\"JobLevel\">","<field name=\"JobLevel\"><![CDATA[");
	        theString = theString.replace("<field name=\"JobSchedule\">","<field name=\"JobSchedule\"><![CDATA[");
	        theString = theString.replace("<field name=\"JobShift\">","<field name=\"JobShift\"><![CDATA[");
	        theString = theString.replace("<field name=\"JobType\">","<field name=\"JobType\"><![CDATA[");
	        theString = theString.replace("<field name=\"OvertimeStatus\">","<field name=\"OvertimeStatus\"><![CDATA[");
	        theString = theString.replace("<field name=\"WillTravel\">","<field name=\"WillTravel\"><![CDATA[");
	        theString = theString.replace("<field name=\"JobField\">","<field name=\"JobField\"><![CDATA[");
	        theString = theString.replace("<field name=\"JobFieldSubCategory\">","<field name=\"JobFieldSubCategory\"><![CDATA[");
	        theString = theString.replace("<field name=\"Organization\">","<field name=\"Organization\"><![CDATA[");
	        theString = theString.replace("<field name=\"PrimaryLocationLevel1\">","<field name=\"PrimaryLocationLevel1\"><![CDATA[");
	        theString = theString.replace("<field name=\"PrimaryLocationLevel2\">","<field name=\"PrimaryLocationLevel2\"><![CDATA[");
	        theString = theString.replace("<field name=\"PrimaryLocationLevel3\">","<field name=\"PrimaryLocationLevel3\"><![CDATA[");
	        theString = theString.replace("<field name=\"PrimaryLocationLevel4\">","<field name=\"PrimaryLocationLevel4\"><![CDATA[");
	        theString = theString.replace("<field name=\"PrimaryLocationLevel5\">","<field name=\"PrimaryLocationLevel5\"><![CDATA[");
	        theString = theString.replace("<field name=\"PrimaryLocationLevel5ZipCode\">","<field name=\"PrimaryLocationLevel5ZipCode\"><![CDATA[");
	        theString = theString.replace("<field name=\"OtherLocationsLevel1\">","<field name=\"OtherLocationsLevel1\"><![CDATA[");
	        theString = theString.replace("<field name=\"OtherLocationsLevel2\">","<field name=\"OtherLocationsLevel2\"><![CDATA[");
	        theString = theString.replace("<field name=\"OtherLocationsLevel3\">","<field name=\"OtherLocationsLevel3\"><![CDATA[");
	        theString = theString.replace("<field name=\"OtherLocationsLevel4\">","<field name=\"OtherLocationsLevel4\"><![CDATA[");
	        theString = theString.replace("<field name=\"OtherLocationsLevel5\">","<field name=\"OtherLocationsLevel5\"><![CDATA[");
	        theString = theString.replace("<field name=\"OtherLocationLevel5ZipCode\">","<field name=\"OtherLocationLevel5ZipCode\"><![CDATA[");
	        theString = theString.replace("<field name=\"TitleEN\">","<field name=\"TitleEN\"><![CDATA[");
	        theString = theString.replace("<field name=\"TitleFR\">","<field name=\"TitleFR\"><![CDATA[");
	        theString = theString.replace("<field name=\"DescriptionInternalEN\">","<field name=\"DescriptionInternalEN\"><![CDATA[");
	        theString = theString.replace("<field name=\"DescriptionInternalFR\">","<field name=\"DescriptionInternalFR\"><![CDATA[");
	        theString = theString.replace("<field name=\"InternalQualificationEN\">","<field name=\"InternalQualificationEN\"><![CDATA[");
	        theString = theString.replace("<field name=\"InternalQualificationFR\">","<field name=\"InternalQualificationFR\"><![CDATA[");
	        theString = theString.replace("<field name=\"ApplyURL\">","<field name=\"ApplyURL\"><![CDATA[");
            theString = theString.replace("<field name=\"ReferralURL\">","<field name=\"ReferralURL\"><![CDATA[");

			
			InputStream is = new ByteArrayInputStream(theString.getBytes());// convert String into InputStream
			Reader reader = new InputStreamReader(is, "UTF-8");			
			InputSource source = new InputSource(reader);
			source.setEncoding("UTF-8");
			xmlReader.parse(source);			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
