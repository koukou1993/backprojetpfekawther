package sotrap.com.project.service;

import sotrap.com.project.model.ObjetReclamation;


import java.util.List;

public interface ObjetreclamationService {

    public List<ObjetReclamation> getAllObjetreclamation();

    public ObjetReclamation getById(String id);

    public ObjetReclamation update(ObjetReclamation objetReclamation);

    public ObjetReclamation add(ObjetReclamation objetReclamation);

    public void delete(String id);
}
