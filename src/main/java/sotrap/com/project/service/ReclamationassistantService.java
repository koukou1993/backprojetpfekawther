package sotrap.com.project.service;


import sotrap.com.project.model.Reclamationassistant;

import java.util.List;

public interface ReclamationassistantService {



    public Reclamationassistant getById(String id);

    public Reclamationassistant update(Reclamationassistant reclamationassistant);

    public Reclamationassistant add(Reclamationassistant reclamationassistant);

    public void delete(String id);

   public List<Reclamationassistant> getAllReclamationassistant();
}
