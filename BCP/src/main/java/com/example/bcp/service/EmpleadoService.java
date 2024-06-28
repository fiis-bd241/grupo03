package com.example.bcp.service;

    import com.example.bcp.dto.EmpleadoConRolDTO;
    import com.example.bcp.model.Empleado;
    import com.example.bcp.repository.EmpleadoRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import com.example.bcp.model.Rol;
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
    }
    