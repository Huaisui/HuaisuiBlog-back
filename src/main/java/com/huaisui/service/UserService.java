package com.huaisui.service;

import com.huaisui.dao.UserMapper;
import com.huaisui.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class UserService implements IUserService{
    @Override
    public boolean ifLoginSuccess(String id,String password) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String userPassword;
        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            userPassword = mapper.getUserPassword(id);
            if (userPassword == null || !userPassword.equals(password)) {
                System.out.println("userPassword != password");
                return false;
            }
            else return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            sqlSession.close();
        }
    }
}
