package com.dragon.userservice.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_info")
public class UserInfo {

    @TableField(exist = false)
    private String userName;

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    private String name;
    private String sex;
    private Integer age;
    private String phone;
    private String address;
    private Integer capital;       //资金
    private Integer jurisdiction;  //权限（0是超级用户，1是一级用户，2是二级用户）

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    private Integer deleted;
}
