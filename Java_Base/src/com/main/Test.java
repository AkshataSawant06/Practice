package com.main;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.model.Employee;
import com.model.Student;

public class Test {
	
public static void main(String[] args) {
	StandardServiceRegistry registry = null;
	Map<Object, String> setting = new HashMap<>();
	// mysql connection
	setting.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	setting.put(Environment.URL, "jdbc:mysql://localhost:3306/Demo");
	setting.put(Environment.USER, "root");
	setting.put(Environment.PASS, "root");
	// Hibernate connectionorg.hibernate.dialect.MySQL5Dialect
	setting.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
	setting.put(Environment.HBM2DDL_AUTO, "create");
	setting.put(Environment.SHOW_SQL, "true");
	//load cfg file
	registry = new StandardServiceRegistryBuilder().applySettings(setting).build();
	// it contain entity information and relation mapping
	MetadataSources mds = new MetadataSources(registry);
			mds.addAnnotatedClass(Employee.class);
			// get information of entity information 
	Metadata md = mds.getMetadataBuilder().build();
	// create session factory object
	SessionFactory sf = md.getSessionFactoryBuilder().build();
	// sf using create session object
	Session session = sf.openSession();
	//insert data database
//	Student stu= new Student();
	Employee stu = new Employee();
	stu.setId(101);
	stu.setName("abc");
	session.save(stu);
	session.beginTransaction().commit();
   }
}