package com.chainsys.bloodbankapp.model;

import java.time.LocalDate;
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
@ToString(exclude = "user")
@EqualsAndHashCode
@Entity
@Table(name = "blood_donations")
public class BloodDonation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blood_donations_id_generator")
	@SequenceGenerator(name = "blood_donations_id_generator", sequenceName = "blood_donation_id_seq")
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "donated_on")
	private LocalDate donatedOn;

	@Column(name = "created_date")
	private LocalDateTime createdOn;

	@Column(name = "modified_date")
	private LocalDateTime modifiedOn;

}
