package com.nss.java1.reflect_jdbc6.orm.ormv2;
public class Student{
	static{
		System.out.println("nssliu");
	}
	private String name;
	public String getname(){
		return this.name;
	}
	public void setname(String name){
		this.name=name;
	}
	private Integer age;
	public Integer getage(){
		return this.age;
	}
	public void setage(Integer age){
		this.age=age;
	}
}