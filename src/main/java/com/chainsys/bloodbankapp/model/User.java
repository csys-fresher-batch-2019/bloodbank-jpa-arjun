package com.chainsys.bloodbankapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "donor_details")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE )
	@Column(name = "id")
	private int userId;
	@Column(name = "name")
	private String userName;
	@Column(name = "gender")
	private String gender;
	@Column(name = "age")
	private int age;
	@Column(name = "email")
	private String email;
	@Column(name = "city")
	private String city;
	@Column(name = "active")
	private boolean active;
	@Column(name = "mobile_number")
	private long mobileNumber;
	@Column(name = "password")
	private String password;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bg_id")
	private BloodGroup bloodGroup;

}