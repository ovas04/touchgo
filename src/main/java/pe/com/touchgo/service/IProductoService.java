package pe.com.touchgo.service;

import pe.com.touchgo.domain.Producto;

public interface IProductoService {

    Producto findByID(Long id);

    Producto saveProducto(Producto producto);

}
