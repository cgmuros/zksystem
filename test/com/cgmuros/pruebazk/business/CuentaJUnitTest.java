/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgmuros.pruebazk.business;

import com.cgmuros.pruebazk.model.Cuenta;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author cgmuros
 */
public class CuentaJUnitTest {

    public CuentaJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void CreaCuenta() {
        Cuenta cuenta = new Cuenta();
        cuenta.setUsuario("cgmuros");
        cuenta.setPassword("alfa14");
        cuenta.setNombre("Cristian");
        cuenta.setApellido("Muñoz");
        cuenta.setEmail("cgmuros@gmail.com");

        ICuenta nuevaCuenta = new CuentaImpl();
        nuevaCuenta.Crear(cuenta);

    }

    @Test
    public void listarTodos() {
        ICuenta cuenta = new CuentaImpl();
        List listCuenta = cuenta.listarTodos();

        for (Iterator iterator
                = listCuenta.iterator(); iterator.hasNext();) {
            Cuenta cuentaIte = (Cuenta) iterator.next();
            System.out.print("Usuario: " + cuentaIte.getUsuario()); 
            System.out.print("  Password: " + cuentaIte.getPassword()); 
            System.out.println("  Nombre: " + cuentaIte.getNombre());  
            System.out.println("  Email: " + cuentaIte.getEmail());
            System.out.println("  Apellido: " + cuentaIte.getApellido());
        }

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
