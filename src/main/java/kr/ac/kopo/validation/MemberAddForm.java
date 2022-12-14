package kr.ac.kopo.validation;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberAddForm {
    @NotEmpty
    private String id;
    @NotEmpty
    @Length(min = 4)
    private String pwd;
    @NotEmpty
    @Length(min = 4)
    private String pwdCheck;
    @NotEmpty
    private String name;
    @NotEmpty
    @Length(max = 11)
    private String phoneNumber;
}
