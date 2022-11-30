package models;

import java.util.ArrayList;
import lombok.Data;

@Data
public class Venda {
    private Integer id;
    private Cliente cliente;
    private Double vlTotal;
    private ArrayList<ItemVenda> listaItem = new ArrayList<>();
}