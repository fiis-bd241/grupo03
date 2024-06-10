package com.example.bcp.service;

import com.example.bcp.model.Prioridad;
import com.example.bcp.repository.PrioridadRepository;
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
public class PrioridadService implements PrioridadRepository {

    @Autowired
    private PrioridadRepository prioridadRepository;

    @Override
    public void flush() {

    }

    @Override
    public <S extends Prioridad> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Prioridad> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Prioridad> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Prioridad getOne(Integer integer) {
        return null;
    }

    @Override
    public Prioridad getById(Integer integer) {
        return null;
    }

    @Override
    public Prioridad getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Prioridad> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Prioridad> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Prioridad> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Prioridad> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Prioridad> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Prioridad> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Prioridad, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Prioridad> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Prioridad> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Prioridad> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Prioridad> findAll() {
        return prioridadRepository.findAll();
    }

    @Override
    public List<Prioridad> findAllById(Iterable<Integer> integers) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Prioridad entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Prioridad> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Prioridad> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Prioridad> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Object[]> todoPrioridades() {
        return prioridadRepository.todoPrioridades();
    }
}
