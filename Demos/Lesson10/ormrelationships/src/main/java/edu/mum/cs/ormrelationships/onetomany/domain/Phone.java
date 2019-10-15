/**
 * 
 */
package edu.mum.cs.ormrelationships.onetomany.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rujuan Xing
 *
 */
@Entity
@Table(name = "CELLPHONE")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	@Column(name = "AREA_CODE")
	private Integer areaCode;

	@Column(name = "P_NUMBER")
	private Integer number;
	private Integer prefix;

	public Phone(int start, int middle, int end) {
		this.areaCode = start;
		this.prefix = middle;
		this.number = end;
	}

	public Phone() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(Integer area) {
		this.areaCode = area;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getPrefix() {
		return prefix;
	}

	public void setPrefix(Integer prefix) {
		this.prefix = prefix;
	}
}
