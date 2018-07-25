package com.npay.mongo.pilot.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Lists;
import com.slowhand.mongo.pilot.model.entity.Friend;
import com.slowhand.mongo.pilot.model.entity.User;
import com.slowhand.mongo.pilot.service.FriendService;
import com.slowhand.mongo.pilot.utils.PrintUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FriendServiceTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private FriendService friendService;

	@Test
	public void initData() {
		List<User> users = makeUsers();
		users.stream()
			.forEach(t -> {
				logger.info(PrintUtils.prettyPrint(t));
			});
		friendService.bulkSave(users);
	}

	@Test
	public void initMbrInfo() {
		List<String> mbrInfos = mbrInfoList();

		for (String mbrInfo : mbrInfos) {
			logger.info(PrintUtils.prettyPrint(mbrInfo));
		}
	}

	@Test
	public void test() {
		String text = "abcd:efeq:sdadee:www";
		String[] textArray = text.split(":");

		for (String t : textArray) {
			logger.info(t);
		}
	}

	public List<User> makeUsers() {
		List<String> mbrInfoList = mbrInfoList();
		List<User> users = Lists.newArrayList();

		for (int i = 0; i < 100; i++) {
			int friendCount = RandomUtils.nextInt(2, 10);
			String[] mbrArray = mbrInfoList.get(i)
				.split(":");
			String nid = mbrArray[0];
			Long mbrNo = Long.parseLong(mbrArray[1]);
			String name = mbrArray[2];
			String telNo = mbrArray[3];

			User user = User.builder()
				.nid(nid)
				.mbrNo(mbrNo)
				.name(name)
				.telNo(telNo)
				.build();

			List<Friend> friends = Lists.newArrayList();

			for (int j = 0; j < friendCount; j++) {
				String[] fmbrArray = mbrInfoList.get((j + friendCount) >= 100 ? j : j + friendCount)
					.split(":");

				Friend f = Friend.builder()
					.nid(fmbrArray[0])
					.mbrNo(Long.parseLong(fmbrArray[1]))
					.name(fmbrArray[2])
					.telNo(fmbrArray[3])
					.favorite(j % 3 == 2 ? true : false)
					.lastModDate(LocalDateTime.now()
						.minusDays(friendCount + j)
						.minusHours(friendCount + j + 11)
						.minusMinutes(friendCount + j + 33)
						.minusSeconds(friendCount + j + 12)
						.truncatedTo(ChronoUnit.SECONDS))
					.build();
				friends.add(f);
			}
			user.setFriends(friends);
			users.add(user);
		}
		return users;
	}

	private List<String> mbrInfoList() {
		List<String> mbrInfos = Lists.newArrayList();
		for (int i = 0; i < 100; i++) {
			String nid = RandomStringUtils.randomAlphanumeric(7);
			Integer mbrNo = nid.hashCode() < 0 ? nid.hashCode() * -1 : nid.hashCode();
			String name = randomName();
			String telNo = "0" + RandomUtils.nextInt(10, 19) + RandomUtils.nextInt(20000000, 99999999);
			mbrInfos.add(nid + ":" + mbrNo + ":" + name + ":" + telNo);
		}
		return mbrInfos;
	}

	private String randomName() {
		StringBuffer nameBuff = new StringBuffer();
		int nameSize = 3;

		for (int i = 0; i < nameSize; i++) {
			char ch = (char)((Math.random() * 11172) + 0xAC00);
			nameBuff.append(ch);
		}
		return nameBuff.toString();
	}

}
