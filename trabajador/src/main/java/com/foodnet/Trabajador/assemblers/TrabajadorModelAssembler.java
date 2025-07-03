package com.foodnet.Trabajador.assemblers;


import com.foodnet.Trabajador.Controller.TrabajadorControllerV2;
import com.foodnet.Trabajador.Model.Trabajador;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TrabajadorModelAssembler implements RepresentationModelAssembler<Trabajador, EntityModel<Trabajador>> {
    @Override
    public EntityModel<Trabajador> toModel(Trabajador trabajador) {
        return EntityModel.of(trabajador,
                linkTo(methodOn(TrabajadorControllerV2.class).getTrabajadorById(trabajador.getId_trabajador())).withSelfRel(),
                linkTo(methodOn(TrabajadorControllerV2.class).getAllTrabajador()).withRel("trabajadores"));
    }
}
