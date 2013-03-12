/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigen.ecf.infra.impl;

import com.sigen.ecf.infra.TEFService;

/**
 * 
 * @author SIGEN 3
 */
public class TEFServiceFactory {

	private static TEFServiceFactory instance;

	private TEFServiceFactory() {
	}

	public static TEFServiceFactory getInstance() {
		if (instance == null) {
			instance = new TEFServiceFactory();
		}
		return instance;
	}

	public TEFService criarTEFService() {
		return new AdaptorTEFService();
	}
}
