package com.kh.test.user.model.service;

import java.lang.reflect.Member;

import com.kh.test.user.model.dto.User;

public interface UserService {

	User selectMember(String inputId);

}
