package org.example.servicio;

import org.example.modelo.Cita;
import org.example.modelo.EstadoCita;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CitaService {

    private List<Cita> citas = new ArrayList<>();
    private int contadorId = 1;

    // Registrar cita
    public void registrarCita(String paciente, LocalDate fecha) {
        Cita cita = new Cita(contadorId++, paciente, fecha);
        citas.add(cita);
    }

    // Listar citas
    public List<Cita> listarCitas() {
        return citas;
    }

    // Cambiar estado
    public boolean cambiarEstado(int id, EstadoCita nuevoEstado) {
        for (Cita c : citas) {
            if (c.getId() == id) {

                // Regla: una cita cancelada no puede ser atendida
                if (c.getEstado() == EstadoCita.CANCELADA && nuevoEstado == EstadoCita.ATENDIDA) {
                    return false;
                }

                c.setEstado(nuevoEstado);
                return true;
            }
        }
        return false;
    }

    // Eliminar cita
    public boolean eliminarCita(int id) {
        return citas.removeIf(c -> c.getId() == id);
    }
}
