/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.control;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mx.edu.itoaxaca.modelo.Paciente;
import mx.edu.itoaxaca.modelo.Consulta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import mx.edu.itoaxaca.control.exceptions.NonexistentEntityException;
import mx.edu.itoaxaca.control.exceptions.RollbackFailureException;
import mx.edu.itoaxaca.modelo.Cita;

/**
 *
 * @author Zidai
 */
public class CitaJpaController1 implements Serializable {

    public CitaJpaController1(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cita cita) throws RollbackFailureException, Exception {
        if (cita.getConsultaCollection() == null) {
            cita.setConsultaCollection(new ArrayList<Consulta>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Paciente paciente = cita.getPaciente();
            if (paciente != null) {
                paciente = em.getReference(paciente.getClass(), paciente.getIdpaciente());
                cita.setPaciente(paciente);
            }
            Collection<Consulta> attachedConsultaCollection = new ArrayList<Consulta>();
            for (Consulta consultaCollectionConsultaToAttach : cita.getConsultaCollection()) {
                consultaCollectionConsultaToAttach = em.getReference(consultaCollectionConsultaToAttach.getClass(), consultaCollectionConsultaToAttach.getIdconsulta());
                attachedConsultaCollection.add(consultaCollectionConsultaToAttach);
            }
            cita.setConsultaCollection(attachedConsultaCollection);
            em.persist(cita);
            if (paciente != null) {
                paciente.getCitaList().add(cita);
                paciente = em.merge(paciente);
            }
            for (Consulta consultaCollectionConsulta : cita.getConsultaCollection()) {
                Cita oldCitaOfConsultaCollectionConsulta = consultaCollectionConsulta.getCita();
                consultaCollectionConsulta.setCita(cita);
                consultaCollectionConsulta = em.merge(consultaCollectionConsulta);
                if (oldCitaOfConsultaCollectionConsulta != null) {
                    oldCitaOfConsultaCollectionConsulta.getConsultaCollection().remove(consultaCollectionConsulta);
                    oldCitaOfConsultaCollectionConsulta = em.merge(oldCitaOfConsultaCollectionConsulta);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cita cita) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Cita persistentCita = em.find(Cita.class, cita.getIdcita());
            Paciente pacienteOld = persistentCita.getPaciente();
            Paciente pacienteNew = cita.getPaciente();
            Collection<Consulta> consultaCollectionOld = persistentCita.getConsultaCollection();
            Collection<Consulta> consultaCollectionNew = cita.getConsultaCollection();
            if (pacienteNew != null) {
                pacienteNew = em.getReference(pacienteNew.getClass(), pacienteNew.getIdpaciente());
                cita.setPaciente(pacienteNew);
            }
            Collection<Consulta> attachedConsultaCollectionNew = new ArrayList<Consulta>();
            for (Consulta consultaCollectionNewConsultaToAttach : consultaCollectionNew) {
                consultaCollectionNewConsultaToAttach = em.getReference(consultaCollectionNewConsultaToAttach.getClass(), consultaCollectionNewConsultaToAttach.getIdconsulta());
                attachedConsultaCollectionNew.add(consultaCollectionNewConsultaToAttach);
            }
            consultaCollectionNew = attachedConsultaCollectionNew;
            cita.setConsultaCollection(consultaCollectionNew);
            cita = em.merge(cita);
            if (pacienteOld != null && !pacienteOld.equals(pacienteNew)) {
                pacienteOld.getCitaList().remove(cita);
                pacienteOld = em.merge(pacienteOld);
            }
            if (pacienteNew != null && !pacienteNew.equals(pacienteOld)) {
                pacienteNew.getCitaList().add(cita);
                pacienteNew = em.merge(pacienteNew);
            }
            for (Consulta consultaCollectionOldConsulta : consultaCollectionOld) {
                if (!consultaCollectionNew.contains(consultaCollectionOldConsulta)) {
                    consultaCollectionOldConsulta.setCita(null);
                    consultaCollectionOldConsulta = em.merge(consultaCollectionOldConsulta);
                }
            }
            for (Consulta consultaCollectionNewConsulta : consultaCollectionNew) {
                if (!consultaCollectionOld.contains(consultaCollectionNewConsulta)) {
                    Cita oldCitaOfConsultaCollectionNewConsulta = consultaCollectionNewConsulta.getCita();
                    consultaCollectionNewConsulta.setCita(cita);
                    consultaCollectionNewConsulta = em.merge(consultaCollectionNewConsulta);
                    if (oldCitaOfConsultaCollectionNewConsulta != null && !oldCitaOfConsultaCollectionNewConsulta.equals(cita)) {
                        oldCitaOfConsultaCollectionNewConsulta.getConsultaCollection().remove(consultaCollectionNewConsulta);
                        oldCitaOfConsultaCollectionNewConsulta = em.merge(oldCitaOfConsultaCollectionNewConsulta);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cita.getIdcita();
                if (findCita(id) == null) {
                    throw new NonexistentEntityException("The cita with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Cita cita;
            try {
                cita = em.getReference(Cita.class, id);
                cita.getIdcita();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cita with id " + id + " no longer exists.", enfe);
            }
            Paciente paciente = cita.getPaciente();
            if (paciente != null) {
                paciente.getCitaList().remove(cita);
                paciente = em.merge(paciente);
            }
            Collection<Consulta> consultaCollection = cita.getConsultaCollection();
            for (Consulta consultaCollectionConsulta : consultaCollection) {
                consultaCollectionConsulta.setCita(null);
                consultaCollectionConsulta = em.merge(consultaCollectionConsulta);
            }
            em.remove(cita);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cita> findCitaEntities() {
        return findCitaEntities(true, -1, -1);
    }

    public List<Cita> findCitaEntities(int maxResults, int firstResult) {
        return findCitaEntities(false, maxResults, firstResult);
    }

    private List<Cita> findCitaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cita.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cita findCita(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cita.class, id);
        } finally {
            em.close();
        }
    }

    public int getCitaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cita> rt = cq.from(Cita.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
