package org.bookingsystemrestapi.api.repository.reserva;

import org.bookingsystemrestapi.api.model.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservaRepository extends MongoRepository<Reserva, String> {
}