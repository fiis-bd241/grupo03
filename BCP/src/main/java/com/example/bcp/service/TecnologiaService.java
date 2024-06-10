package com.example.bcp.service;

import com.example.bcp.model.Tecnologia;
import com.example.bcp.repository.TecnologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class TecnologiaService implements TecnologiaRepository {

    @Autowired
    private TecnologiaRepository tecnologiaRepository;

    @Override
    public void flush() {

    }

    @Override
    public <S extends Tecnologia> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Tecnologia> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Tecnologia> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Tecnologia getOne(Long aLong) {
        return null;
    }

    @Override
    public Tecnologia getById(Long aLong) {
        return null;
    }

    @Override
    public Tecnologia getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Tecnologia> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Tecnologia> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Tecnologia> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Tecnologia> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Tecnologia> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Tecnologia> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Tecnologia, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Tecnologia> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Tecnologia> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Tecnologia> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Tecnologia> findAll() {
        return tecnologiaRepository.findAll();
    }

    @Override
    public List<Tecnologia> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Tecnologia entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Tecnologia> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Tecnologia> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Tecnologia> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Object[]> todoTecnologias() {
        return tecnologiaRepository.todoTecnologias();
    }
}
