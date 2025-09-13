package s28216.g33c.masfinal.controllers;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Scope("singleton")
public class SharedFormData {
    private int idK;
    private int idF;

}