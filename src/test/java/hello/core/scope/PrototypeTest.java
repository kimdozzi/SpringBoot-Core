package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {
    @Test
    void prototypeBeanFind() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototypebean1");
        PrototypeBean prototypeTest1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypebean2");
        PrototypeBean prototypeTest2 = ac.getBean(PrototypeBean.class);

        System.out.println("prototypeTest1 = " + prototypeTest1);
        System.out.println("prototypeTest2 = " + prototypeTest2);

        assertThat(prototypeTest1).isNotSameAs(prototypeTest2);

        prototypeTest1.destroy();
        prototypeTest2.destroy();
        ac.close();

    }

    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");

        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.destroy");
        }
    }
}
