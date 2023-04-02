package com.dragon.userservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Document(collation = "user")  名字一样可省略
public class User implements Serializable {

//    @Id  //名字一样课省略
    private String id;
    private String name;
    @Indexed
    private Integer userid;

}
