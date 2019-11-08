package com.july.test.service;

import com.july.test.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zqk
 * @since 2019-11-07
 */
public interface TeacherService extends IService<Teacher> {

    /**
     * @description 保存教师信息
     * @param teacher
     * @return
     * @author zqk
     * @since 2019/11/8
    */
    void saveTeacher(Teacher teacher);

}
