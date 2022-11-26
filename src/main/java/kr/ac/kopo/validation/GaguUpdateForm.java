package kr.ac.kopo.validation;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class GaguUpdateForm {
    @NotNull
    private int id;
    @NotEmpty
    private String name;
    @NotNull
    @Range(min = 10000, max = 10000000)
    private int price;
    @NotNull
    private String keyword;
}
