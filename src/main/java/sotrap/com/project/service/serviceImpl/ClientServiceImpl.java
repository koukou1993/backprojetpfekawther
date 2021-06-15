package sotrap.com.project.service.serviceImpl;

import org.springframework.stereotype.Service;
import sotrap.com.project.model.Client;
import sotrap.com.project.repository.ClientRepository;
import sotrap.com.project.service.ClientService;


import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    public final ClientRepository clientRepository;


    public ClientServiceImpl(ClientRepository clientRepository)
    {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAllClient() {

        return clientRepository.findAll();
    }

    @Override
    public Client getById(String id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client add(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(String id) {
        clientRepository.deleteById(id);

    }

}



