package sotrap.com.project.service.serviceImpl;

import org.springframework.stereotype.Service;
import sotrap.com.project.model.ObjetReclamation;
import sotrap.com.project.repository.ObjetreclamationRepository;
import sotrap.com.project.service.ObjetreclamationService;

import java.util.List;

@Service
public class ObjetreclamationServiceImpl implements ObjetreclamationService {

    private final ObjetreclamationRepository objetreclamationRepository;

    public ObjetreclamationServiceImpl(ObjetreclamationRepository objetreclamationRepository) {

        this.objetreclamationRepository = objetreclamationRepository;
    }

    @Override
    public List<ObjetReclamation> getAllObjetreclamation() {

        return objetreclamationRepository.findAll();
    }

    @Override
    public ObjetReclamation getById(String id) {
        return objetreclamationRepository.findById(id).get();
    }

    @Override
    public ObjetReclamation update(ObjetReclamation objetReclamation) {
        return objetreclamationRepository.save(objetReclamation);
    }

    @Override
    public ObjetReclamation add(ObjetReclamation objetReclamation) {
        return objetreclamationRepository.save(objetReclamation);
    }

    @Override
    public void delete(String id) {
        objetreclamationRepository.deleteById(id);

    }
}

