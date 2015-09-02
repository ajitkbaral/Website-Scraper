package com.pagodalabs.commands;

import com.pagodalabs.website_scraper.util.CodeReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MeroJob extends Command{

    @Override
    public void add() throws MalformedURLException, IOException {
       /* 
        String content = CodeReader.read("http://merojob.com/");
        
        String comanyLinkTitleCode = "class=\"employername\\\">\\s*<h2>(.*?)</h2>\\s*<a href=\"(.*?)\" target=\"_blank\">(.*?)</a>";
        String deadlineCode = "br/>\\s*<span>(.*?)</span>";
        Pattern pattern = Pattern.compile(comanyLinkTitleCode);
        Pattern pattern1 = Pattern.compile(deadlineCode);
        Matcher matcher = pattern.matcher(content);
        Matcher matcher1 = pattern1.matcher(content);
        while(matcher.find()&&matcher1.find()){
            String companyName = matcher.group(1), link = matcher.group(2), jobTitle = matcher.group(3), deadline = matcher1.group(1);
            CodeReader.setToObject(jobTitle, companyName, deadline, link);
        }*/
        
        String content = CodeReader.read("http://www.merojob.com/search-new/index.php");
        
        String jobTitleCode = "class='title changefont'> (.*?) <img";
        String companyCode = "class=\"text-success changefont\">(.*?)</p";
        String deadlineCode = "Deadline: (.*?)</span>";
        Pattern pattern = Pattern.compile(jobTitleCode);
        Pattern pattern1 = Pattern.compile(companyCode);
        Pattern pattern2 = Pattern.compile(deadlineCode);
        Matcher matcher = pattern.matcher(content);
        Matcher matcher1 = pattern1.matcher(content);
        Matcher matcher2 = pattern2.matcher(content);
        while(matcher.find()&&matcher1.find()&&matcher2.find()){
            if(matcher.group(1).toLowerCase().contains(".net")||
               matcher.group(1).toLowerCase().contains("java")||
               matcher.group(1).toLowerCase().contains("wordpress")||
               matcher.group(1).toLowerCase().contains("web")||
               matcher.group(1).toLowerCase().contains("development")||
               matcher.group(1).toLowerCase().contains("developer")||
               matcher.group(1).toLowerCase().contains("ios")||
               matcher.group(1).toLowerCase().contains("android")||
               matcher.group(1).toLowerCase().contains("programmer")){
            String companyName = matcher1.group(1), link = "n/a", jobTitle = matcher.group(1), deadline = matcher2.group(1);
            CodeReader.setToObject(jobTitle, companyName, deadline, link);
            }
        }
        
    }
}
