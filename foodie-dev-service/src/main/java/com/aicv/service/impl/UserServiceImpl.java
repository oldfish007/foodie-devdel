/**
 * @开源项目 $ http://7yue.pro
 * @免费专栏 $ http://course.7yue.pro
 * @创建时间 2020-11-22 16:37
 */
package com.aicv.service.impl;

import com.aicv.mapper.StuMapper;
import com.aicv.mapper.UsersMapper;
import com.aicv.pojo.Stu;
import com.aicv.pojo.Users;
import com.aicv.pojo.bo.UserBO;
import com.aicv.service.StudService;
import com.aicv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @author oldfish
 * @date 2020-11-22 16:37
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UsersMapper usersMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameExists(String username) {
        Example userExample = new Example(Users.class);
        //创建条件
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username",username);
        Users result = usersMapper.selectOneByExample(userExample);
        return result==null?false:true;
    }

    @Override
    public Users createUser(UserBO userBO) {
        return null;
    }
}
