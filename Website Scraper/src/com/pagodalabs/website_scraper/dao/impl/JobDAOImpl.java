package com.pagodalabs.website_scraper.dao.impl;

import com.pagodalabs.website_scraper.dao.JobDAO;
import com.pagodalabs.website_scraper.entity.Job;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JobDAOImpl implements JobDAO{
    
    private EntityManagerFactory factory;
    private EntityManager manager;
    

    public JobDAOImpl(){
        
    }
    
    public JobDAOImpl(String pUnit){
        factory = Persistence.createEntityManagerFactory(pUnit);
        manager = factory.createEntityManager();
        
    }
    
    public EntityTransaction getTransaction(){
        return manager.getTransaction();
    }
    
    @Override
    public int insert(Job job){
        int id = 0;
        getTransaction().begin();
        manager.persist(job);
        id = job.getId();
        getTransaction().commit();
        return id;
    }

    @Override
    public List<Job> showAll() {
        return (List<Job>) manager.createQuery("SELECT j FROM Job j").getResultList();
    }

}
