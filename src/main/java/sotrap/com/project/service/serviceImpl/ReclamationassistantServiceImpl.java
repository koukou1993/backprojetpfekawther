package sotrap.com.project.service.serviceImpl;

import org.springframework.stereotype.Service;


import sotrap.com.project.model.Reclamationassistant;
import sotrap.com.project.repository.ReclamationassistantRepository;
import sotrap.com.project.service.ReclamationassistantService;

import java.util.List;


@Service
public class ReclamationassistantServiceImpl implements ReclamationassistantService {

    private final ReclamationassistantRepository reclamationassistantRepository;

    public ReclamationassistantServiceImpl(ReclamationassistantRepository reclamationassistantRepository)
    {
        this.reclamationassistantRepository = reclamationassistantRepository;
    }

    @Override
    public List<Reclamationassistant> getAllReclamationassistant() {

        return reclamationassistantRepository.findAll();
    }

    @Override
    public Reclamationassistant getById(String id) {
        return reclamationassistantRepository.findById(id).get();
    }

    @Override
    public Reclamationassistant update(Reclamationassistant reclamationassistant) {
        return reclamationassistantRepository.save(reclamationassistant);
    }

    @Override
    public Reclamationassistant add(Reclamationassistant reclamationassistant) {
        return reclamationassistantRepository.save(reclamationassistant);
    }

    @Override
    public void delete(String id) {
        reclamationassistantRepository.deleteById(id);

    }
}


