package com.slowhand.mongo.pilot.model.entity;

import java.time.LocalDateTime;

import com.slowhand.mongo.pilot.enums.ReceiverType;
import com.slowhand.mongo.pilot.enums.StatusType;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Friend {
	private Long seq;
	private String nid;
	private Long mbrNo;
	private StatusType status;
	private String name;
	private String telNo;
	private boolean favorite;
	private ReceiverType receiverTypeCode;
	private LocalDateTime lastModDate;
}
