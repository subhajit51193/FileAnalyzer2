package com.data.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Datas")
public class Data {

	@Id
	private String id;
	private String endYear;
	private String citylng;
	private String citylat;
	private String intensity;
	private String sector;
	private String topic;
	private String insight;
	private String swot;
	private String url;
	private String region;
	private String startYear;
	private String impact;
	private String added;
	private String published;
	private String city;
	private String country;
	private String relevance;
	private String pestle;
	private String source;
	private String title;
	private String likelihood;
}
