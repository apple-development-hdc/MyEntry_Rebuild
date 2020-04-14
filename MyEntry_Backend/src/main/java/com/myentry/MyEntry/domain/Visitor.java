package com.myentry.MyEntry.domain;

import static com.myentry.MyEntry.constants.CommonConstants.*;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = VISITOR)
public class Visitor extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = VISITOR_SEQ, strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = VISITOR_SEQ, sequenceName = VISITOR_SEQ, allocationSize = 1)
	@Column(name = ID, updatable = false, nullable = false)
	private Long id;

	@Column(name = ACTIVE_IND)
	private int activeInd;

	@Column(name = VISITOR_TYPE)
	private String visitorType;

	@Column(name = FIRST_NAME)
	private String firstName;

	@Column(name = LAST_NAME)
	private String lastName;

	@Column(name = CONTACT_NUMBER)
	private String contactNumber;

	@Column(name = PURPOSE)
	private String purpose;

	@Column(name = LOCATION_NAME)
	private String location;

	@Column(name = EMP_ID)
	private String visitorEmpId;

	@Column(name = ESCORT_EMP_ID)
	private String escortEmpId;

	@Column(name = LAPTOP_SERIAL_NUMBER)
	private String laptopSerialNo;

	@Column(name = REMARKS)
	private String remarks;

	@Column(name = IN_TIME)
	private Timestamp inTime;

	@Column(name = OUT_TIME)
	private Timestamp outTime;

	@Column(name = EMPLOYEE_TYPE)
	private String empType;

	@Lob
	@Column(name = IMAGE)
	private byte[] image;

	@Column(name = ODC_LOCATION)
	private String odcLocation;

	@Column(name = ACCOUNT_NAME)
	private String account;

	@Column(name = PROXY)
	private String proxy;
	
	@Column(name = STATUS)
	private String status;
	
}
