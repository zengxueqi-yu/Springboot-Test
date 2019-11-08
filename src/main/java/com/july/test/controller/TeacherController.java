package com.july.test.controller;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.july.test.config.Result;
import com.july.test.entity.Teacher;
import com.july.test.service.TeacherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 * @author zqk
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    /**
     * @description 保存教师信息
     * @param
     * @return
     * @author zqk
     * @since 2019/11/8
    */
    @PostMapping("/saveTeacher")
    public Result saveTeacher(@RequestBody Teacher teacher){
        teacherService.saveTeacher(teacher);
        return Result.ok("保存成功");
    }

}
