package com.slowhand.mongo.pilot.model.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "friends")
public class User {
	@Id
	private String nid;
	private Long mbrNo;
	private String name;
	private String telNo;
	private List<Friend> friends;
}
