package com.chainsys.bloodbankapp.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "request_donor")
public class RequestDonor {

	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_donor_generator")
	@SequenceGenerator(name = "request_donor_generator", sequenceName = "request_donor_seq")
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "posted_by")
	private User postedBy;

	@Column(name = "posted_date")
	private LocalDateTime postedDate;

	@Column(name = "status")
	private String status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "blood_group_id")
	private BloodGroup bloodGroup;
}
