package com.pagodalabs.website_scraper;

import com.pagodalabs.commands.Command;
import com.pagodalabs.commands.CommandFactory;
import com.pagodalabs.website_scraper.dao.JobDAO;
import com.pagodalabs.website_scraper.dao.impl.JobDAOImpl;
import java.io.IOException;
import java.net.MalformedURLException;
public class Program {

    public static void main(String[] args){
    
        try{
        System.out.println("Processing...");
        Command jobsNepal = CommandFactory.getCommand("jobsNepal");
        Command meroJob = CommandFactory.getCommand("meroJob");
        jobsNepal.add();
        meroJob.add();
        JobDAO dao = new JobDAOImpl("Website_ScraperPU");
        System.out.println("Total No. of Vacancies for Information Technology posted on JobsNepal.com and MeroJobs.com are "+dao.showAll().size());
        System.out.println("Done");
        }catch(MalformedURLException mue){
            System.out.println(mue.getMessage());
        }catch(IOException ioe){
            
            System.out.println(ioe.getMessage());
        }
      
    }
        
}
