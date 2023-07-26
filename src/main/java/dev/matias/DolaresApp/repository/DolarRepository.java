package dev.matias.DolaresApp.repository;


import dev.matias.DolaresApp.model.Dolar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface DolarRepository extends JpaRepository<Dolar, LocalDate> {

}
