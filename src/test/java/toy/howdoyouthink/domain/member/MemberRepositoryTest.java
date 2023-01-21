package toy.howdoyouthink.domain.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
//@Transactional
@Rollback(value = true)
class MemberRepositoryTest {

    @Autowired private MemberRepository memberRepository;

//    @BeforeEach
//    void init() {
//        memberRepository.clear();
//    }

    @Test
    public void save(){
        //given
        Member member0 = Member.builder()
                .name("member0")
                .build();
        Member savedMember = memberRepository.save(member0);
        Long memberId = savedMember.getId();

        //when
        Member findMember = memberRepository.findById(memberId).get();

        //then
        assertThat(findMember).isEqualTo(member0);
    }

    @Test
    public void findAll() throws Exception{
        //given
        Member member0 = Member.builder()
                .name("member0")
                .build();

        Member member1 = Member.builder()
                .name("member1")
                .build();

        memberRepository.save(member0);
        memberRepository.save(member1);
        //when
        List<Member> members = memberRepository.findAll();

        //then
        assertThat(members.size()).isEqualTo(2);
        assertThat(members).containsExactly(member0, member1);
    }

    @Test
    @DisplayName("아이디 중복검사 성공")
    public void existByLoginIdTestSuc() throws Exception{
        //given
        Member member0 = Member.builder()
                .name("member0")
                .loginId("iiiiiiiiid0")
                .build();

        Member member1 = Member.builder()
                .name("member1")
                .loginId("iiiiiiiiid1")
                .build();

        memberRepository.save(member0);
        memberRepository.save(member1);

        //when
        Boolean result = memberRepository.existsByLoginId("iiiiiiiiid0");

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("아이디 중복검사 실패")
    public void existByLoginIdTestFail() throws Exception{
        //given
        Member member0 = Member.builder()
                .name("member0")
                .loginId("iiiiiiiiid0")
                .build();

        Member member1 = Member.builder()
                .name("member1")
                .loginId("iiiiiiiiid1")
                .build();

        memberRepository.save(member0);
        memberRepository.save(member1);

        //when
        Boolean result = memberRepository.existsByLoginId("iiiiiiiiid3");

        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("loginId, password로 회원 찾기 성공")
    void findMemberByLoginIdAndPasswordSucTest() {

        String loginId = "iiiiiiiiid0";
        String password = "12345678";

        Member member0 = Member.builder()
                .name("member0")
                .loginId(loginId)
                .password(password)
                .build();

        memberRepository.save(member0);

        Member findMember = memberRepository.findByLoginIdAndPassword(loginId, password).get();

        assertThat(findMember).isEqualTo(member0);
    }

    @Test
    @DisplayName("loginId, password로 회원 찾기 실패")
    void findMemberByLoginIdAndPasswordFailTest() {

        String loginId = "iiiiiiiiid0";
        String password = "12345678";

        Member member0 = Member.builder()
                .name("member0")
                .loginId(loginId)
                .password(password)
                .build();

        Member member1 = Member.builder()
                .name("member0")
                .loginId("loginId1")
                .password(password)
                .build();

        memberRepository.save(member0);
        memberRepository.save(member1);

        Member findMember = memberRepository.findByLoginIdAndPassword("loginId1", password).get();

        assertThat(findMember).isNotEqualTo(member0);
    }
}