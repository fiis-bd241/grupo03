package com.example.bcp.service;

    import com.example.bcp.dto.EmpleadoConRolDTO;
    import com.example.bcp.model.Empleado;
    import com.example.bcp.repository.EmpleadoRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Object[]> todosProductOwner() {
        return empleadoRepository.todosProductOwner();
    }

        public List<EmpleadoConRolDTO> obtenerTodosLosEmpleados() {
            return empleadoRepository.obtenerTodosLosEmpleados();
        }
    }

