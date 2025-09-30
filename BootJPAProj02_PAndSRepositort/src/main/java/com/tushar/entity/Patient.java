package com.tushar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="JPA_Patient_Table")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Patient {
	@Id
	@SequenceGenerator(name="gen", sequenceName="PNO_SEQ",initialValue=1,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="gen")
	private Integer pNo;
	@NonNull
	private String pName;
	@NonNull
	private String PAddrs;
	@NonNull
	private Float billAmt;

}
