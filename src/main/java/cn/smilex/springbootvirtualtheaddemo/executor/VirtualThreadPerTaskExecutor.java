package cn.smilex.springbootvirtualtheaddemo.executor;

import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

/**
 * @author smilex
 * @date 2022/11/18/12:44
 * @since 1.0
 */
@Component
public class VirtualThreadPerTaskExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        Thread.startVirtualThread(command);
    }
}
