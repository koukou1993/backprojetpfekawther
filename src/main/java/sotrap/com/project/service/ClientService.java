package sotrap.com.project.service;

import org.springframework.stereotype.Service;
import sotrap.com.project.model.Client;


import java.util.List;

public interface ClientService {


    public List<Client> getAllClient();

    public Client getById(String id);

    public Client update(Client client);

    public Client add(Client client);

    public void delete(String id);
}
