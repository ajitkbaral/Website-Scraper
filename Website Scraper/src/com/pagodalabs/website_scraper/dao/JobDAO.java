package com.pagodalabs.website_scraper.dao;

import com.pagodalabs.website_scraper.entity.Job;
import java.util.List;

public interface JobDAO {

    public int insert(Job job);
    public List<Job> showAll();
}
