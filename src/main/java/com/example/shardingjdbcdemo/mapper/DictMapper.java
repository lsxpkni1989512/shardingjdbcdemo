package com.example.shardingjdbcdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingjdbcdemo.entity.Dict;
import com.example.shardingjdbcdemo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface DictMapper extends BaseMapper<Dict> {
}
