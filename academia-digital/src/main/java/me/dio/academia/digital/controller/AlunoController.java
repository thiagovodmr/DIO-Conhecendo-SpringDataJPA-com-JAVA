package me.dio.academia.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoServiceImpl service;

    @GetMapping
    public List<Aluno> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Aluno getAlunoById(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public Aluno create(@RequestBody AlunoForm form) {
        return service.create(form);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacoesFisicas(@PathVariable Long id) {
        return service.getAllAvaliacoesFisicas(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/atualizar/{id}")
    public Aluno update(@PathVariable Long id, @RequestBody AlunoUpdateForm form) {
        return service.update(id, form);
    }

}
