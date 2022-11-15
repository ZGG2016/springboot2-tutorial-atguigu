package org.zgg.springboot_web_02.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    // 字段在数据库不存在
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;

    // 数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
