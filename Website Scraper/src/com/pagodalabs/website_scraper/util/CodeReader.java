package com.pagodalabs.website_scraper.util;

import com.pagodalabs.website_scraper.dao.JobDAO;
import com.pagodalabs.website_scraper.dao.impl.JobDAOImpl;
import com.pagodalabs.website_scraper.entity.Job;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class CodeReader {
    
    private static URL url;
    public static String read(String urlReader) throws IOException{
        url = new URL(urlReader);
        URLConnection urlConnection = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String line = "";
        String content = "";
        while((line=reader.readLine())!=null){
            content+=line;
        }
        return content;
    }
    
    public static void setToObject(String jobTitle, String companyName, String deadline, String link){
        JobDAO dao = new JobDAOImpl("Website_ScraperPU");
        Job job = new Job();
        job.setJobTitle(jobTitle);
        job.setCompanyName(companyName);
        job.setDeadline(deadline);
        job.setLink(link);
        dao.insert(job);
        job.toString();
        
    }
}
