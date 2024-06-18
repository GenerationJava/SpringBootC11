package com.generation.pokemarket.controller;


import com.generation.pokemarket.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {


    @Autowired
    private ProductoService productoService;


    @GetMapping("/lista")
    public ResponseEntity<?> obtenerListaProductos() {
        return new ResponseEntity<>(productoService.getListaProductos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProductoPorId(Long id) {
        return new ResponseEntity<>(productoService.getProductoById(id), HttpStatus.OK);
    }




}
