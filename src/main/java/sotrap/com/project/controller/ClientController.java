package sotrap.com.project.controller;

import org.springframework.web.bind.annotation.*;
import sotrap.com.project.model.Client;
import sotrap.com.project.service.ClientService;


import java.util.List;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/client")
public class ClientController {


    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAllEmployee() {
        return clientService.getAllClient();
    }

    @GetMapping("{id}")
    public Client getById(@PathVariable String id) {
        return clientService.getById(id);
    }

    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientService.add(client);
    }

    @PutMapping
    public Client updateClient(@RequestBody Client client) {
        return clientService.update(client);
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable String id) {
        clientService.delete(id);
    }

}

