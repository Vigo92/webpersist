package com.vigo.webpersist.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.vigo.webpersist.model.Client;

public class ClientService {

	public static EntityManagerFactory emf ;
	public static EntityManager em ;
		
		
	
	public static void close() {
		em.close();
		emf.close();
	}
	
	public static void open() {
		 emf = Persistence.createEntityManagerFactory("client");
		 em = emf.createEntityManager();
	}
	
	public static List<Client> getClients() {
		
		open();
		em.getTransaction().begin();
		TypedQuery<Client> query = em.createQuery("from client", Client.class);
		List<Client> client = query.getResultList();
		em.getTransaction().commit();
		close();
		return client;
		
	}
	
	public static Client getClient(int id) {
		
		open();
		em.getTransaction().begin();
		Client client = em.find(Client.class, id);
		em.getTransaction().commit();
		close();
		return client;
	}
	
	public static Client createClient(Client client) {
		
		open();
		em.getTransaction().begin();
		em.persist(client);
		em.getTransaction().commit();
		close();
		return client;
	}
	
	public static Client updateClient(int id, Client client) {
		
		open();
		em.getTransaction().begin();
		client = em.find(Client.class, id);
		em.merge(client);
		em.getTransaction().commit();
		close();
		return client;
	}
	
	public static void deleteClient(int id) {
		
		open();
		em.getTransaction().begin();
		Client client = em.find(Client.class, id);
		em.remove(client);
		em.getTransaction().commit();
		close();
		
		
	}
}
