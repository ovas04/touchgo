package pe.com.touchgo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.touchgo.dao.IProductoDao;
import pe.com.touchgo.domain.Producto;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoDao productoDao;

    @Override
    public Producto findByID(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    public Producto saveProducto(Producto producto) {
        return productoDao.save(producto);    }
}
