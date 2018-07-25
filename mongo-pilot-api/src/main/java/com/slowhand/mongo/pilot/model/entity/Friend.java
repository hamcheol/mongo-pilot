package com.slowhand.mongo.pilot.model.entity;

import java.time.LocalDateTime;

import com.slowhand.mongo.pilot.enums.ReceiverType;
import com.slowhand.mongo.pilot.enums.StatusType;
import com.slowhand.mongo.pilot.enums.YesOrNoType;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Friend {
	private String nid;
	private String nidNo;
	private Long payMbrNo;
	private StatusType status;
	private String name;
	private String telNo;
	private YesOrNoType isFavorite;
	private ReceiverType receiverTypeCode;
	private LocalDateTime lastModDate;
	
	public String getNid() {
		return this.nid;
	}

}
