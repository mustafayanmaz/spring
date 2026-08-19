package com.musyan.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.apache.el.ValueExpressionLiteral;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "Bu Alan Boş Bırakıılamaz")
    @Min(value = 3, message = "Minumum 3 karakter")
    @Max(value = 15, message = "Maksimum 15 karakter")
    private String firstName;

    @NotEmpty(message = "Bu Alan Boş Bırakılamaz")
    @Size(min = 3, max = 15)
    private String lastName;

    private Date birthOfDate;

    @Email(message = "Email formatında bi adres girin")
    private String email;

    @Size(min = 11, max = 11, message = "Tckn alanı 11 karakter olmalıdır")
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    private String tckn;

}
