package kr.ac.kopo.validation;

import kr.ac.kopo.model.Gagu;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class GaguValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return Gagu.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Gagu item = (Gagu) o;

        //검증로직
        if(!StringUtils.hasText(item.getName())){
            errors.reject("required.item.name", null, null);
        }
        if(item.getPrice() <= 1000 || item.getPrice() >= 10000000){
            errors.reject("range.item.price", new Object[]{1000, 10000000}, null);
        }
        if(item.getKeyword() == null){
            errors.reject("required.item.keyword", null, null);
        }


    }
}
