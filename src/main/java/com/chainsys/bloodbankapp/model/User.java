package com.chainsys.bloodbankapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "donor_details")
@NamedQuery(name = "findAllUsers", query = "from User u where u.email = ?1")
public class User {

	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "donor_id_generator")
	@SequenceGenerator(name = "donor_id_generator", sequenceName = "donor_id_seq")
	@Column(name = "id")
	private int userId;
	@NotNull @Size(min = 3, max = 30)
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
	@Column(name = "user_type")
	private String userType;

	//@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)	// 20-09-2020 : is not working for "save" method // not required so see below line
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bg_id")
	private BloodGroup bloodGroup;

	//@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true)	//orphanRemoval = if we delete parent, then it automatically delete child
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)	//orphanRemoval(latest) = cascade(older)
	private List<BloodDonation> bloodDonations;
}
