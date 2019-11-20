package com.personal.service;


import com.personal.pojo.Rule;
import com.personal.pojo.User;

import java.util.List;

public interface RuleService {
	public int addRule(String[] uid, String[] cks, String deptid, String rulename);
	public List<User> getUsersByMessage(User user);

	public int saveRule(Rule rule);
}
