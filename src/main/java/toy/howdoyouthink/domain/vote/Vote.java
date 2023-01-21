package toy.howdoyouthink.domain.vote;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import toy.howdoyouthink.domain.member.Position;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Vote {

    @Id @GeneratedValue
    @Column(name = "vote_id")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Position target;

    private LocalDateTime deadline;

    private Integer agree;

    private Integer disagree;
}
