package com.qa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.domain.Account;

@Transactional
public class AccountRepository {

	

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	

	public Account find(Long id) {
		return em.find(Account.class, id);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public Account create(Account account) {
		em.persist(account);
		return account;
	}
	
	
	
	
	
    public Account update(Account account ) {
    	em.merge(account);
    	return account;
    }
    
    public void delete(Long id) {
    	em.remove(em.getReference(Account.class, id));
    }
    
 
}
	

	
	
	
	

