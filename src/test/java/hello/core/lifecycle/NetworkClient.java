package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;
    public void setUrl(String url) {
        this.url = url;
    }

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);

    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect : " + url);

    }

    public void call(String msg) {
        System.out.println("call : " + url + " message = " + msg);

    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close " + url);
    }


    @Override
    // 의존 관계 주입이 끝나면 호출해주겠다.
    public void afterPropertiesSet() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}