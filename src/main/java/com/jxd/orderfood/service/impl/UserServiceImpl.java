package com.jxd.orderfood.service.impl;

import com.jxd.orderfood.dao.EmpMapper;
import com.jxd.orderfood.dao.OrderInfoMapper;
import com.jxd.orderfood.dao.UserMapper;
import com.jxd.orderfood.model.User;
import com.jxd.orderfood.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author lixianzhao
 * @Date 2023/2/5
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private UserMapper userMapper;
    /**
     * 用户登录
     * @param uname 用户名
     * @param pwd 密码
     * @return
     */
    @Override
    public User getUserByUnameAndPwd(String uname, String pwd) {
        return userMapper.getUserByUnameAndPwd(uname, pwd);
    }
    @Override
    public boolean updateUserPwd(Map<String, Object> map) {
        return userMapper.updatePwd(map);
    }

    @Override
    public boolean deleteUserByEnames(List<String> enames) {
        return userMapper.deleteUserByEnames(enames);
    }

    @Override
    public boolean addUser(Map<String, String> map) {
        return userMapper.insertUser(map);
    }

    @Override
    public boolean editUser(Map<String, String> map) {
        return userMapper.updateUser(map);
    }
}
