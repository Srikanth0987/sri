package com.customAnnotaion;

import java.lang.reflect.Field;

public class GenricDao {
	
	public void savedata(Object o)
	{
		DbTest db=o.getClass().getAnnotation(DbTest.class);
		if(db!=null)
		{
			System.out.println("Data save"+db.value());
			
		}
		else
		{
			System.out.println("can not process....");
		}
		
		Field[] field=o.getClass().getDeclaredFields();
		for (Field field2 : field) {
			
		column c=field2.getAnnotation(column.class);
			
		if(c!=null)
			{
				System.out.println("data save column"+c.name());
				
			}
			else
			{
				System.out.println("Data not saved");
			}
		
		}
		//transaction contains multiple operations like insert update delte if any operation is 
		//failed tansaction failed. begin and end tx
					
	}
	
	public static void main(String[] args) {
		Studentpojo pojo=new Studentpojo();
		GenricDao dao=new GenricDao();
		dao.savedata(pojo);
		
		
		
		
		
		
	}

}
