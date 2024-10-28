package org.bookingsystemrestapi.api.controller.reserva;


import org.bookingsystemrestapi.api.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.bookingsystemrestapi.api.service.reserva.ReservaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> findAll() {
        return reservaService.findAll();
    }

    @GetMapping("/{idReserva}")
    public Reserva findById(@PathVariable String idReserva) {
        return reservaService.findById(idReserva);
    }

    @PostMapping
    public Reserva save(@RequestBody Reserva reserva) {
        return reservaService.save(reserva);
    }

    @PutMapping("/{idReserva}")
    public Reserva update(@PathVariable String idReserva, @RequestBody Reserva reserva) {
        return reservaService.update(idReserva, reserva);
    }

    @DeleteMapping("/{idReserva}")
    public void deleteById(@PathVariable String idReserva) {
        reservaService.deleteById(idReserva);
    }
}


