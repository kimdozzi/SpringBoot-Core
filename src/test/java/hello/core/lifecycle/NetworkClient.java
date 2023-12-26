package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("coonect: "+url);
    }

    public void call(String msg) {
        System.out.println("call: " + url + " msg: " + msg);
    }
    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close " + url);
    }

    @PostConstruct
    public void init(){
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close(){
        disconnect();
    }
}
