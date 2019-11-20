package com.personal.service.impl;

import java.util.List;

import com.personal.mapper.RuleMapper;
import com.personal.mapper.UserMapper;
import com.personal.pojo.Rule;
import com.personal.pojo.User;
import com.personal.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class RuleServiceImpl implements RuleService {

	@Autowired
	private UserMapper userMapper ;
	@Autowired
	private RuleMapper ruleMapper;

	@Override
	public int addRule(String[] uid, String[] cks, String deptid, String rulename) {
		int result = 0;
		for (int i = 0; i < uid.length; i++) {
			Rule rule = new Rule();
			rule.setRulename(rulename);
			rule.setUserid(Integer.valueOf(uid[i]));
			rule.setDeptid(Integer.valueOf(deptid));
			rule.setWeek(cks[i]);
			result += ruleMapper.insert(rule);
		}
		return result;
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<User> getUsersByMessage(User user) {
		return userMapper.selectUsersByDeptAndRegistLevel(user);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int saveRule(Rule rule) {
		return ruleMapper.insertRule(rule);
	}

}
