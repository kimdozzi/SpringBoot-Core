package core.repository;

import core.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // test 완료
    Member save(Member member);

    // test 완료
    Optional<Member> findByName(String name);

    // test 완료
    List<Member> findAll();

    Optional<Member> findById(Long id);


    void clearStore();
}
