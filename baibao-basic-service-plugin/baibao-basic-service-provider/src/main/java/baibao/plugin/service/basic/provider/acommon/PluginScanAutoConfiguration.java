package baibao.plugin.service.basic.provider.acommon;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 插件 Jar 的 Spring 组件扫描.
 * @author Kahle
 */
@Slf4j
@Configuration
@ComponentScan({"baibao.plugin.service.basic"})
@MapperScan(basePackages = {"baibao.plugin.service.basic.provider.*.mapper"})
public class PluginScanAutoConfiguration {

    public PluginScanAutoConfiguration() {

        log.info("The plugin \"baibao-basic-service-plugin\" is enabled successfully. ");
    }

}
