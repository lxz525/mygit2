package com.jxd.orderfood.dao;

import com.jxd.orderfood.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User getUserByUnameAndPwd(String uname, String pwd);
    boolean updatePwd(@Param("map") Map<String, Object> map);

    boolean deleteUserByEnames(List<String> enames);

    boolean insertUser(Map<String, String> map);

    boolean updateUser(Map<String, String> map);
}
