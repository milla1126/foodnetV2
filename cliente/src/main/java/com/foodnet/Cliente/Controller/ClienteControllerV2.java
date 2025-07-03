package com.foodnet.Cliente.Controller;

import com.foodnet.Cliente.Model.Cliente;
import com.foodnet.Cliente.Service.ClienteService;
import com.foodnet.Cliente.assemblers.ClienteModelAssembler;
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
@RequestMapping("/api/v3/clientes")
public class ClienteControllerV2 {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteModelAssembler assembler;

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Cliente>> getAllClientes() {
        List<EntityModel<Cliente>> carreras = clienteService.listarClientes().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(carreras,
                linkTo(methodOn(ClienteControllerV2.class).getAllClientes()).withSelfRel());
    }
    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Cliente>> getClienteById(@PathVariable Integer id) {
        Optional<Cliente> cliente = clienteService.obtenerCliente(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(assembler.toModel(cliente.get()));
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Cliente>> createCliente(@RequestBody Cliente cliente) {
        Cliente newCliente = clienteService.guardarCliente(cliente);
        return ResponseEntity
                .created(linkTo(methodOn(ClienteControllerV2.class).getClienteById(newCliente.getId_cliente())).toUri())
                .body(assembler.toModel(newCliente));
    }
    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Cliente>> updateCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        cliente.setId_cliente(id);
        Cliente updatedCliente = clienteService.guardarCliente(cliente);
        return ResponseEntity
                .ok(assembler.toModel(updatedCliente));
    }
    @DeleteMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<?> deleteCliente(@PathVariable Integer id) {
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
