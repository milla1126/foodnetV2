package com.foodnet.Trabajador.Controller;

import com.foodnet.Trabajador.Model.Trabajador;
import com.foodnet.Trabajador.Service.TrabajadorService;
import com.foodnet.Trabajador.assemblers.TrabajadorModelAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v3/trabajadores")
public class TrabajadorControllerV2 {
    @Autowired
    private TrabajadorService trabajadorService;
    @Autowired
    private TrabajadorModelAssembler assembler;

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Trabajador>> getAllTrabajador() {
        List<EntityModel<Trabajador>> trabajador = trabajadorService.listarTrabajadores().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(trabajador,
                linkTo(methodOn(TrabajadorControllerV2.class).getAllTrabajador()).withSelfRel());
    }
    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Trabajador>> getTrabajadorById(@PathVariable Integer id) {
        Optional<Trabajador> trabajador = trabajadorService.obtenerTrabajador(id);
        if (trabajador.isPresent()) {
            return ResponseEntity.ok(assembler.toModel(trabajador.get()));
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Trabajador>> createTrabajador(@RequestBody Trabajador trabajador) {
        Trabajador newTrabajador = trabajadorService.guardarTrabajador(trabajador);
        return ResponseEntity
                .created(linkTo(methodOn(TrabajadorControllerV2.class).getTrabajadorById(newTrabajador.getId_trabajador())).toUri())
                .body(assembler.toModel(newTrabajador));
    }
    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Trabajador>> updateTrabajador(@PathVariable Integer id, @RequestBody Trabajador trabajador) {
        trabajador.setId_trabajador(id);
        Trabajador updatedTrabajador = trabajadorService.guardarTrabajador(trabajador);
        return ResponseEntity
                .ok(assembler.toModel(updatedTrabajador));
    }
    @DeleteMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<?> deleteTrabajador(@PathVariable Integer id) {
        trabajadorService.eliminarTrabajador(id);
        return ResponseEntity.noContent().build();
    }
}

