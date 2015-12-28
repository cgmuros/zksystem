/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgmuros.pruebazk.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;

/**
 *
 * @author cgmuros
 */
public class DocumentoController extends SelectorComposer<Window> {

    @Wire("label")
    private Label lbl;

    @Listen("onUpload = #up")
    public void nuevoDocumento(UploadEvent evt) {
           //lbl.setValue("" + evt.getMedia());
           lbl.setValue(evt.getMedia().getName());
           
    }
    
    

}
