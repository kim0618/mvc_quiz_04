package com.care.root.member.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface MemberService {
	public void test();
	public void register(String id, String pwd, String name);
	public void memberList(Model model);
}
