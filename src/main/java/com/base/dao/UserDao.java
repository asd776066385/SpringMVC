package com.base.dao;

import com.base.model.UserVO;
import java.util.List;
import java.util.Map;

public interface UserDao {

    int insert(UserVO record);

    int selectCount(String name);

    List<UserVO> selectAllList();

    List<UserVO> selectList(Map<String, Object> map);
}