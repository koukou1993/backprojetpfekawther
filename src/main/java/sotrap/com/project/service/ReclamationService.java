package sotrap.com.project.service;


import sotrap.com.project.model.Reclamation;

import java.util.List;

public interface ReclamationService {

    public List<Reclamation> getAllReclamation();

    public Reclamation getById(String id);

    public Reclamation update(Reclamation reclamtion);

    public Reclamation add(Reclamation reclamtion);

    public void delete(String id);
}
