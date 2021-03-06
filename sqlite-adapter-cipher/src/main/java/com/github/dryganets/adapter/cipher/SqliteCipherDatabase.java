package com.github.dryganets.adapter.cipher;

import net.sqlcipher.database.SQLiteDatabase;

import com.github.dryganets.sqlite.adapter.Database;
import com.github.dryganets.sqlite.adapter.Cursor;
import com.github.dryganets.sqlite.adapter.SQLStatement;

import java.io.IOException;

/**
 * Written by Sergei Dryganets Jul 24/2017
 */
public class SqliteCipherDatabase implements Database {
	private SQLiteDatabase database;

	SqliteCipherDatabase(SQLiteDatabase database) {
		this.database = database;
	}

	@Override
	public void execSQL(String sql) {
		database.execSQL(sql);
	}

	@Override
	public SQLStatement compileStatement(String sql) {
		return new SqliteCipherStatement(database.compileStatement(sql));
	}

	@Override
	public Cursor rawQuery(String sql, String[] params) {
		return new SqliteCipherCursor(database.rawQuery(sql, params));
	}

	@Override
	public boolean isOpen() {
		return database.isOpen();
	}

	@Override
	public void beginTransaction() {
		database.beginTransaction();
	}

	@Override
	public void setTransactionSuccessful() {
		database.setTransactionSuccessful();
	}

	@Override
	public void endTransaction() {
		database.endTransaction();
	}

	@Override
	public void close() throws IOException {
		database.close();
	}
}
