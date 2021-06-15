package sotrap.com.project.service.serviceImpl;

import org.springframework.stereotype.Service;
import sotrap.com.project.model.Typeservice;
import sotrap.com.project.repository.TypeserviceRepository;
import sotrap.com.project.service.TypeserviceService;

import java.util.List;

@Service
public class TypeserviceServiceImpl implements TypeserviceService {
    private final TypeserviceRepository typeserviceRepository;

    public TypeserviceServiceImpl(TypeserviceRepository typeserviceRepository)
    {
        this.typeserviceRepository = typeserviceRepository;
    }
    @Override
    public List<Typeservice> getAllTypeservice() {

        return typeserviceRepository.findAll();
    }

    @Override
    public Typeservice getById(String id) {
        return typeserviceRepository.findById(id).get();
    }

    @Override
    public Typeservice update(Typeservice typeservice) {
        return typeserviceRepository.save(typeservice);
    }

    @Override
    public Typeservice add(Typeservice typeservice) {
        return typeserviceRepository.save(typeservice);
    }

    @Override
    public void delete(String id) {
        typeserviceRepository.deleteById(id);

    }





}
