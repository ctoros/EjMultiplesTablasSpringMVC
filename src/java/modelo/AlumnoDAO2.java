/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Alumno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ctoro
 */
@Service
public class AlumnoDAO2 {
    @PersistenceContext
    private EntityManager em;
    
    @Transactional(rollbackFor = {ServicioException.class})
    
    public void create(Alumno dto) throws ServicioException{
        em.persist(dto); //crear alumno
        
//        em.merge(dto);//actualizar
//        em.remove(dto);//eliminar
//        em.find(Alumno.class,"111");//buscar por pk
    }
    
    //consulta simple entity buscar un alumno por el rut
    public Alumno readByRut(String rut) throws SecurityException{
        return em.find(Alumno.class,rut);        
    }
    
    //otra forma de buscar un alumno usando query JPQL (consulta simple) JPQL -> java persistence query language
    public Alumno readByRutJPQL(String rut) throws SecurityException{
        String sql = "Select a from Alumno a Where a.rut = :rut";
        
        Query q=em.createQuery(sql);
        q.setParameter("rut", rut);
        
        try {
            return (Alumno)q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    //query JPQL (consulta multiple)
    public List<Alumno> readAllJPQL() throws SecurityException{
        String sql="Select a from Alumno a";
        
        Query q = em.createQuery(sql);
        
        return q.getResultList();
    }
    
    //otra forma de query jpql (consulta simple)
    public boolean readByRutJPQLCreate(String rut) throws SecurityException{
        String sql = "Select a from Alumno a Where a.rut = :rut";
        Query q=em.createQuery(sql);
        q.setParameter("rut", rut);
        
        if (q.getResultList().size()>0) {
            return true;
        }else{
            return false;
        }
    }
    
    //query JPQL (insertar)
    public int createJPQL(Alumno dto) throws SecurityException{
        if (readByRutJPQLCreate(dto.getRut())) {
            return 0;
        }else{
            em.persist(dto);
            return 1;
        }
    }
    
    
    
    
}
