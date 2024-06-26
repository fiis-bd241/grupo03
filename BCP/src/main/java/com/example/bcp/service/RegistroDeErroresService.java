package com.example.bcp.service;

import com.example.bcp.model.Pedido;
import com.example.bcp.model.RegistroDeErrores;
import com.example.bcp.repository.EmpleadoRepository;
import com.example.bcp.repository.RegistroDeErroresRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroDeErroresService {
    @Autowired
    private RegistroDeErroresRepository registroDeErroresRepository;
    public List<Object[]> todoCausasYCorreciones(Integer pedidoId) {
        return registroDeErroresRepository.todoCausasYCorreciones(pedidoId);
    }
    @Transactional
    public void registrarError(RegistroDeErrores registroDeErrores){
        int migracionId = registroDeErrores.getMigracionId().getMigracionId();
        String nombre = registroDeErrores.getEmpleado().getNombre();
        String nombreError = registroDeErrores.getErrorId().getNombreError();
        String correcionError = registroDeErrores.getCorreccionError();
        String causaError = registroDeErrores.getCausaError();
        registroDeErroresRepository.registrarError(migracionId,nombre,nombreError,correcionError,causaError);}
}
