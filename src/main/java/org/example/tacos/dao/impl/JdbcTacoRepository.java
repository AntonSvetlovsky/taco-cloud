package org.example.tacos.dao.impl;

import org.example.tacos.dao.TacoRepository;
import org.example.tacos.entity.Ingredient;
import org.example.tacos.entity.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;


@Repository
public class JdbcTacoRepository implements TacoRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcTacoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Taco save(Taco taco) {
        long id = saveTacoInfo(taco);
        taco.setId(id);
        for (Ingredient ingredient : taco.getIngredients()) {
            saveIngredientToTaco(ingredient, id);
        }

        return taco;
    }

    private long saveTacoInfo(Taco taco) {
        taco.setCreatedAt(new Date());
        PreparedStatementCreator psc = new PreparedStatementCreatorFactory(
                "insert into Taco (name, createdAt) values (?, ?)",
                Types.VARCHAR, Types.TIMESTAMP
        ).newPreparedStatementCreator(
                Arrays.asList(taco.getName(), new Timestamp(taco.getCreatedAt().getTime())));
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc, keyHolder);

        return keyHolder.getKey().longValue();
    }

    private void saveIngredientToTaco(Ingredient ingredient, long tacoId) {
        jdbc.update("insert into Taco_Ingredient (taco, ingredient) values (?, ?)",
                tacoId, ingredient.getId());
    }
}
