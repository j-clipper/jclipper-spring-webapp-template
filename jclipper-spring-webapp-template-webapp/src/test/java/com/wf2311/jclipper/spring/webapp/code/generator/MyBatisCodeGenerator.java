package com.wf2311.jclipper.spring.webapp.code.generator;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Mybatis 代码生成器
 *
 * @author wf2311
 */
public class MyBatisCodeGenerator extends AbstractMyBatisCodeGenerator {

    @BeforeEach
    public void before() {
        super.init();
    }

    protected void initDataSourceConfig() {
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        //TODO 替换为对应的数据库连接地址
        dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/test?useSSL=false");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
    }

    @Test
    @DisplayName("生成模块1的表代码")
    public void generateModule1Tables() {
        //TODO 替换为真实的表名
        String[] tables = {"prefix_table3", "prefix_table4"};
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.wf2311.jclipper.spring.webapp");

        //TODO 替换 <Module2> 为真实的模块名
        pc.setController("controller");
        pc.setEntity("<Module1>.model");
        pc.setService("<Module1>.service");
        pc.setServiceImpl("<Module1>.service.impl");
        pc.setMapper("<Module1>.dao.mybatis");
        //TODO 替换为真实的表前缀
        String[] tablePrefix = {"prefix_"};

        generate(pc, tablePrefix, tables);
    }

    @Test
    @DisplayName("生成模块1的表代码")
    public void generateModule2Tables() {
        //TODO 替换为真实的表名
        String[] tables = {"prefix_table3", "prefix_table4"};
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.wf2311.jclipper.spring.webapp");

        //TODO 替换 <Module2> 为真实的模块名
        pc.setController("controller");
        pc.setEntity("<Module2>.model");
        pc.setService("<Module2>.service");
        pc.setServiceImpl("<Module2>.service.impl");
        pc.setMapper("<Module2>.dao.mybatis");
        //TODO 替换为真实的表前缀
        String[] tablePrefix = {"prefix_"};

        generate(pc, tablePrefix, tables);
    }


}
