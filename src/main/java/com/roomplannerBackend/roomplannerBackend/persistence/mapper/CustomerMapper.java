package com.roomplannerBackend.roomplannerBackend.persistence.mapper;

import com.roomplannerBackend.roomplannerBackend.domain.Booking;
import com.roomplannerBackend.roomplannerBackend.domain.Customer;
import com.roomplannerBackend.roomplannerBackend.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "tipoId",target = "idType"),
            @Mapping(source = "nombres",target = "names"),
            @Mapping(source = "apellidos",target = "surnames"),
            @Mapping(source = "telefono",target = "phone"),
            @Mapping(source = "correo",target = "mail"),
            @Mapping(source = "contraseña",target = "password"),
            @Mapping(source = "estado",target = "state"),
            @Mapping(source = "reservas", target = "bookings"),
    })
    Customer toCustomer(Cliente cliente);
    List<Customer> toCustomers(List<Cliente> clientes);

    @InheritInverseConfiguration
    Cliente toCliente(Customer customer);
}
