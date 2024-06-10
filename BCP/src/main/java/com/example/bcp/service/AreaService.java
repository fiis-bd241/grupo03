package com.example.bcp.service;

import com.example.bcp.model.Area;
import com.example.bcp.repository.AreaRepository;
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
public class AreaService implements AreaRepository {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public void flush() {

    }

    @Override
    public <S extends Area> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Area> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Area> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Area getOne(Long aLong) {
        return null;
    }

    @Override
    public Area getById(Long aLong) {
        return null;
    }

    @Override
    public Area getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Area> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Area> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Area> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Area> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Area> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Area> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Area, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Area> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Area> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Area> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Area> findAll() {
        return areaRepository.findAll();
    }

    @Override
    public List<Area> findAllById(Iterable<Long> longs) {
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
    public void delete(Area entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Area> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Area> findAll(Sort sort) {
        return areaRepository.findAll(sort);
    }

    @Override
    public Page<Area> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Object[]> todoAreas() {
        return areaRepository.todoAreas();
    }
}
