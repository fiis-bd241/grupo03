package com.example.bcp.service;

import com.example.bcp.model.Pedido;
import com.example.bcp.repository.PedidoRepository;
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
public class PedidoService implements PedidoRepository {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void flush() {

    }

    @Override
    public <S extends Pedido> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Pedido> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Pedido> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Pedido getOne(Long aLong) {
        return null;
    }

    @Override
    public Pedido getById(Long aLong) {
        return null;
    }

    @Override
    public Pedido getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Pedido> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Pedido> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Pedido> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Pedido> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Pedido> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Pedido> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Pedido, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Pedido> S save(S entity) {

        return pedidoRepository.save(entity);
    }

    @Override
    public <S extends Pedido> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Pedido> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public List<Pedido> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {
        pedidoRepository.deleteById(aLong);

    }

    @Override
    public void delete(Pedido entity) {
        pedidoRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Pedido> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Pedido> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Pedido> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Object[]> todosPedidos() {
        return pedidoRepository.todosPedidos();
    }

    @Override
    public List<Object[]> getTop3Pedidos() {
        return pedidoRepository.getTop3Pedidos();
    }
}
