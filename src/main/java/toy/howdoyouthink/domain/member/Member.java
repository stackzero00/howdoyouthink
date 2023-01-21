package toy.howdoyouthink.domain.member;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Major major;

    private String studentId;

    @Enumerated(EnumType.STRING)
    private Position position;

    @Size(min = 5, max = 12)
    private String loginId;

    @Size(min=5, max = 12)
    private String password;
}
