package toy.howdoyouthink.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toy.howdoyouthink.domain.member.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Boolean existsByLoginId(String loginId);

    Optional<Member> findByLoginId(String loginId);

    Optional<Member> findByLoginIdAndPassword(String loginId, String password);
}
