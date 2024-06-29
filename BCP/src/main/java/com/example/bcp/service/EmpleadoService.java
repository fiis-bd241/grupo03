package com.example.bcp.service;

    import com.example.bcp.dto.EmpleadoConRolDTO;
    import com.example.bcp.dto.RendimientoUsuariosDTO;
    import com.example.bcp.model.Empleado;
    import com.example.bcp.repository.EmpleadoRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import com.example.bcp.model.Rol;

    import java.util.ArrayList;
    import java.util.Date;
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
    
        public void agregarEmpleado(Empleado empleado) {
            String contraseña = generarContraseña();
            empleado.setContraseña(contraseña);
            empleadoRepository.agregarEmpleado(empleado.getDni(), empleado.getNombre(), empleado.getRol().getNombreRol(), contraseña, empleado.getCorreo(), empleado.getTelefono());
        }

        public void actualizarContrasena(String nombre) {
            Empleado empleado = empleadoRepository.findByNombre(nombre);
            if (empleado != null) {
                String nuevaContrasena = generarContraseña();
                empleadoRepository.actualizarContrasena(empleado.getIdEmpleado(), nuevaContrasena);
            } else {
                throw new IllegalArgumentException("Empleado no encontrado con nombre: " + nombre);
            }
        }

        private String generarContraseña() {
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // Esto podría ser más complejo
            StringBuilder contraseña = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                int indice = (int) (Math.random() * caracteres.length());
                contraseña.append(caracteres.charAt(indice));
            }
            return contraseña.toString();
        }

        public List<Object[]> todoEmpleados(){
            return empleadoRepository.todoEmpleados();
        }

        public List<RendimientoUsuariosDTO> obtenerRendimientoUsuarios() {
            List<Object[]> resultados = empleadoRepository.obtenerRendimientoUsuarios();
            List<RendimientoUsuariosDTO> rendimientoUsuarios = new ArrayList<>();

            for (Object[] resultado : resultados) {
                RendimientoUsuariosDTO dto = new RendimientoUsuariosDTO(
                        (Integer) resultado[0],
                        (String) resultado[1],
                        (String) resultado[2],
                        (Date) resultado[3],
                        (Long) resultado[4],
                        ((Number) resultado[5]).intValue(),
                        ((Number) resultado[6]).intValue(),
                        (Long) resultado[7]
                );
                rendimientoUsuarios.add(dto);
            }

            return rendimientoUsuarios;
        }
    }
    