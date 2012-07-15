package com.staples;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class DBLoader {

	private Mongo m;
	private DB db;
	private DBCollection jobs;	
	
	private static final String JOBNUMBER = "JobNumber";
	private static final String MANAGERFIRST = "ManagerFirst";
	private static final String MANAGERLAST = "ManagerLast";
	private static final String RECRUITERFIRST = "RecruiterFirst";
	private static final String RECRUITERLAST = "RecruiterLast";
	private static final String INTERNALCONTACTEMAIL = "InternalContactEmail";
	private static final String POSTINGDATE = "PostingDate";
	private static final String EMPLOYEESTATUS = "EmployeeStatus";
	private static final String BONUSAVAILABLE = "BonusAvailable";
	private static final String BONUSAMOUNT = "BonusAmount";
	private static final String JOBLEVEL = "JobLevel";
	private static final String JOBSCHEDULE = "JobSchedule";
	private static final String JOBSHIFT = "JobShift";
	private static final String JOBTYPE = "JobType";
	private static final String OVERTIME = "OverTime";
	private static final String WILLTRAVEL = "WillTravel";
	private static final String JOBFIELD = "JobField";
	private static final String JOBFIELDSUB = "JobFieldSub";
	private static final String ORGANIZATION = "Organization";
	private static final String JOBLEVEL1 = "JobLevel1";
	private static final String JOBLEVEL2 = "JobLevel2";
	private static final String JOBLEVEL3 = "JobLevel3";
	private static final String JOBLEVEL4 = "JobLevel4";
	private static final String JOBLEVEL5 = "JobLevel5";
	private static final String JOBLEVEL5ZIP = "JobLevel5Zip";
	private static final String OTHERLEVEL1 = "OtherLevel1";
	private static final String OTHERLEVEL2 = "OtherLevel2";
	private static final String OTHERLEVEL3 = "OtherLevel3";
	private static final String OTHERLEVEL4 = "OtherLevel4";
	private static final String OTHERLEVEL5 = "OtherLevel5";
	private static final String OTHERLEVEL5ZIP = "OtherLevel5Zip";
	private static final String TITLEENG = "TitleEng";
	private static final String TITLEFR = "TitleFr";
	private static final String DESCENG = "DescEng";
	private static final String DESCFR = "DescFr";
	private static final String QUALIFICATIONENG = "QualificationEng";
	private static final String QUALIFICATIONFR = "QualificationFr";
	private static final String APPLYURL = "ApplyURL";
	private static final String REFERRALURL = "ReferralURL";
	
	
	public static void main(String[] args) {
		new DBLoader().loadData();
	}

	private void preDataLoadTask(){
		initializeDB();
		getCollection();		
		clearData();		
	}
	
	private void loadData() {
		preDataLoadTask();
		mockData();
		showData();
	}
	
	public void loadDataDB(ArrayList<JobPosting> data){
		preDataLoadTask();
		updateDB(data);
		showData();
	}

	private void initializeDB() {
		try {
			m = new Mongo("localhost");
			db = m.getDB("taleo");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}
	}

	private DBCollection getCollection() {
		jobs = db.getCollection("JobPostings");
		return jobs;
	}

	private void listCollections() {
		Set<String> collections = db.getCollectionNames();
		System.out.println("Collection Listing");
		int i = 1;
		for (String s : collections) {
			System.out.println(i++ + " " + s);
		}
	}

	private void clearData() {
		jobs.drop();
	}

	private void mockData() {
		BasicDBObject doc = new BasicDBObject();
		BasicDBObject doc1 = new BasicDBObject();
		BasicDBObject doc2 = new BasicDBObject();
		BasicDBObject doc3 = new BasicDBObject();
		BasicDBObject doc4 = new BasicDBObject();
		BasicDBObject doc5 = new BasicDBObject();

		doc.put("Job Number", "118243");
		doc.put("Job Description", "Programmer Analyst");

		doc1.put("Job Number", "218243");
		doc1.put("Job Description", "Senior Programmer Analyst");

		doc2.put("Job Number", "318243");
		doc2.put("Job Description", "Principal Programmer Analyst");

		doc3.put("Job Number", "418243");
		doc3.put("Job Description", "Consult Developer");

		doc4.put("Job Number", "518243");
		doc4.put("Job Description", "Director IT");

		doc5.put("Job Number", "618243");
		doc5.put("Job Description", "Vice President IT");

		jobs.insert(doc);
		jobs.insert(doc1);
		jobs.insert(doc2);
		jobs.insert(doc3);
		jobs.insert(doc4);
		jobs.insert(doc5);
	}

	private void showData() {
		DBCursor jobIterator = jobs.find();
		while (jobIterator.hasNext()) {
			System.out.println(jobIterator.next());
		}
	}	
	
	private void updateDB(ArrayList<JobPosting> data){		
		BasicDBObject doc;	
		
		for(JobPosting job : data){
			doc =  new BasicDBObject();
			doc.put(JOBNUMBER, job.getJobNumber());
			doc.put(MANAGERFIRST, job.getManagerFirst());
			doc.put(MANAGERLAST, job.getManagerLast());
			doc.put(RECRUITERFIRST, job.getRecruiterFirst());
			doc.put(RECRUITERLAST, job.getRecruiterLast());
			doc.put(INTERNALCONTACTEMAIL, job.getContactEmail());
			doc.put(POSTINGDATE, job.getPostingDate());
			doc.put(EMPLOYEESTATUS, job.getEmpStatus());
			doc.put(BONUSAVAILABLE, job.getBonusAvail());
			doc.put(BONUSAMOUNT, job.getBonusAmt());
			doc.put(JOBLEVEL, job.getJobLevel());
			doc.put(JOBSCHEDULE, job.getJobSchedule());
			doc.put(JOBSHIFT, job.getJobShift());
			doc.put(JOBTYPE, job.getJobType());
			doc.put(OVERTIME, job.getOverTime());
			doc.put(WILLTRAVEL, job.getWillTravel());
			doc.put(JOBFIELD, job.getJobField());
			doc.put(JOBFIELDSUB, job.getJobFieldSub());
			doc.put(ORGANIZATION, job.getOrganization());
			doc.put(JOBLEVEL1, job.getLevel1());
			doc.put(JOBLEVEL2, job.getLevel2());
			doc.put(JOBLEVEL3, job.getLevel3());
			doc.put(JOBLEVEL4, job.getLevel4());
			doc.put(JOBLEVEL5, job.getLevel5());
			doc.put(JOBLEVEL5ZIP, job.getLevel5Zip());
			doc.put(OTHERLEVEL1, job.getOtherLevel1());
			doc.put(OTHERLEVEL2, job.getOtherLevel2());
			doc.put(OTHERLEVEL3, job.getOtherLevel3());
			doc.put(OTHERLEVEL4, job.getOtherLevel4());
			doc.put(OTHERLEVEL5, job.getOtherLevel5());
			doc.put(OTHERLEVEL5ZIP, job.getOtherLevel5Zip());
			doc.put(TITLEENG, job.getTitleEng());
			doc.put(TITLEFR, job.getTitleFr());
			doc.put(DESCENG, job.getDescEng());
			doc.put(DESCFR, job.getDescFr());
			doc.put(QUALIFICATIONENG, job.getQualificationEng());
			doc.put(QUALIFICATIONFR, job.getQualificationFr());
			doc.put(APPLYURL, job.getApplyUrl());
			doc.put(REFERRALURL, job.getReferralUrl());
			jobs.insert(doc);
		}
	}	
}
