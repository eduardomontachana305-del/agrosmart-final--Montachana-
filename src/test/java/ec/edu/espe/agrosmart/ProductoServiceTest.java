package ec.edu.espe.agrosmart;

import ec.edu.espe.agrosmart.entity.ProductoEntity;
import ec.edu.espe.agrosmart.repository.ProductoRepository;
import ec.edu.espe.agrosmart.service.ProductoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.util.List;

class ProductoServiceTest {

    @Test
    void debeObtenerProductosComercializables() {

        ProductoRepository repository =
                Mockito.mock(ProductoRepository.class);

        ProductoEntity producto = new ProductoEntity();
        producto.setIdProducto(1L);
        producto.setNombreProducto("Quinua Blanca Premium");
        producto.setCategoria("Quinua");
        producto.setPrecioUsd(new BigDecimal("3.50"));
        producto.setStockKg(100);
        producto.setCorreosNotificacion(
                "compras@tiendasaludable.com"
        );

        Mockito.when(repository.findAll())
                .thenReturn(List.of(producto));

        ProductoService service =
                new ProductoService(repository);

        Flux<?> resultado =
                service.obtenerProductosComercializables();

        StepVerifier.create(resultado)
                .expectNextCount(1)
                .verifyComplete();
    }
}