package com.mastercode.eps.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String department;
	private double salary;
	

}
