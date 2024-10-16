package org.bookingsystemrestapi.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "reservas")
public class Reserva {

    @Id
    private int id;
    private int userId;
    private double precio;
    private Date reservationDate;
    private int numeroPersonas;

    public Reserva() {
    }

    public Reserva(int id, int userId, double precio, int numeroPersonas, Date reservationDate) {
        this.id = id;
        this.userId = userId;
        this.precio = precio;
        this.numeroPersonas = numeroPersonas;
        this.reservationDate = reservationDate;
    }

    // Getters y Setters

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }
}