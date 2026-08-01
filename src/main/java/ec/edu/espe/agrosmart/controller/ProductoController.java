package ec.edu.espe.agrosmart.controller;

import ec.edu.espe.agrosmart.domain.Producto;
import ec.edu.espe.agrosmart.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<Producto> listarProductos() {
        return service.obtenerProductosComercializables();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Producto>> obtenerProducto(
            @PathVariable Long id) {

        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}