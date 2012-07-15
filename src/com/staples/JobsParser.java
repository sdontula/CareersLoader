package com.staples;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class JobsParser extends DefaultHandler{
	
	private Boolean jobNumberFlag=false;
	private Boolean managerFirstFlag=false;
	private Boolean managerLastFlag=false;
	private Boolean recruiterFirstFlag=false;
	private Boolean recruiterLastFlag=false;
	private Boolean contactEmailFlag=false;
	private Boolean postingDateFlag=false;
	private Boolean empStatusFlag=false;
	private Boolean bonusAvailFlag=false;
	private Boolean bonusAmtFlag=false;
	private Boolean jobLevelFlag=false;
	private Boolean jobScheduleFlag=false;
	private Boolean jobShiftFlag=false;
	private Boolean jobTypeFlag=false;
	private Boolean overTimeFlag=false;
	private Boolean willTravelFlag=false;
	private Boolean jobFieldFlag=false;
	private Boolean jobFieldSubFlag=false;
	private Boolean organizationFlag=false;
	private Boolean level1Flag=false;
	private Boolean level2Flag=false;
	private Boolean level3Flag=false;
	private Boolean level4Flag=false;
	private Boolean level5Flag=false;
	private Boolean level5ZipFlag=false;
	private Boolean otherLevel1Flag=false;
	private Boolean otherLevel2Flag=false;
	private Boolean otherLevel3Flag=false;
	private Boolean otherLevel4Flag=false;
	private Boolean otherLevel5Flag=false;
	private Boolean otherLevel5ZipFlag=false;	
	private Boolean titleEngFlag=false;
	private Boolean titleFrFlag=false;
	private Boolean descEngFlag=false;
	private Boolean descFrFlag=false;
	private Boolean qualificationEngFlag=false;
	private Boolean qualificationFrFlag=false;
	private Boolean applyUrlFlag=false;
	private Boolean referralUrlFlag=false;
	
	private String jobNumber;
	private String managerFirst;
	private String managerLast;
	private String recruiterFirst;
	private String recruiterLast;
	private String contactEmail;
	private String postingDate;
	private String empStatus;
	private String bonusAvail;
	private String bonusAmt;
	private String jobLevel;
	private String jobSchedule;
	private String jobShift;
	private String jobType;
	private String overTime;
	private String willTravel;
	private String jobField;
	private String jobFieldSub;
	private String organization;
	private String level1;
	private String level2;
	private String level3;
	private String level4;
	private String level5;
	private String level5Zip;
	private String otherLevel1;
	private String otherLevel2;
	private String otherLevel3;
	private String otherLevel4;
	private String otherLevel5;
	private String otherLevel5Zip;	
	private String titleEng;
	private String titleFr;
	private String descEng;
	private String descFr;
	private String qualificationEng;
	private String qualificationFr;
	private String applyUrl;
	private String referralUrl;	
	
	private String blank = "";
	private ArrayList<JobPosting> jobs = new ArrayList<JobPosting>();
	private JobPosting job;
	private int jobTotal=0;
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equalsIgnoreCase("RECORD")){
			jobNumber = blank;
			managerFirst = blank;
			managerLast = blank;
			recruiterFirst = blank;
			recruiterLast = blank;
			contactEmail = blank;
			postingDate = blank;
			empStatus = blank;
			bonusAvail = blank;
			bonusAmt = blank;
			jobLevel = blank;
			jobSchedule = blank;
			jobShift = blank;
			jobType = blank;
			overTime = blank;
			willTravel=blank;
			jobField=blank;
			jobFieldSub=blank;
			organization=blank;
			level1=blank;
			level2=blank;
			level3=blank;
			level4=blank;
			level5=blank;
			level5Zip=blank;
			otherLevel1=blank;
			otherLevel2=blank;
			otherLevel3=blank;
			otherLevel4=blank;
			otherLevel5=blank;
			otherLevel5Zip=blank;
			titleEng=blank;
			titleFr=blank;
			descEng=blank;
			descFr=blank;
			qualificationEng=blank;
			applyUrl=blank;
			referralUrl=blank;			
		}
		
		if (qName.equalsIgnoreCase("FIELD")) {
			String name = attributes.getValue(0);
			if(name.equalsIgnoreCase("ContestNumber")){
				jobNumberFlag=true;
			}
			if(name.equalsIgnoreCase("HiringManagerFirstName")){
				managerFirstFlag=true;
			}
			if(name.equalsIgnoreCase("HiringManagerLastName")){
				managerLastFlag=true;
			}
			if(name.equalsIgnoreCase("RecruiterFirstName")){
				recruiterFirstFlag=true;
			}
			if(name.equalsIgnoreCase("RecruiterLastName")){
				recruiterLastFlag=true;
			}
			if(name.equalsIgnoreCase("ContactEmailInternal")){
				contactEmailFlag=true;
			}
			if(name.equalsIgnoreCase("PostingDate")){
				postingDateFlag=true;
			}
			if(name.equalsIgnoreCase("EmployeeStatus")){
				empStatusFlag=true;
			}
			if(name.equalsIgnoreCase("InternalBonus")){
				bonusAvailFlag=true;
			}
			if(name.equalsIgnoreCase("InternalBonusAmount")){
				bonusAmtFlag=true;
			}
			if(name.equalsIgnoreCase("JobLevel")){
				jobLevelFlag=true;
			}
			if(name.equalsIgnoreCase("JobSchedule")){
				jobScheduleFlag=true;
			}			
			if(name.equalsIgnoreCase("JobShift")){
				jobShiftFlag=true;
			}			
			if(name.equalsIgnoreCase("JobType")){
				jobTypeFlag=true;
			}			
			if(name.equalsIgnoreCase("OvertimeStatus")){
				overTimeFlag=true;
			}
			if(name.equalsIgnoreCase("WillTravel")){
				willTravelFlag=true;
			}			
			if(name.equalsIgnoreCase("JobField")){
				jobFieldFlag=true;
			}			
			if(name.equalsIgnoreCase("JobFieldSubCategory")){
				jobFieldSubFlag=true;
			}			
			if(name.equalsIgnoreCase("Organization")){
				organizationFlag=true;
			}			
			if(name.equalsIgnoreCase("PrimaryLocationLevel1")){
				level1Flag=true;
			}			
			if(name.equalsIgnoreCase("PrimaryLocationLevel2")){
				level2Flag=true;
			}			
			if(name.equalsIgnoreCase("PrimaryLocationLevel3")){
				level3Flag=true;
			}			
			if(name.equalsIgnoreCase("PrimaryLocationLevel4")){
				level4Flag=true;
			}			
			if(name.equalsIgnoreCase("PrimaryLocationLevel5")){
				level5Flag=true;
			}			
			if(name.equalsIgnoreCase("PrimaryLocationLevel5ZipCode")){
				level5ZipFlag=true;
			}			
			if(name.equalsIgnoreCase("OtherLocationsLevel1")){
				otherLevel1Flag=true;
			}			
			if(name.equalsIgnoreCase("OtherLocationsLevel2")){
				otherLevel2Flag=true;
			}			
			if(name.equalsIgnoreCase("OtherLocationsLevel3")){
				otherLevel3Flag=true;
			}			
			if(name.equalsIgnoreCase("OtherLocationsLevel4")){
				otherLevel4Flag=true;
			}						
			if(name.equalsIgnoreCase("OtherLocationsLevel5")){
				otherLevel5Flag=true;
			}
			if(name.equalsIgnoreCase("OtherLocationLevel5ZipCode")){
				otherLevel5ZipFlag=true;
			}
			if(name.equalsIgnoreCase("TitleEN")){
				titleEngFlag=true;
			}
			if(name.equalsIgnoreCase("TitleFR")){
				titleFrFlag=true;
			}
			if(name.equalsIgnoreCase("DescriptionInternalEN")){
				descEngFlag=true;
			}
			if(name.equalsIgnoreCase("DescriptionInternalFR")){
				descFrFlag=true;
			}
			if(name.equalsIgnoreCase("InternalQualificationEN")){
				qualificationEngFlag=true;
			}
			if(name.equalsIgnoreCase("InternalQualificationFR")){
				qualificationFrFlag=true;
			}
			if(name.equalsIgnoreCase("ApplyURL")){
				applyUrlFlag=true;
			}
			if(name.equalsIgnoreCase("ReferralURL")){
				referralUrlFlag=true;
			}			
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("RECORD")){			
			job = new JobPosting();
			job.setJobNumber(jobNumber);
			job.setManagerFirst(managerFirst);
			job.setManagerLast(managerLast);
			job.setRecruiterFirst(recruiterFirst);
			job.setRecruiterLast(recruiterLast);
			job.setContactEmail(contactEmail);
			job.setPostingDate(postingDate);
			job.setEmpStatus(empStatus);
			job.setBonusAvail(bonusAvail);
			job.setBonusAmt(bonusAmt);
			job.setJobLevel(jobLevel);
			job.setJobSchedule(jobSchedule);
			job.setJobShift(jobShift);
			job.setJobType(jobType);
			job.setOverTime(overTime);
			job.setWillTravel(willTravel);
			job.setJobField(jobField);
			job.setJobFieldSub(jobFieldSub);
			job.setOrganization(organization);
			job.setLevel1(level1);
			job.setLevel2(level2);
			job.setLevel3(level3);
			job.setLevel4(level4);
			job.setLevel5(level5);
			job.setLevel5Zip(level5Zip);
			job.setOtherLevel1(otherLevel1);
			job.setOtherLevel2(otherLevel2);
			job.setOtherLevel3(otherLevel3);
			job.setOtherLevel4(otherLevel4);
			job.setOtherLevel5(otherLevel5);
			job.setOtherLevel5Zip(otherLevel5Zip);
			job.setTitleEng(titleEng);
			job.setTitleFr(titleFr);
			job.setDescEng(descEng);
			job.setDescFr(descFr);
			job.setQualificationEng(qualificationEng);
			job.setQualificationFr(qualificationFr);
			job.setApplyUrl(applyUrl);
			job.setReferralUrl(referralUrl);					
			jobs.add(job);
			//System.out.println("Jobs Total " + ++jobTotal);
		}
		if(qName.equalsIgnoreCase("soapenv:Envelope")){	
			new DBLoader().loadDataDB(jobs);
/*			for(JobPosting job : jobs){
				System.out.println(job.toString());
			}
			System.out.println("Jobs Total " + jobTotal);
*/		}		
	}

	public void characters(char ch[], int start, int length) throws SAXException {

		if (jobNumberFlag) {
			//System.out.println("Contest Number : " + new String(ch, start, length));
			jobNumber= new String(ch, start, length);
			jobNumberFlag = false;
		}

		if (managerFirstFlag) {
			//System.out.println("Manager First Name : " + new String(ch, start, length));
			managerFirst= new String(ch, start, length);
			managerFirstFlag = false;
		}

		if (managerLastFlag) {
			//System.out.println("Manager Last Name : " + new String(ch, start, length));
			managerLast= new String(ch, start, length);
			managerLastFlag = false;
		}

		if (recruiterFirstFlag) {
			//System.out.println("recruiter First Name : " + new String(ch, start, length));
			recruiterFirst= new String(ch, start, length);
			recruiterFirstFlag = false;
		}
		
		if (recruiterLastFlag) {
			//System.out.println("recruiter Last Name : " + new String(ch, start, length));
			recruiterLast= new String(ch, start, length);
			recruiterLastFlag = false;
		}
		
		if (contactEmailFlag) {
			//System.out.println("Contact Email: " + new String(ch, start, length));
			contactEmail= new String(ch, start, length);
			contactEmailFlag = false;
		}		
		
		if (postingDateFlag) {
			//System.out.println("Posting Date : " + new String(ch, start, length));
			postingDate= new String(ch, start, length);
			postingDateFlag = false;
		}		
		
		if (empStatusFlag) {
			//System.out.println("Employee Status : " + new String(ch, start, length));
			empStatus= new String(ch, start, length);
			empStatusFlag = false;
		}		
		
		if (bonusAvailFlag) {
			//System.out.println("bonus Avail : " + new String(ch, start, length));
			bonusAvail= new String(ch, start, length);
			bonusAvailFlag = false;
		}		
		
		if (bonusAmtFlag) {
			//System.out.println("Bonus Amount : " + new String(ch, start, length));
			bonusAmt= new String(ch, start, length);
			bonusAmtFlag = false;
		}		
		
		if (jobLevelFlag) {
			//System.out.println("Job Level : " + new String(ch, start, length));
			jobLevel= new String(ch, start, length);
			jobLevelFlag = false;
		}		
		
		if (jobScheduleFlag) {
			//System.out.println("Job Schedule : " + new String(ch, start, length));
			jobSchedule= new String(ch, start, length);
			jobScheduleFlag = false;
		}		
		
		if (jobShiftFlag) {
			//System.out.println("Job Shift : " + new String(ch, start, length));
			jobShift= new String(ch, start, length);
			jobShiftFlag = false;
		}		
		
		if (jobTypeFlag) {
			//System.out.println("Job Type : " + new String(ch, start, length));
			jobType= new String(ch, start, length);
			jobTypeFlag = false;
		}		
		
		if (overTimeFlag) {
			//System.out.println("Over Time Status : " + new String(ch, start, length));
			overTime= new String(ch, start, length);
			overTimeFlag = false;
		}		
		
		if (willTravelFlag) {
			//System.out.println("Will Travel : " + new String(ch, start, length));
			willTravel= new String(ch, start, length);
			willTravelFlag = false;
		}		
		
		if (jobFieldFlag) {
			//System.out.println("Job Field : " + new String(ch, start, length));
			jobField= new String(ch, start, length);
			jobFieldFlag = false;
		}		
		
		if (jobFieldSubFlag) {
			//System.out.println("Job Field Sub Category : " + new String(ch, start, length));
			jobFieldSub= new String(ch, start, length);
			jobFieldSubFlag = false;
		}		
		
		if (organizationFlag) {
			//System.out.println("Organization : " + new String(ch, start, length));
			organization= new String(ch, start, length);
			organizationFlag = false;
		}		
		
		if (level1Flag) {
			//System.out.println("Primary Location Level1 : " + new String(ch, start, length));
			level1= new String(ch, start, length);
			level1Flag = false;
		}		
		
		if (level2Flag) {
			//System.out.println("Level2 : " + new String(ch, start, length));
			level2= new String(ch, start, length);
			level2Flag = false;
		}		
		
		if (level3Flag) {
			//System.out.println("Level3 : " + new String(ch, start, length));
			level3= new String(ch, start, length);
			level3Flag = false;
		}		
		
		if (level4Flag) {
			//System.out.println("Level4 : " + new String(ch, start, length));
			level4= new String(ch, start, length);
			level4Flag = false;
		}		
		
		if (level5Flag) {
			//System.out.println("Level5 : " + new String(ch, start, length));
			level5= new String(ch, start, length);
			level5Flag = false;
		}		
		
		if (level5ZipFlag) {
			//System.out.println("Level5 Zip : " + new String(ch, start, length));
			level5Zip= new String(ch, start, length);
			level5ZipFlag = false;
		}		
		
		if (otherLevel1Flag) {
			//System.out.println("Other Level1 : " + new String(ch, start, length));
			otherLevel1= new String(ch, start, length);
			otherLevel1Flag = false;
		}		
		
		if (otherLevel2Flag) {
			//System.out.println("Other Level2 : " + new String(ch, start, length));
			otherLevel2= new String(ch, start, length);
			otherLevel2Flag = false;
		}		
		
		if (otherLevel3Flag) {
			//System.out.println("Other Level3 : " + new String(ch, start, length));
			otherLevel3= new String(ch, start, length);
			otherLevel3Flag = false;
		}		
		
		if (otherLevel4Flag) {
			//System.out.println("Other Level4 : " + new String(ch, start, length));
			otherLevel4= new String(ch, start, length);
			otherLevel4Flag = false;
		}		
		
		if (otherLevel5Flag) {
			//System.out.println("Other Level5 : " + new String(ch, start, length));
			otherLevel5= new String(ch, start, length);
			otherLevel5Flag = false;
		}		
		
		if (otherLevel5ZipFlag) {
			//System.out.println("Other Level5 Zip : " + new String(ch, start, length));
			otherLevel5Zip= new String(ch, start, length);
			otherLevel5ZipFlag = false;
		}		
		
		if (titleEngFlag) {
			//System.out.println("Title Eng : " + new String(ch, start, length));
			titleEng= new String(ch, start, length);
			titleEngFlag = false;
		}		
		
		if (titleFrFlag) {
			//System.out.println("Title Fr : " + new String(ch, start, length));
			titleFr= new String(ch, start, length);
			titleFrFlag = false;
		}		
		
		if (descEngFlag) {
			//System.out.println("Description Eng : " + new String(ch, start, length));
			descEng= new String(ch, start, length);
			descEngFlag = false;
		}		
		
		if (descFrFlag) {
			//System.out.println("Description Fr : " + new String(ch, start, length));
			descFr= new String(ch, start, length);
			descFrFlag = false;
		}		
		
		if (qualificationEngFlag) {
			//System.out.println("Qualification Eng : " + new String(ch, start, length));
			qualificationEng= new String(ch, start, length);
			qualificationEngFlag = false;
		}		
		
		if (qualificationFrFlag) {
			//System.out.println("Qualification Fr : " + new String(ch, start, length));
			qualificationFr= new String(ch, start, length);
			qualificationFrFlag = false;
		}		
		
		if (applyUrlFlag) {
			//System.out.println("Apply URL : " + new String(ch, start, length));
			applyUrl= new String(ch, start, length);
			applyUrlFlag = false;
		}		
		
		if (referralUrlFlag) {
			//System.out.println("Referral URL : " + new String(ch, start, length));
			referralUrl= new String(ch, start, length);
			referralUrlFlag = false;
		}		
	}
}
