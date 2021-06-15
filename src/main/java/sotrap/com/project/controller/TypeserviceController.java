package sotrap.com.project.controller;

import org.springframework.web.bind.annotation.*;
import sotrap.com.project.model.Typeservice;
import sotrap.com.project.service.TypeserviceService;

import java.util.List;
@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("/typeservice")
public class TypeserviceController {
    private final TypeserviceService typeserviceService;

    public TypeserviceController(TypeserviceService typeserviceService)
    {
        this.typeserviceService= typeserviceService;
    }

    @GetMapping
    public List<Typeservice> getAllTypeservice() {
        return typeserviceService.getAllTypeservice();
    }

    @GetMapping("{id}")
    public Typeservice getById(@PathVariable String id) {
        return typeserviceService.getById(id);
    }

    @PostMapping
    public Typeservice addService(@RequestBody Typeservice typeservice) {
        return typeserviceService.add(typeservice);
    }

    @PutMapping
    public Typeservice updateService(@RequestBody Typeservice typeservice) {
        return typeserviceService.update(typeservice);
    }

    @DeleteMapping("{id}")
    public void deleteService(@PathVariable String id) {
        typeserviceService.delete(id);
    }

}
