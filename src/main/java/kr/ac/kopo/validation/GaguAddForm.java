package kr.ac.kopo.validation;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter
public class GaguAddForm {
    @NotEmpty
    private String name;
    @NotNull
    @Range(min = 10000, max = 10000000)
    private int price;
    @NotEmpty
    private String keyword;
    private List<MultipartFile> attach;
}
