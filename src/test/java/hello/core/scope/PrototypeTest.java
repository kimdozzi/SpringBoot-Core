package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class PrototypeTest {
    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(prototypeBean.class);
        System.out.println("find prototypebean 1");
        prototypeBean bean1 = ac.getBean(prototypeBean.class);
        System.out.println("find prototypebean 2");
        prototypeBean bean2 = ac.getBean(prototypeBean.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        assertThat(bean1).isNotSameAs(bean2);

        /*
        * 싱글톤 빈은 스프링 컨테이너 생성 시점에 초기화 메서드가 실행되지만,
        * 프로토타입 스코프 빈은 스프링 컨테이너에서 빈을 조회할 때 생성되고, 초기화 메서드도 실행된다.
        * 프로토타입 빈을 2번 조회했으므로 완전히 다른 스프링 빈이 생성되고 초기화도 2번 실행된 것을 볼 수 있다.
        * */

        // close해도 close가 안뜬다..! => 수동으로 관리해야함
        bean1.destroy();
        bean2.destroy();
        ac.close();
    }

    @Scope("prototype")
    static class prototypeBean {
        @PostConstruct
        public void init(){
            System.out.println("prototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("prototypeBean.destroy");
        }
    }
}
