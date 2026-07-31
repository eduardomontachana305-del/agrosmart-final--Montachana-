package ec.edu.espe.agrosmart.config;

import ec.edu.espe.agrosmart.entity.ProductoEntity;
import ec.edu.espe.agrosmart.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner cargarProductos(ProductoRepository repository) {
        return args -> {
            if (repository.count() == 0) {
ProductoEntity producto1 = new ProductoEntity();
producto1.setNombreProducto("Quinua Blanca Premium");
producto1.setPrecioUsd(new BigDecimal("3.50"));
producto1.setStockKg(100);
producto1.setCategoria("Quinua");
producto1.setCorreosNotificacion("compras@tiendasaludable.com");

repository.save(producto1);
ProductoEntity producto2 = new ProductoEntity();
producto2.setNombreProducto("Quinua Amarilla Andina");
producto2.setPrecioUsd(new BigDecimal("4.20"));
producto2.setStockKg(75);
producto2.setCategoria("Quinua");
producto2.setCorreosNotificacion("inventario@tiendasaludable.com");

repository.save(producto2);
ProductoEntity producto3 = new ProductoEntity();
producto3.setNombreProducto("Quinua Roja Orgánica");
producto3.setPrecioUsd(new BigDecimal("5.10"));
producto3.setStockKg(60);
producto3.setCategoria("Quinua");
producto3.setCorreosNotificacion("ventas@tiendasaludable.com");

repository.save(producto3);
ProductoEntity producto4 = new ProductoEntity();
producto4.setNombreProducto("Quinua Rosada");
producto4.setPrecioUsd(new BigDecimal("0.00"));
producto4.setStockKg(40);
producto4.setCategoria("Quinua");
producto4.setCorreosNotificacion("pedidos@tiendasaludable.com");

repository.save(producto4);
ProductoEntity producto5 = new ProductoEntity();
producto5.setNombreProducto("Quinua Perla Natural");
producto5.setPrecioUsd(new BigDecimal("3.80"));
producto5.setStockKg(50);
producto5.setCategoria("Quinua");
producto5.setCorreosNotificacion("");

repository.save(producto5);
            }
        };
    }

}