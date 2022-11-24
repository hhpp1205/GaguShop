package kr.ac.kopo.validation;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberPwdUpdateForm {
    @NotEmpty
    private String id;
    @NotEmpty
    @Length(min = 4)
    private String pwd;
    @NotEmpty
    @Length(min = 4)
    private String pwdCheck;
}
