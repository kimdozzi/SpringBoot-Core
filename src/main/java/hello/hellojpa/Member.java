package hello.hellojpa;

import javax.persistence.*;

@Entity // JPA가 관리, 엔티티라 함. 기본 생성자 필수, 저장할 필드에 final 사용 X
@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR", sequenceName = "MEMBER_SEQ")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    @Column(name = "name", nullable = false) // db 컬럼명은 name
    private String username; // 객체는 username

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Member() {
    }
}
