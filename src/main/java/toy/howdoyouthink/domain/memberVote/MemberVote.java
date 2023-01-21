package toy.howdoyouthink.domain.memberVote;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.jmx.export.annotation.ManagedNotification;
import toy.howdoyouthink.domain.member.Member;
import toy.howdoyouthink.domain.vote.Vote;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberVote {

    @Id @GeneratedValue
    @Column(name = "member_vote_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "vote_id")
    private Vote vote;

    private Boolean agree;
}
