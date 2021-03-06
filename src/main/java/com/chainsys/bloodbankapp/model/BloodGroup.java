package com.chainsys.bloodbankapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "blood_group")
public class BloodGroup {

	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE )
	@Column(name = "id", updatable = false, nullable = false)	//id can't be update and can't be null
	private int bloodGroupId;

	@Column(name = "name", unique = true)	//name should be unique
	private String bloodGroup;

}
