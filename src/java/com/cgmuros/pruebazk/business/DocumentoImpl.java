/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgmuros.pruebazk.business;

import com.cgmuros.pruebazk.model.Documento;
import com.cgmuros.pruebazk.resource.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author cgmuros
 */
public class DocumentoImpl implements IDocumento{

    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    
    public void Crear(Documento documento) {
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(documento);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }
    
}
