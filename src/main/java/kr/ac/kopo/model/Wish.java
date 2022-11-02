package kr.ac.kopo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Wish {
    private int id;
    private String memberId;
    private int gaguId;

    @Override
    public String toString() {
        return "Wish{" +
                "id=" + id +
                ", memberId='" + memberId + '\'' +
                ", gaguId=" + gaguId +
                '}';
    }
}
