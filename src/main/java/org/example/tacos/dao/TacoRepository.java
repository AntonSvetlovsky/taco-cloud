package org.example.tacos.dao;

import org.example.tacos.entity.Taco;

public interface TacoRepository {

    Taco save(Taco taco);
}
