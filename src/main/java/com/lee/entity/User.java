package com.lee.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 005013
 * @since 2022-07-19
 */
@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    private String getString(){
        return 1 + "";
    }
}
