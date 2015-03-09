package com.vendramel.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;

/**
 *
 * @author vendra
 */
public class PhanseListener implements PhaseListener{

    
    @Override
    public void beforePhase(PhaseEvent fase) {
        System.out.println("Antes da fase: "+ fase.getPhaseId());
        if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)) { 
            System.out.println("Before Phase -> " + getPhaseId());
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);            
        }
    }
    
    @Override
    public void afterPhase(PhaseEvent fase) {
        System.out.println("After Phase -> " + getPhaseId());
        if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            Session session = FacesContextUtil.getRequestSession();
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                    
                }
            }  finally {
                session.close();
            }
        }
        
    }

    @Override
    public PhaseId getPhaseId() {
       return PhaseId.ANY_PHASE;
    }
    
}
