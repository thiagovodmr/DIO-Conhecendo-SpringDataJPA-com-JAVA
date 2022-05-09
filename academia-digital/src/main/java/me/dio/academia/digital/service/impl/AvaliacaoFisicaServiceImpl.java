package me.dio.academia.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {
    @Autowired
    private AvaliacaoFisicaRepository avaliacaoRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacao = new AvaliacaoFisica();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        avaliacao.setAluno(aluno);
        avaliacao.setPeso(form.getPeso());
        avaliacao.setAltura(form.getAltura());

        return avaliacaoRepository.save(avaliacao);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return avaliacaoRepository.findById(id).get();
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica avaliacao = avaliacaoRepository.findById(id).get();
        avaliacao.setPeso(formUpdate.getPeso());
        avaliacao.setAltura(formUpdate.getAltura());

        return avaliacaoRepository.save(avaliacao);
    }

    @Override
    public void delete(Long id) {
        avaliacaoRepository.deleteById(id);
    }

}
