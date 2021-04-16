package org.wf2311.appname;

import com.wf2311.common.utils.PropertiesUtil;
import com.wf2311.spring.extend.AfterServiceStartedRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * @author <a href="mailto:wf2311@163.com">wf2311</a>
 * @since 2021/1/5 19:18.
 */
@SpringBootApplication(scanBasePackages = {"org.wf2311.appname","com.wf2311.spring.extend.exception"})
@EnableDiscoveryClient
public class APPNAME {
    @Bean
    public AfterServiceStartedRunner afterServiceStartedRunner() {
        return new AfterServiceStartedRunner();
    }

    public static void main(String[] args) {
        PropertiesUtil.putServerBootstrapTime();
        SpringApplication.run(APPNAME.class, args);
    }
}
