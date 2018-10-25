package com.finalso.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.finalso.common.SoEntityManagerFactory;
import com.finalso.data.Partidos;

public class PartidosDao {
	
	public PartidosDao() {
	}
	
	@SuppressWarnings("unchecked")
	public List<Partidos> getPartidos(){
		List<Partidos> res = new ArrayList<>();
		EntityManager em = SoEntityManagerFactory.createEntityManagerFactory().createEntityManager();
		
		try {
			res = em.createQuery("from Partidos").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return res;
	}
	
	public List<Partidos> obtenerPartido(String clave) {
		List<Partidos> res = new ArrayList<>();
		EntityManager em = SoEntityManagerFactory.createEntityManagerFactory().createEntityManager();
		
		CriteriaBuilder crit = em.getCriteriaBuilder();
		CriteriaQuery<Partidos> query = crit.createQuery(Partidos.class);
		Root<Partidos> root = query.from(Partidos.class);
		
		try {
			query.select(root).where(
				crit.equal(root.get("id"), clave)
			);
			
			res = em.createQuery(query).getResultList();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		
		return res;
	}
}
