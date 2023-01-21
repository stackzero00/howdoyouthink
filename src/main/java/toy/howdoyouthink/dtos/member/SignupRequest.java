package toy.howdoyouthink.dtos.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import toy.howdoyouthink.domain.member.Major;
import toy.howdoyouthink.domain.member.Position;
import toy.howdoyouthink.validation.enumValidation.ValidEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

    @NotNull
    @Size(min = 8, max = 12)
    private String loginId;

    @NotNull
    @Size(min = 8, max = 12)
    private String password;

    @ValidEnum(enumClass = Major.class)
    @NotNull
    private Major major;

    @NotNull
    private String name;

    @NotNull
    private String studentId;

    @ValidEnum(enumClass = Position.class)
    @NotNull
    private Position position;

}
