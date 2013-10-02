package com.fsff.sessionmanager;

import javax.persistence.EntityManager;

import org.hibernate.Session;

public class SessionManager {
	
	public static final ThreadLocal<ClientSession> threadSession = new ThreadLocal<ClientSession>();
	
	public static void createSession(){
		if(threadSession.get() == null){
			ClientSession dbSession = new ClientSession();
			threadSession.set(dbSession);
		}
	}
	
	public static void createEntityManager(){
		threadSession.get().createEntityManager();
	}
	
	public static EntityManager getEntityManager(){
		return threadSession.get().getEntityManager();
	}
	
	public static void closeEntityManager(){
		threadSession.get().closeEntityManager();;
	}

}
