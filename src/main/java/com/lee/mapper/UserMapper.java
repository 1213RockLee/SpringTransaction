package com.lee.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 005013
 * @since 2022-07-19
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
