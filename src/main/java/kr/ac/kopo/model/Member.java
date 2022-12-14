package kr.ac.kopo.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Member {
    private String id;
    private String pwd;
    private String pwdCheck;
    private String name;
    private String phoneNumber;
    private String signupOk;

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", signupOk='" + signupOk + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
