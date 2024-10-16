package org.bookingsystemrestapi.api.controller.reserva;


import org.bookingsystemrestapi.api.model.Reserva;
import org.bookingsystemrestapi.api.service.reserva.ReservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RerservacionController {

    private final ReservacionService reservacionService;

    public RerservacionController(ReservacionService reservacionService) {
        this.reservacionService = reservacionService;
    }

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservacionService.getAllReservas();
    }

    // GET: Obtener reserva por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable int id) {
        Reserva reserva = reservacionService.getReservaById(id);
        if (reserva != null) {
            return new ResponseEntity<>(reserva, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // POST: Crear una nueva reserva
    @PostMapping
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva) {
        Reserva newReserva = reservacionService.createReserva(reserva);
        return new ResponseEntity<>(newReserva, HttpStatus.CREATED);
    }

    // PUT: Actualizar una reserva existente
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable int id, @RequestBody Reserva reserva) {
        Reserva updatedReserva = reservacionService.updateReserva(id, reserva);
        if (updatedReserva != null) {
            return new ResponseEntity<>(updatedReserva, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE: Eliminar una reserva por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable int id) {
        boolean deleted = reservacionService.deleteReserva(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
