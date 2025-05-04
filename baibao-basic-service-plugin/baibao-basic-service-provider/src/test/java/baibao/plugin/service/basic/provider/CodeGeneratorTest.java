package baibao.plugin.service.basic.provider;

import kunlun.db.jdbc.support.JdbcTableLoader;
import kunlun.db.jdbc.support.function.MysqlTableCommentConsumer;
import kunlun.generator.render.support.java.JavaCodeGenConfig;
import kunlun.generator.render.support.java.JavaCodeGenerator;
import kunlun.io.file.support.JarFileLoader;
import kunlun.renderer.support.VelocityTextRenderer;
import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.util.Arrays.asList;
import static kunlun.generator.render.support.java.JavaCodeGenConfig.TemplateConfig;

/**
 * The java code generator Test.
 * @author Kahle
 */
public class CodeGeneratorTest {

    @Test
    public void generate() {
        // 模块名
        String module = "test";
        // Jdbc table loader config.
        JdbcTableLoader.Config loaderConfig = new JdbcTableLoader.Config();
        loaderConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        loaderConfig.setUrl("jdbc:mysql://127.0.0.1:3306/demo?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false&serverTimezone=CTT&nullCatalogMeansCurrent=true");
        loaderConfig.setUsername("root");
        loaderConfig.setPassword("123456");
        loaderConfig.setCatalog("demo");
        //loaderConfig.getExcludedTables().add("t_test");
        loaderConfig.getReservedTables().addAll(asList("t_test", "t_test1"));
        loaderConfig.getPostConsumers().add(new MysqlTableCommentConsumer());
        // Java code generator config.
        JavaCodeGenConfig genConfig = new JavaCodeGenConfig();
        genConfig.setTableLoader(new JdbcTableLoader());
        genConfig.setTableLoaderConfig(loaderConfig);
        genConfig.getRemovedTableNamePrefixes().add("t_");
        genConfig.setFileLoader(new JarFileLoader());
        genConfig.setRenderer(new VelocityTextRenderer());
        genConfig.setBaseTemplatePath("templates/generator/spring-boot-mybatis-plus-enhance");
        genConfig.setXmlBaseOutputPath("src\\main\\resources\\mapper\\" + module);
        genConfig.setBasePackageName("baibao.plugin.service.basic.provider." + module);
        genConfig.getCustomAttributes().put("author", "Kahle");
        genConfig.getCustomAttributes().put("useLombok", true);
        // Modify template configs.
        String javaSuffix = ".java", vueSuffix = ".vue", name, tail, pkgName;
        // [smpResult]
        name = "smpResult"; tail = "SmpResult"; pkgName = "pojo.result";
        genConfig.getTemplateConfigs().put(name, new TemplateConfig(name, tail, javaSuffix, pkgName, FALSE));
        // [param]
        genConfig.getTemplateConfigs().remove("param");
        // [addParam]
        name = "addParam"; tail = "AddParam"; pkgName = "pojo.param";
        genConfig.getTemplateConfigs().put(name, new TemplateConfig(name, tail, javaSuffix, pkgName, FALSE));
        // [editParam]
        name = "editParam"; tail = "EditParam"; pkgName = "pojo.param";
        genConfig.getTemplateConfigs().put(name, new TemplateConfig(name, tail, javaSuffix, pkgName, FALSE));
//        // [frontListVue]
//        name = "frontListVue"; tail = "List"; pkgName = "front";
//        genConfig.getTemplateConfigs().put(name, new TemplateConfig(name, tail, vueSuffix, pkgName, TRUE));
//        // [frontUpdateVue]
//        name = "frontUpdateVue"; tail = "Update"; pkgName = "front";
//        genConfig.getTemplateConfigs().put(name, new TemplateConfig(name, tail, vueSuffix, pkgName, TRUE));
        new JavaCodeGenerator().generate(genConfig);
    }

}
