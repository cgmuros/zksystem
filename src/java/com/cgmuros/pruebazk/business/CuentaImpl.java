/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgmuros.pruebazk.business;

import com.cgmuros.pruebazk.model.Cuenta;
import com.cgmuros.pruebazk.resource.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author cgmuros
 */
public class CuentaImpl implements ICuenta {

    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public void Crear(Cuenta cuenta) {

        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(cuenta);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }

    }

    public List<Cuenta> listarTodos() {
        Transaction tx = null;
        List listCuentas = null;

        try {
            tx = session.beginTransaction();
            listCuentas = session.createQuery("FROM Cuenta").list();

            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }
        return listCuentas;

    }

    public Boolean Existe(String usuario) {
        Transaction tx = null;
        Boolean result = false;
        List listCuentas;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Cuenta WHERE usuario = :usuario");
            query.setParameter("usuario", usuario);
            listCuentas = query.list();
            if (!listCuentas.isEmpty()) {
                result = true;
            }
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }
        return result;
    }

    public Boolean Login(Cuenta cuenta) {
        Transaction tx = null;
        Boolean result = false;
        List listCuentas;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Cuenta WHERE usuario = :usuario and password = :password");
            query.setParameter("usuario", cuenta.getUsuario());
            query.setParameter("password", cuenta.getPassword());
            listCuentas = query.list();
            if (!listCuentas.isEmpty()) {
                result = true;
            }
            tx.commit();
            

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }
        return result;
    }

}
