package br.com.gabriel.treinoddd.treinopadraoddd.core.services;

import br.com.gabriel.treinoddd.treinopadraoddd.core.entities.DomainEntity;

import java.util.List;

public interface IServices {

    DomainEntity save(DomainEntity entity);
    DomainEntity update(Long id, DomainEntity entity);
    DomainEntity findById(Long id);
    List<DomainEntity> findAll();
    DomainEntity delete(Long id);

}
