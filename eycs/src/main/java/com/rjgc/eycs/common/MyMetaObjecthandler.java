package com.rjgc.eycs.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 软件工程2003陈俊文
 * 学号20201002992
 * 第周作业
 */

@Component
@Slf4j
public class MyMetaObjecthandler  implements MetaObjectHandler {



    //插入操作自动填充
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("公共字段自动填充[insert]...");
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime",LocalDateTime.now());
        metaObject.setValue("createUser",BaseContext.getCurrentId());
        metaObject.setValue("updateUser",BaseContext.getCurrentId());
    }
    //更新操作自动填充
    @Override
    public void updateFill(MetaObject metaObject) {
       log.info("公共字段自动填充[update]...");
       metaObject.setValue("updateTime",LocalDateTime.now());
       metaObject.setValue("updateUser",BaseContext.getCurrentId());
    }
}
