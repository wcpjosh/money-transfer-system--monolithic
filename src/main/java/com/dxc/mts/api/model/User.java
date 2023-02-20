package com.dxc.mts.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author mkhan339
 *
 */
@Data
@NoArgsConstructor
@Entity(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Account> accounts;

	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
	private Address address;

	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<EventLog> eventLog;

	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	private List<Transaction> transactions;
}
