package aula1209;

import java.time.LocalDate;

public class Aula1209 {
    public static void main(String[] args) {
        Pessoa p = new Pessoa(
                "Victor",
                "11122233344",
                "victorsarris@gmail.",
                "89994072096",
                LocalDate.of(2005, 07, 12)
            );
        System.out.println(p.getTelefone());
        p.setTelefone("89994072096");
        p.setTelefone("8951656484");
    }
}
