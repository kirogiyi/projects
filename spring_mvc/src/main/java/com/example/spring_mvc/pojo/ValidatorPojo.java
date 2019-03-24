package com.example.spring_mvc.pojo;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class ValidatorPojo {
    @NotNull(message = "Id can't be null.")
    private Long id;

    @Future(message = "It need a future date.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date date;

    @NotNull
    @DecimalMin(value = "0.1")
    @DecimalMax(value = "10000.00")
    private Double doubleValue = null;

    @Min(value = 1, message = "The min value is 1.")
    @Max(value = 88, message = "The max value is 88")
    @NotNull
    private Integer integer;

    @Range(min = 1, max = 888, message = "The range is 0 to 888.")
    private Long range;

    @Email(message = "The mailbox format is error.")
    private String email;

    @Size(min = 20, max = 30, message = "The string length should be between 20 and 30.")
    private String size;
}
