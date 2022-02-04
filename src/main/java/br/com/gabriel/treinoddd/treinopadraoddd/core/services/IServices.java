package br.com.gabriel.treinoddd.treinopadraoddd.core.services;

import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.DomainEntityDTO;

import java.util.List;

public interface IServices {

    DomainEntityDTO save(DomainEntityDTO entityDTO);
    DomainEntityDTO update(Long id, DomainEntityDTO entityDTO);
    DomainEntityDTO findById(Long id);
    List<DomainEntityDTO> findAll();
    DomainEntityDTO delete(Long id);

}
