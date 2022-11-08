package kr.ac.kopo.validation;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberAddForm {
    @NotEmpty
    private String id;
    @NotEmpty
    private String pwd;
    @NotEmpty
    private String pwdCheck;
    @NotEmpty
    private String name;
    @NotEmpty
    private String phoneNumber;
}
