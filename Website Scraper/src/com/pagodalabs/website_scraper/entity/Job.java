package com.pagodalabs.website_scraper.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
@Entity
@Table(name="website_scraper")
public class Job {

    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;
    @Column(name="job_title")
    private String jobTitle;
    @Column(name="company_name")
    private String companyName;
    @Column(name="deadline")
    private String deadline;
    @Column(name="link")
    private String link;

    public Job() {
    }

    public Job(int id, String jobTitle, String companyName, String deadline, String link) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.deadline = deadline;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Job{" + "id=" + id + ", jobTitle=" + jobTitle + ", companyName=" + companyName + ", deadline=" + deadline + ", link=" + link + '}';
    }
    
    
    
}
