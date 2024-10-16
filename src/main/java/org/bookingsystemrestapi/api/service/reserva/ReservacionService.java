package org.bookingsystemrestapi.api.service.reserva;

import org.bookingsystemrestapi.api.model.Reserva;

import java.util.List;

public interface ReservacionService {
    Reserva createReserva(Reserva reserva);
    Reserva getReservaById(int id);
    List<Reserva> getAllReservas();
    Reserva updateReserva(int id, Reserva reserva);
    boolean deleteReserva(int id);
}
