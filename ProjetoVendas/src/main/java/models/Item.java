package models;

import lombok.Data;

@Data
public class Item {
    private Integer id;
    private String descricao;
    private Double vlItem = 0.0;
}
