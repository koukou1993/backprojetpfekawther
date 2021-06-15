package sotrap.com.project.controller;

import org.springframework.web.bind.annotation.*;

import sotrap.com.project.model.Reclamationassistant;

import sotrap.com.project.service.ReclamationassistantService;

import java.util.List;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/reclamationassistant")
public class ReclamationassistantController {

    private final ReclamationassistantService reclamationassistantService;

    public  ReclamationassistantController(ReclamationassistantService reclamationassistantService ){

        this.reclamationassistantService= reclamationassistantService;
    }


    @GetMapping
    public List<Reclamationassistant> getAllReclamationassistant() {
        return reclamationassistantService.getAllReclamationassistant();
    }

    @GetMapping("{id}")
    public Reclamationassistant getById(@PathVariable String id) {
        return reclamationassistantService.getById(id);
    }

    @PostMapping
    public Reclamationassistant addReclamationassistant(@RequestBody Reclamationassistant reclamationassistant) {
        reclamationassistant.setEtat("En cours");
        return reclamationassistantService.add(reclamationassistant);
    }

    @PutMapping
    public Reclamationassistant updateReclamationassistant(@RequestBody Reclamationassistant reclamationassistant) {
        return reclamationassistantService.update(reclamationassistant);
    }


    @DeleteMapping("{id}")
    public void deleteReclamationassistant(@PathVariable String id) {
        reclamationassistantService.delete(id);
    }

}



