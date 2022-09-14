package org.example.tacos.dao;

import org.example.tacos.entity.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
