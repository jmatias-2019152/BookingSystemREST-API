package org.bookingsystemrestapi.api.service.reserva;

import org.bookingsystemrestapi.api.model.Reserva;
import org.bookingsystemrestapi.api.service.reserva.ReservacionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReservacionServiceImpl implements ReservacionService {

    private final Map<Integer, Reserva> reservaMap = new HashMap<>();

    @Override
    public Reserva createReserva(Reserva reserva) {
        reservaMap.put(reserva.getId(), reserva);
        return reserva;
    }

    @Override
    public Reserva getReservaById(int id) {
        return reservaMap.get(id);
    }

    @Override
    public List<Reserva> getAllReservas() {
        return new ArrayList<>(reservaMap.values());
    }

    @Override
    public Reserva updateReserva(int id, Reserva reserva) {
        if (reservaMap.containsKey(id)) {
            reservaMap.put(id, reserva);
            return reserva;
        }
        return null;  // O lanzar una excepción personalizada
    }

    @Override
    public boolean deleteReserva(int id) {
        return reservaMap.remove(id) != null;
    }
}
