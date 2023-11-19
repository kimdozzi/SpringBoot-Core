package core;

import core.repository.MemberRepository;
import core.repository.MemoryMemberRepository;
import core.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    // 자바코드로 직접 스프링 빈 등록하기

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
