package com.jxd.orderfood.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.orderfood.model.Emp;
import com.jxd.orderfood.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface IUserService {
    User getUserByUnameAndPwd(String uname, String pwd);
    boolean updateUserPwd(Map<String, Object> map);

    boolean deleteUserByEnames(List<String> enames);

    boolean addUser(Map<String, String> map);

    boolean editUser(Map<String, String> map);
}
