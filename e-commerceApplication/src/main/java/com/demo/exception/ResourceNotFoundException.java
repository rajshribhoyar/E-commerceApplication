package com.demo.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String name;
    private String fieldName;
    private Object fieldValue;
    public ResourceNotFoundException(String name, String fieldName, Object fieldValue) {
        super(String.format("%s : '%s'",name, fieldName, fieldValue));
        this.name = name;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getName() {
        return name;
    }
    public String getFieldName() {
        return fieldName;
    }
    public Object getFieldValue() {
        return fieldValue;
    }
}
