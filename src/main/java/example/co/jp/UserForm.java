package example.co.jp;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;


public class UserForm {
    @NotEmpty
    @Length(max = 20)
    private String name;

    public String getName(){
        return name;
    }

}
