/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.infra.impl;

/**
 *
 * @author SIGEN 3
 */
public class ECFServiceFactory {

    private static ECFServiceFactory instance;

    private ECFServiceFactory() {
    }

    public static ECFServiceFactory getInstance() {
        if (instance == null) {
            instance = new ECFServiceFactory();
        }
        return instance;
    }

    public ECFService criarECFService() {
        return new BematechECFService();
    }
}
