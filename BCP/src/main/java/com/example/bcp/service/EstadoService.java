package com.example.bcp.service;

import com.example.bcp.model.Estado;
import com.example.bcp.repository.EstadoRepository;
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
public class EstadoService implements EstadoRepository {

    @Autowired
    private EstadoRepository estadoRepository;


    @Override
    public void flush() {

    }

    @Override
    public <S extends Estado> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Estado> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Estado> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Estado getOne(Long aLong) {
        return null;
    }

    @Override
    public Estado getById(Long aLong) {
        return null;
    }

    @Override
    public Estado getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Estado> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Estado> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Estado> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Estado> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Estado> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Estado> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Estado, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Estado> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Estado> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Estado> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Estado> findAll() {

        return estadoRepository.findAll();
    }

    @Override
    public List<Estado> findAllById(Iterable<Long> longs) {
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
    public void delete(Estado entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Estado> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Estado> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Estado> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Object[]> todoEstados() {
        return estadoRepository.todoEstados();
    }
}
