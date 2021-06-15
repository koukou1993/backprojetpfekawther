package sotrap.com.project.service.serviceImpl;

import org.springframework.stereotype.Service;
import sotrap.com.project.model.Reclamation;
import sotrap.com.project.repository.ReclamationRepository;
import sotrap.com.project.service.ReclamationService;

import java.util.List;

@Service
public class ReclamationServiceImpl implements ReclamationService {

    private final ReclamationRepository reclamationRepository;

   public ReclamationServiceImpl(ReclamationRepository reclamationRepository){

       this.reclamationRepository=reclamationRepository;
   }

    @Override
    public List<Reclamation> getAllReclamation() {

        return reclamationRepository.findAll();
    }

    @Override
    public Reclamation getById(String id) {
        return reclamationRepository.findById(id).get();
    }

    @Override
    public Reclamation update(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public Reclamation add(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public void delete(String id) {
        reclamationRepository.deleteById(id);

    }
}


