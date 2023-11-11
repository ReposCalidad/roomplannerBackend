package com.roomplannerBackend.roomplannerBackend.persistence.mapper;

import com.roomplannerBackend.roomplannerBackend.domain.Booking;
import com.roomplannerBackend.roomplannerBackend.persistence.entity.Reserva;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mappings({
            @Mapping(source = "idReserva",target = "bookingId"),
            @Mapping(source = "idCliente",target = "customerId"),
            @Mapping(source = "fecha1",target = "date1"),
            @Mapping(source = "fecha2",target = "date2"),
            @Mapping(source = "precio",target = "price"),
    })
    Booking toBooking(Reserva reserva);
    List<Booking> toBooking(List<Reserva> reservas);

    @InheritInverseConfiguration
    Reserva toReserva(Booking booking);
}
