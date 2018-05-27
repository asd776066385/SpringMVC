package com.base.service.impl;

import com.alibaba.fastjson.JSON;
import com.base.dao.UserDao;
import com.base.model.UserVO;
import com.base.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestServiceImpl implements RestService {

    @Autowired
    private UserDao userDao;

    @Override
    public String getStatus() {
        List<UserVO> list = userDao.selectAllList();
        return JSON.toJSONString(list);
    }
}
