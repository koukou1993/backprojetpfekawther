package sotrap.com.project.controller;

import org.springframework.web.bind.annotation.*;
import sotrap.com.project.model.ObjetReclamation;
import sotrap.com.project.service.ObjetreclamationService;


import java.util.List;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/objetreclamation")
public class ObjetReclamationController {

   private final ObjetreclamationService objetreclamationService;

    public ObjetReclamationController(ObjetreclamationService objetreclamationService) {
        this.objetreclamationService = objetreclamationService;
    }

    @GetMapping
    public List<ObjetReclamation> getAllTypeservice() {
        return objetreclamationService.getAllObjetreclamation();
    }

    @GetMapping("{id}")
    public ObjetReclamation getById(@PathVariable String id) {
        return objetreclamationService.getById(id);
    }

    @PostMapping
    public ObjetReclamation addObjetreclamation(@RequestBody ObjetReclamation objetReclamation) {
        return objetreclamationService.add(objetReclamation);
    }

    @PutMapping
    public ObjetReclamation updateObjetreclamation(@RequestBody ObjetReclamation objetReclamation) {
        return objetreclamationService.update(objetReclamation);
    }

    @DeleteMapping("{id}")
    public void deleteObjetreclamation(@PathVariable String id) {
        objetreclamationService.delete(id);
    }

}
