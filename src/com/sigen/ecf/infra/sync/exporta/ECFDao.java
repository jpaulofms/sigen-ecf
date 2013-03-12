package com.sigen.ecf.infra.sync.exporta;

public class ECFDao extends DAO {

	private static final String HOST = "127.0.0.1";
	private static final String DATABASE_NAME = "sigen_ecf_ceal";

	private static final String DATABASE_USER = "postgres";
	private static final String DATABASE_PASS = "sigenerp";

	@Override
	protected String getDatabaseName() {
		return DATABASE_NAME;
	}

	@Override
	protected String getHost() {
		return HOST;
	}

	@Override
	protected String getUser() {
		return DATABASE_USER;
	}

	@Override
	protected String getPass() {
		return DATABASE_PASS;
	}
}
