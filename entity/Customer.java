package com.tushar.entity;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="JPA_CUSTOMER_TAB")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {
	@Column(name="CID")
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)  //generates values to the "cno" property automatically started with 1 and incremented by 50
	@SequenceGenerator(name="gen1",sequenceName = "CNO_SEQ", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cno;
	@Column(name="CNAME",length=20)  //optional
	@Nonnull
	private String cname;
	@Column(name="CADD",length=20)
	@Nonnull
	private String caddrs;
	@Column(name="BILLAMT")  //optional
	@Nonnull
	private Float billAmt;
}
