package com.my.liufeng.tool;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

/**
 * https://www.baomidou.com/pages/981406/
 */
public class MybatisPlusUtils {

    /**
     * 项目基本目录
     */
    private final static String BASE_DIR = "/Users/liufeng/IdeaProjects/book-mall/cloud";

    public static void main(String[] args) {
        generator(defaultConfig("auth"));

    }


    /**
     * 生成默认配置类
     *
     * @param moduleName 模块名
     * @return 模块配置
     */
    private static ModuleConfig defaultConfig(String moduleName) {
        String url = "jdbc:mysql://127.0.0.1:3306/" + moduleName,
                username = "root",
                password = "123456",
                author = "liufeng",
                packageName = "com.my.liufeng",
                entityDir = "entity";
        return new ModuleConfig(url, username, password, author, packageName, moduleName, entityDir);
    }


    /**
     * 利用mybatis-plus生成代码
     *
     * @param moduleConfig 模块配置
     */
    private static void generator(ModuleConfig moduleConfig) {
        FastAutoGenerator generator = FastAutoGenerator.create(moduleConfig.url, moduleConfig.username, moduleConfig.password)
                .globalConfig(builder -> {
                    builder.author(moduleConfig.author) // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir() //禁止打开输出目录
                            .outputDir(BASE_DIR + "/" + moduleConfig.moduleName + "/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(moduleConfig.packageName) // 设置父包名
                            .moduleName(moduleConfig.moduleName) // 设置父包模块名
                            .entity(moduleConfig.entityDir) //设置entity包名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, BASE_DIR + "/" + moduleConfig.moduleName + "/src/main/resources/mapper")); // 设置mapperXml生成路径

                })
                .strategyConfig(builder -> {
                    builder.addTablePrefix("tb_");
                });
        generator.execute();
    }

    static class ModuleConfig {
        // 数据库配置
        String url;
        String username;
        String password;
        // 作者
        String author;
        // 包名
        String packageName;
        // 模块名
        String moduleName;
        // 实体类包名
        String entityDir;

        public ModuleConfig(String url, String username, String password, String author, String packageName, String moduleName, String entityDir) {
            this.url = url;
            this.username = username;
            this.password = password;
            this.author = author;
            this.packageName = packageName;
            this.moduleName = moduleName;
            this.entityDir = entityDir;
        }
    }
}
