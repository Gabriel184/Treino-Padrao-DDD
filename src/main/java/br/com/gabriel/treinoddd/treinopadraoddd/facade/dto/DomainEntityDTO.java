package br.com.gabriel.treinoddd.treinopadraoddd.facade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class DomainEntityDTO {
    protected Long id;
    protected Boolean active;
}
