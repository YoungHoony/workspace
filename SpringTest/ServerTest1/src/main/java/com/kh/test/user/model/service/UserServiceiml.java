package com.kh.test.user.model.service;

import java.lang.reflect.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.test.user.model.dto.User;
import com.kh.test.user.model.mapper.UserMapper;

@Transactional
@Service
public class UserServiceiml implements UserService {

	@Autowired
	private UserMapper mapper;
	
	@Override
	public User selectMember(String inputId) {
		return mapper.selectMember(inputId);
	}
}
