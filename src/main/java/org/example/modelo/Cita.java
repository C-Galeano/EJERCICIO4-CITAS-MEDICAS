package org.example.modelo;

import java.time.LocalDate;

public class Cita {

    private int id;
    private String nombrePaciente;
    private LocalDate fecha;
    private EstadoCita estado;

    // Constructor vacío (opcional)
    public Cita() {
    }

    // ✅ Constructor de 3 parámetros (EL QUE FALTABA)
    public Cita(int id, String nombrePaciente, LocalDate fecha) {
        this.id = id;
        this.nombrePaciente = nombrePaciente;
        this.fecha = fecha;
        this.estado = EstadoCita.PROGRAMADA;
    }

    // ✅ Constructor de 4 parámetros (DEJA SOLO UNO)
    public Cita(int id, String nombrePaciente, LocalDate fecha, EstadoCita estado) {
        this.id = id;
        this.nombrePaciente = nombrePaciente;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", nombrePaciente='" + nombrePaciente + '\'' +
                ", fecha=" + fecha +
                ", estado=" + estado +
                '}';
    }
}
