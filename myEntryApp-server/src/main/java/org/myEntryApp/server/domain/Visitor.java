package org.myEntryApp.server.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static org.myEntryApp.server.constants.CommonConstants.*;

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
	private Timestamp intime;

	@Column(name = OUT_TIME)
	private Timestamp outtime;

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

}
