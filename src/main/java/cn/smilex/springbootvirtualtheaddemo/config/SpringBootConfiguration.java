package cn.smilex.springbootvirtualtheaddemo.config;

import cn.smilex.springbootvirtualtheaddemo.executor.VirtualThreadPerTaskExecutor;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.support.TaskExecutorAdapter;

/**
 * @author smilex
 * @date 2022/11/18/12:44
 * @since 1.0
 */
@Configuration
public class SpringBootConfiguration {
    @Bean(TaskExecutionAutoConfiguration.APPLICATION_TASK_EXECUTOR_BEAN_NAME)
    public AsyncTaskExecutor asyncTaskExecutor(VirtualThreadPerTaskExecutor virtualThreadPerTaskExecutor) {
        return new TaskExecutorAdapter(virtualThreadPerTaskExecutor);
    }

    @Bean
    public TomcatProtocolHandlerCustomizer<?> protocolHandlerVirtualThreadExecutorCustomizer(VirtualThreadPerTaskExecutor virtualThreadPerTaskExecutor) {
        return protocolHandler -> protocolHandler.setExecutor(virtualThreadPerTaskExecutor);
    }
}
