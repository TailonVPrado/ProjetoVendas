package models;

import lombok.Data;

@Data
public class ItemVenda {
    private Integer id;
    private Item item;
    private Venda venda;
    private Double qtde;    
}
    