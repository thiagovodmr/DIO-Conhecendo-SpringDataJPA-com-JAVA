package me.dio.academia.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.impl.MatriculaServiceimpl;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    public MatriculaServiceimpl service;

    @GetMapping
    public List<Matricula> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Matricula get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public Matricula create(@RequestBody MatriculaForm form) {
        return service.create(form);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
