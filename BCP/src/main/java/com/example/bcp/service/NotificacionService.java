package com.example.bcp.service;

import com.example.bcp.model.Notificacion;
import com.example.bcp.repository.NotificacionRepository;
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
public class NotificacionService implements NotificacionRepository{

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Override
    public void flush() {

    }

    @Override
    public <S extends Notificacion> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Notificacion> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Notificacion> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Notificacion getOne(Long aLong) {
        return null;
    }

    @Override
    public Notificacion getById(Long aLong) {
        return null;
    }

    @Override
    public Notificacion getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Notificacion> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Notificacion> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Notificacion> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Notificacion> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Notificacion> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Notificacion> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Notificacion, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Notificacion> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Notificacion> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Notificacion> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Notificacion> findAll() {
        return List.of();
    }

    @Override
    public List<Notificacion> findAllById(Iterable<Long> longs) {
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
    public void delete(Notificacion entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Notificacion> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Notificacion> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Notificacion> findAll(Pageable pageable) {
        return null;
    }
}
