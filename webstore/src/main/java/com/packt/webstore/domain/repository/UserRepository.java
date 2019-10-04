package com.packt.webstore.domain.repository;

public interface UserRepository {
	public int getUserId(String databaseTableName, String userName,String columnName);
}
