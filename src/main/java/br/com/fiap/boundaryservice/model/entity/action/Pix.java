package br.com.fiap.boundaryservice.model.entity.action;

import lombok.Data;

@Data
public class Pix {

  private String key;

  private int bank;

  private int agency;

  private int account;

}
