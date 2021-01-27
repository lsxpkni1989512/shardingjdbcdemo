package com.example.shardingjdbcdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_dict")
public class Dict {
    private Long dict_id;
    private String dict_val;
    private String dict_status;
}
