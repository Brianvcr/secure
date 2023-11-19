package pe.edu.upc.demoauthor.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoauthor.dtos.AuthorDTO;
import pe.edu.upc.demoauthor.entities.Author;
import pe.edu.upc.demoauthor.services.IAuthorService;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class AuthorController {
    @Autowired
    private IAuthorService aS;
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/author")
    public void registrar(@RequestBody AuthorDTO dto) {
        ModelMapper m = new ModelMapper();
        Author a = m.map(dto, Author.class);
        aS.insertar(a);
    }

    @PutMapping("/author")
    public void modificar(@RequestBody AuthorDTO dto) {
        ModelMapper m = new ModelMapper();
        Author a = m.map(dto, Author.class);
        aS.insertar(a);
    }
    @PreAuthorize("hasAuthority('COCO')")
    @DeleteMapping("/author/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        aS.eliminar(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/author/{id}")
    public AuthorDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        AuthorDTO dto=m.map(aS.listarId(id),AuthorDTO.class);
        return dto;
    }

    @GetMapping("/authors")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<AuthorDTO> listar() {
        return aS.listar().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,AuthorDTO.class);

        }).collect(Collectors.toList());
    }
}
