package com.generation.pokemarket.service;

import com.generation.pokemarket.models.Producto;
import com.generation.pokemarket.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Transactional
    public Producto saveProducto(Producto nuevoProducto) {
        return productoRepository.save(nuevoProducto);
    }

    public List<Producto> getListaProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).get();
    }
}
