package com.finalso.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.finalso.common.SoEntityManagerFactory;
import com.finalso.data.VpAlineaciones;

public class VpAlineacionesDao {
	
	public VpAlineacionesDao() {
	}
	
	@SuppressWarnings("unchecked")
	public List<VpAlineaciones> getAlineaciones(){
		List<VpAlineaciones> res = new ArrayList<>();
		EntityManager em = SoEntityManagerFactory.createEntityManagerFactory().createEntityManager();
		
		try {
			res = em.createQuery("from VpAlineaciones").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return res;
	}
	
	public List<VpAlineaciones> getAlineacionesPartido(String clave, String equipo){
		List<VpAlineaciones> res = new ArrayList<>();
		EntityManager em = SoEntityManagerFactory.createEntityManagerFactory().createEntityManager();
		
		CriteriaBuilder crit = em.getCriteriaBuilder();
		CriteriaQuery<VpAlineaciones> query = crit.createQuery(VpAlineaciones.class);
		Root<VpAlineaciones> root = query.from(VpAlineaciones.class);
		
		try {
			query.select(root).where(
				crit.equal(root.get("idPartido"), clave),
				crit.equal(root.get("equipo"), equipo)
			).orderBy(crit.asc(root.get("idPosicion")));
			
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
