package com.generation.pokemarket.service;

import com.generation.pokemarket.models.Producto;
import com.generation.pokemarket.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto saveProducto(Producto nuevoProducto) {
        return productoRepository.save(nuevoProducto);
    }
}
