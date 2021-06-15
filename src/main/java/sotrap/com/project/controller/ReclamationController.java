package sotrap.com.project.controller;

import org.springframework.web.bind.annotation.*;
import sotrap.com.project.model.Reclamation;
import sotrap.com.project.service.ReclamationService;


import java.util.List;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/reclamation")
public class ReclamationController {

    private final ReclamationService reclamationService;

    public  ReclamationController(ReclamationService reclamationService ){

        this.reclamationService= reclamationService;
    }


    @GetMapping
    public List<Reclamation> getAllReclamation() {
        return reclamationService.getAllReclamation();
    }

    @GetMapping("{id}")
    public Reclamation getById(@PathVariable String id) {
        return reclamationService.getById(id);
    }

    @PostMapping
    public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
        reclamation.setEtat("En cours");
        return reclamationService.add(reclamation);
    }

    @PutMapping
    public Reclamation updateReclamation(@RequestBody Reclamation reclamation) {
        return reclamationService.update(reclamation);
    }


    @DeleteMapping("{id}")
    public void deleteReclamation(@PathVariable String id) {
        reclamationService.delete(id);
    }

}

