package com.example.shardingjdbcdemo;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shardingjdbcdemo.entity.Course;
import com.example.shardingjdbcdemo.entity.Dict;
import com.example.shardingjdbcdemo.entity.User;
import com.example.shardingjdbcdemo.mapper.CourseMapper;
import com.example.shardingjdbcdemo.mapper.DictMapper;
import com.example.shardingjdbcdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.omg.SendingContext.RunTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShardingjdbcdemoApplicationTests {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DictMapper dictMapper;

    @Test
    void add() {
        for (int i = 0; i < 10; i++) {

            Course course = new Course();
            course.setCname("java"+i);
            course.setCstatus("Normal"+i);
            course.setUserId(100L);
            courseMapper.insert(course);
        }

    }

    @Test
    void queryWrapper(){
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cid",550372694076424192L);

        Course course = courseMapper.selectOne(queryWrapper);
        System.out.println(course);
    }

    @Test
    void add1() {

        Course course = new Course();
        course.setCname("java1");
        course.setCstatus("Normal1");
        course.setUserId(101L);
        courseMapper.insert(course);

    }

    @Test
    void queryWrapper2(){
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cid",1353640040131072000L);
        queryWrapper.eq("user_id",100L);

        Course course = courseMapper.selectOne(queryWrapper);
        System.out.println(course);
    }

    @Test
    void add3() {
        //参数1为终端ID
        //参数2为数据中心ID
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        // 有两种返回值类型
        long id = snowflake.nextId();
//        String nextIdStr = snowflake.nextIdStr();
        User user = new User();
        user.setUserId(id);//读写分离时，id不能自动生成，需要自己用糊涂工具包生成雪花算法的id
        user.setUserName("user4");
        user.setUserStatus("4");
        userMapper.insert(user);

    }

    @Test
    void queryWrapper3(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",1353640040131072000L);

        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    @Test
    void add4(){
        Dict dict =new Dict();
        dict.setDict_status("a");
        dict.setDict_val("已启用");
        dictMapper.insert(dict);
    }


    @Test
    void aviProce(){
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
