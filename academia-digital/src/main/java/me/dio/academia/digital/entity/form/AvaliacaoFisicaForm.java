package me.dio.academia.digital.entity.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaForm {

  @Positive(message = "O Id do aluno precisa ser positivo")
  private Long alunoId;

  @NotNull(message = "Preencha o campo peso corretamente")
  @Positive(message = "${validatedValue} precisa ser positivo")
  private double peso;

  @NotNull(message = "Preencha o campo altura corretamente")
  @Positive(message = "${validatedValue} precisa ser positivo")
  private double altura;
}
