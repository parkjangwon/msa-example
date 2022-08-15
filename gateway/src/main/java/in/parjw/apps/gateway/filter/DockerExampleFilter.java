package in.parjw.apps.gateway.filter;

import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/*
Gateway를 구현하기 위해서는 GatewayFilterFactory를 구현해야 하며,
상속할 수 있는 추상 클래스가 바로 AbstractGatewayFilterFactory
 */
@Component
public class DockerExampleFilter extends AbstractGatewayFilterFactory<DockerExampleFilter.Config> {
    private static final Logger logger = LogManager.getLogger(DockerExampleFilter.class);

    public DockerExampleFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        /*
        exchange : 서비스 요청/응답값을 담고있는 변수로, 요청/응답값을 출력하거나 변환할 때 사용한다.
        요청값은 (exchange, chain) -> 구문 이후에 얻을 수 있으며,
        서비스로부터 리턴받은 응답값은 Mono.fromRunnable(()-> 구문 이후부터 얻을 수 있다.
         */
        return ((exchange, chain) -> {
            logger.info("DockerExampleFilter baseMessage : " + config.baseMessage);
            if (config.isPreLogger()) {
                logger.info("DockerExampleFilter Start : " + exchange.getRequest());
            }
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if (config.isPostLogger()) {
                    logger.info("DockerExampleFilter End : " + exchange.getResponse());
                }
            }));
        });
    }

    /*
    config : application.yml에 선언한 각 filter의 args(인자값) 사용을 위한 클래스
     */
    @Data
    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }
}
