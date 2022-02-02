package br.com.gabriel.treinoddd.treinopadraoddd.facade.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonDTO extends DomainEntityDTO{
    private String name;
    private Integer age;
}
