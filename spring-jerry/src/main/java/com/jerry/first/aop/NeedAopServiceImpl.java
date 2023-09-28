package com.jerry.first.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fanc
 */
@Service
public class NeedAopServiceImpl implements NeedAopService{

	@Autowired
	NeedAopCglibService needAopCglibService;

	@Override
	public void aopAdd() {
		needAopCglibService.needProxy();
	}

	@Override
	public void aopDel() {

	}
}
