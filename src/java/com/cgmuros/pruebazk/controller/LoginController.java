/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgmuros.pruebazk.controller;

import com.cgmuros.pruebazk.business.CuentaImpl;
import com.cgmuros.pruebazk.business.ICuenta;
import com.cgmuros.pruebazk.model.Cuenta;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;

/**
 *
 * @author cgmuros
 */
public class LoginController extends SelectorComposer<Component> {
    
    @Wire
    private Textbox usuario;
    
    @Wire
    private Textbox contrasena;
    
    @Listen("onClick = #entrar")
    public void login() {
        
        Cuenta cuenta = new Cuenta();
        cuenta.setUsuario(usuario.getValue());
        cuenta.setPassword(contrasena.getValue());
        

        ICuenta nuevaCuenta = new CuentaImpl();
        if (nuevaCuenta.Login(cuenta)) {
            Session sess = Sessions.getCurrent();
            sess.setAttribute("key", cuenta);
            Executions.sendRedirect("Cuenta/Crea.zul");
        }
    }
    
    
    
    
}
