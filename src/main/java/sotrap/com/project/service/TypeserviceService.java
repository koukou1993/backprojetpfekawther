package sotrap.com.project.service;

import sotrap.com.project.model.Typeservice;

import java.util.List;

public interface TypeserviceService {
    public List<Typeservice> getAllTypeservice();

    public Typeservice getById(String id);

    public Typeservice update(Typeservice typeservice);

    public Typeservice add( Typeservice typeservice );

    public void delete(String id);
}
