package com.july.test.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 
 * </p>
 *
 * @author zqk
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
public class Teacher{

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 教师姓名
     */
    @TableField("teacherName")
    private String teacherName;

    /**
     * 性别
     */
    @TableField("sex")
    private String sex;

    /**
     * 联系电话
     */
    @TableField("mobile")
    private String mobile;

}
