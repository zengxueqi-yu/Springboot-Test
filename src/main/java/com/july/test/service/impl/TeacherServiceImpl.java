package com.july.test.service.impl;

import com.july.test.entity.Teacher;
import com.july.test.mapper.TeacherMapper;
import com.july.test.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zqk
 * @since 2019-11-07
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    /**
     * @description 保存教师信息
     * @param teacher
     * @return
     * @author zqk
     * @since 2019/11/8
    */
    @Override
    public void saveTeacher(Teacher teacher) {
        this.save(teacher);
    }
}
