package com.pagodalabs.commands;
import com.pagodalabs.website_scraper.util.CodeReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JobsNepal extends Command{
    //kyamu
    //ga.apply\(ga,\s\["ec:addImpression",\{"id"\:"(.*?)","name"\:"(.*?)","brand":"(.*?)","category":"(.*?)","position"\:(.*?),"price"\:"(.*?)"

    @Override
    public void add() throws MalformedURLException, IOException{
        int i = 1;
        while(i<=6){
           if(i == 1){
        String content = CodeReader.read("http://www.jobsnepal.com/premium-listings");
        patternAndMatcher(content);
        i++;
            }else{
        String content = CodeReader.read("http://www.jobsnepal.com/premium-listings/page-"+i);
        patternAndMatcher(content);
        i++;
           }
        }   
        
    }
    
    private void patternAndMatcher(String content){
        String titleCode = "class=\"job-item\" id=\"(.*?)\" href=\"(.*?)\" >\\s*(.*?)\\s*</a>";
        String companyCode = "href=\"(.*?)\" class=\"joblist\">\\s*(.*?)\\s*</a";
        String deadlineCode = "<span title=\"(.*?)\\s(.*?),\\s(.*?)\">(.*?)</span>";
        Pattern pattern = Pattern.compile(titleCode);
        Pattern pattern1 = Pattern.compile(companyCode);
        Pattern pattern2 = Pattern.compile(deadlineCode);
        Matcher matcher = pattern.matcher(content);
        Matcher matcher1 = pattern1.matcher(content);
        Matcher matcher2 = pattern2.matcher(content);
        while(matcher.find()&&matcher1.find()&&matcher2.find()){
            if(matcher.group(3).toLowerCase().contains(".net")||
               matcher.group(3).toLowerCase().contains("java")||
               matcher.group(3).toLowerCase().contains("wordpress")||
               matcher.group(3).toLowerCase().contains("web")||
               matcher.group(3).toLowerCase().contains("development")||
               matcher.group(3).toLowerCase().contains("developer")||
               matcher.group(1).toLowerCase().contains("ios")||
               matcher.group(1).toLowerCase().contains("android")||
               matcher.group(3).toLowerCase().contains("programmer")){
            String jobTitle = matcher.group(3), link = matcher.group(2), companyName=matcher1.group(2), deadline=matcher2.group(4);
            
            CodeReader.setToObject(jobTitle, companyName, deadline, link);
            }
        }
    }
    
    private String nextPage(String content){
        String next = null;
        String nextCode = "\"pagination-next\">(.*?)</";
        Pattern pattern = Pattern.compile(nextCode);
        Matcher matcher = pattern.matcher(content);
        next =  matcher.group(1);
        return next;
    }
}
