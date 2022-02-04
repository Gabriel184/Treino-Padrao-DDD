package br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade;

import br.com.gabriel.treinoddd.treinopadraoddd.inbounds.facade.dto.DomainEntityDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomFacade implements IRoomFacade{
    @Override
    public DomainEntityDTO save(DomainEntityDTO entityDTO) {
        return null;
    }

    @Override
    public DomainEntityDTO update(Long id, DomainEntityDTO entityDTO) {
        return null;
    }

    @Override
    public DomainEntityDTO findById(Long id) {
        return null;
    }

    @Override
    public List<DomainEntityDTO> findAll() {
        return null;
    }

    @Override
    public DomainEntityDTO delete(Long id) {
        return null;
    }
}
