package com.fsff.sessionmanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientSession {
	EntityManager entityManager;
	public static final EntityManagerFactory  emfInstance ;
	
	static{
		emfInstance  = Persistence
			    .createEntityManagerFactory("com.fsff.festival");
	}
	
	public void createEntityManager(){
		this.entityManager = emfInstance.createEntityManager();
	}
	
	public EntityManager getEntityManager(){
		return this.entityManager;
	}
	
	public void closeEntityManager(){
		if(this.entityManager!=null){
			this.entityManager.close();
		}
	}
}
