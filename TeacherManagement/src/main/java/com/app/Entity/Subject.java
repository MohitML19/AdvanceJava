package com.app.Entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreType
public class Subject extends BaseEntity {

	private String subname;
	
	private int duration;
	
	private String book;
	
	private String descr;
	
	@ManyToOne
	@JoinColumn
	private Teacher assignedTeacher;
}
