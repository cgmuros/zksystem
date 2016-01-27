/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgmuros.pruebazk.business;

import com.cgmuros.pruebazk.model.Documento;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

/**
 *
 * @author cgmuros
 */
public class DocumentoImplTest {

    public DocumentoImplTest() {
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

    /**
     * Test of Crear method, of class DocumentoImpl.
     */
    @Test
    public void testCrear() {
        System.out.println("Crear");

        Documento documento = new Documento();
        DocumentoImpl instance = new DocumentoImpl();

        byte[] file = null;
        try {
            InputStream inputStream = new FileInputStream("/home/cgmuros/Documents/comandos_heroku");

            String inputStreamToString = inputStream.toString();
            file = inputStreamToString.getBytes();

            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not found" + e);
        } catch (IOException e) {
            System.out.println("IO Ex" + e);
        }

        documento.setDocumentoFisico(file);
        
        instance.Crear(documento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
