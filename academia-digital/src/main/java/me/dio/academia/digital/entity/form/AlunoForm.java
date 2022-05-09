package me.dio.academia.digital.entity.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

  @NotEmpty(message = "o campo nome não foi preenchido corretamente")
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String nome;

  @NotEmpty(message = "preencha o campo CPF corretamente")
  @CPF(message = "'${validatedValue}' é invalido")
  private String cpf;

  @NotEmpty(message = "o campo nome não foi preenchido corretamente")
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String bairro;

  @NotNull(message = "preencha o campo data de nascimento corretamente")
  @Past(message = "'${validatedValue}' é invalido")
  private LocalDate dataDeNascimento;
}
