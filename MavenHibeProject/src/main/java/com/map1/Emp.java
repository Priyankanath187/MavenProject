package com.map1;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Emp {
	@Id
	private int eid;
	private String eName;
	
	@ManyToMany
	@JoinTable
	(name = "emp_Learn",
	joinColumns = {@JoinColumn(name="EId")},
	inverseJoinColumns = {@JoinColumn(name="PId")}
	)
	private List<Project> projects;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public Emp(int eid, String eName, List<Project> projects) {
		super();
		this.eid = eid;
		this.eName = eName;
		this.projects = projects;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
