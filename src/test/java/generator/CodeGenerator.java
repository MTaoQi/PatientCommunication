package generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 自动生成代码类
 */
public class CodeGenerator {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
//        System.out.println("会覆盖生成文件 确定执行吗 y/n");
//        String txt = new Scanner(System.in).nextLine();
//        if (txt.equals("n")) System.exit(0);

        FastAutoGenerator.create("jdbc:mysql://101.42.235.217:3306/patient", "root", "19990125")
                // 全局配置
                .globalConfig((scanner, builder) -> builder.author(scanner.apply("=====================全局配置=======================\n请输入作者名称？"))
                                .outputDir(System.getProperty("user.dir") + "/src/main/java")
                                .commentDate("yyyy-MM-dd hh:mm:ss")
                                .dateType(DateType.TIME_PACK)
//                        .enableSwagger()
//                                .fileOverride()
//                        .enableSwagger()
                                .disableOpenDir()
                )
                // 包配置
                .packageConfig((scanner, builder) -> builder.parent(scanner.apply("=====================包配置=======================\n请输入父包名？"))
                        .moduleName(scanner.apply("请输入包模块名？"))
                        .entity("entity")
                        .service("service")
                        .serviceImpl("serviceImpl")
                        .mapper("mapper")
                        .xml("mapper")
                        .other("pc/utils")
                        .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir") + "/src/main/resources/mapper"))
                )
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("=====================策略配置=======================\n请输入表名，多个英文逗号分隔？所有输入 all")))
                        .serviceBuilder()
                        .formatServiceFileName("%sService")
                        .formatServiceImplFileName("%sServiceImpl")
                        .entityBuilder()        //实体类策略配置
                        .enableLombok()         //开启 Lombok
                        .disableSerialVersionUID()
                        .logicDeleteColumnName("deleted")        //逻辑删除字段
                        .naming(NamingStrategy.underline_to_camel)
                        .columnNaming(NamingStrategy.underline_to_camel)
                        .addTableFills(new Column("create_time", FieldFill.INSERT), new Column("modify_time", FieldFill.INSERT_UPDATE))
                        .enableTableFieldAnnotation()       // 开启生成实体时生成字段注解
                        .controllerBuilder()
                        .formatFileName("%sController")
                        .enableRestStyle()
                        .mapperBuilder()
                        .superClass(BaseMapper.class)
                        .formatMapperFileName("%sMapper")
                        .enableMapperAnnotation()       //@mapper
                        .formatXmlFileName("%sMapper"))
                /*
                模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                .templateEngine(new BeetlTemplateEngine())*/
                .templateEngine(new FreemarkerTemplateEngine())

                .execute();
    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }



}
