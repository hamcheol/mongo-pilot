package com.slowhand.mongo.pilot.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "sequence")
public class Sequence {
	@Id
	private String name;
	private Long seq;
}
