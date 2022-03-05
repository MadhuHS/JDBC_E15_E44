package com.jspiders.tmg.db;

import java.util.List;

public interface Database {
	
	public int insert(Object obj);
	
	public int update(Object obj);
	
	public int delete(Object obj);
	
	public Object selectOne(Object obj);
	
	public List<Object> selectMultiple(Object obj);
	
	public List<Object> selectAll();
}
