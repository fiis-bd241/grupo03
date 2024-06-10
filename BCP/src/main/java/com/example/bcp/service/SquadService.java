package com.example.bcp.service;

import com.example.bcp.model.Squad;
import com.example.bcp.repository.SquadRepository;
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
public class SquadService implements SquadRepository {

    @Autowired
    private SquadRepository squadRepository;

    @Override
    public void flush() {

    }

    @Override
    public <S extends Squad> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Squad> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Squad> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Squad getOne(Long aLong) {
        return null;
    }

    @Override
    public Squad getById(Long aLong) {
        return null;
    }

    @Override
    public Squad getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Squad> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Squad> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Squad> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Squad> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Squad> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Squad> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Squad, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Squad> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Squad> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Squad> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Squad> findAll() {
        return squadRepository.findAll();
    }

    @Override
    public List<Squad> findAllById(Iterable<Long> longs) {
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
    public void delete(Squad entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Squad> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Squad> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Squad> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Object[]> todoSquads() {
        return squadRepository.todoSquads();
    }
}
