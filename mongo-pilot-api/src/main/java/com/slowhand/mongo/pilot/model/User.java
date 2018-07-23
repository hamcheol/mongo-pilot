package com.slowhand.mongo.pilot.model;

import java.time.LocalDateTime;
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
	private String id;
	
	private String nid;
	private String nidNo;
	private Long payMbrNo;
	private String name;
	private String telNo;
	private LocalDateTime lastModDate;
	
	private List<Friend> friends;
}
