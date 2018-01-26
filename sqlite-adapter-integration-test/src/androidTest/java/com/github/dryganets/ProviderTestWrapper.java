package com.github.dryganets;

import com.github.dryganets.sqlite.adapter.Database;
import com.github.dryganets.sqlite.adapter.DatabaseConnectionProvider;

import java.io.IOException;

/**
 * Created by sergeyd on 1/26/18.
 */

public class ProviderTestWrapper {
	private DatabaseConnectionProvider provider;
	private String databaseName;
	private Database db;

	public ProviderTestWrapper(DatabaseConnectionProvider provider, String databaseName) {
		this.provider = provider;
		this.databaseName = databaseName;
	}

	public Database get() {
		if (db == null) {
			db = provider.openDatabase(databaseName,"", DatabaseConnectionProvider.OPEN_READWRITE |
					DatabaseConnectionProvider.CREATE_IF_NECESSARY);
		}
		return db;
	}

	public void close() throws IOException {
		if (db != null) {
			db.close();
		}
	}
}
