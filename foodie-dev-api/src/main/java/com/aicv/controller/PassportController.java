/**
 * @开源项目 $ http://7yue.pro
 * @免费专栏 $ http://course.7yue.pro
 * @创建时间 2020-11-21 17:08
 */
package com.aicv.controller;

import com.aicv.service.UserService;
import com.aicv.utils.IMOOCJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author oldfish
 * @date 2020-11-21 17:08
 * @version 1.0
 */
@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;
    @GetMapping("/usernameIsExist")
    public IMOOCJSONResult usernameExist(@RequestParam String username){
        //判断用户名是否为null
        if(StringUtils.isBlank(username)){
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }
        //查找注册的用户名是否存在
        boolean isExist = userService.queryUsernameExists(username);
        if(isExist){
            return IMOOCJSONResult.errorMsg("用户名已经存在");
        }
        //3.请求成功，用户名没有重复
        return IMOOCJSONResult.ok();
    }
}
