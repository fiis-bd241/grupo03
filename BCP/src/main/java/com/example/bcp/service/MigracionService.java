package com.example.bcp.service;

import com.example.bcp.model.Migracion;
import com.example.bcp.repository.MigracionRepository;
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
public class MigracionService implements MigracionRepository {

    @Autowired
    private MigracionRepository migracionRepository;

    @Override
    public void flush() {

    }

    @Override
    public <S extends Migracion> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Migracion> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Migracion> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Migracion getOne(Long aLong) {
        return null;
    }

    @Override
    public Migracion getById(Long aLong) {
        return null;
    }

    @Override
    public Migracion getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Migracion> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Migracion> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Migracion> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Migracion> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Migracion> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Migracion> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Migracion, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Migracion> S save(S entity) {

        return migracionRepository.save(entity);
    }

    @Override
    public <S extends Migracion> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Migracion> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Migracion> findAll() {

        return migracionRepository.findAll();
    }

    @Override
    public List<Migracion> findAllById(Iterable<Long> longs) {
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
    public void delete(Migracion entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Migracion> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Migracion> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Migracion> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Object[]> getTop3Migraciones() {
        return migracionRepository.getTop3Migraciones();
    }
}
