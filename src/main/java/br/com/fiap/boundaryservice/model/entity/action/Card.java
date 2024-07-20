package br.com.fiap.boundaryservice.model.entity.action;

import lombok.Data;

@Data
public class Card {

  enum Type {
    CREDIT, DEBIT
  }

  private Type type;

  private String card;

  private String validity;

  private String cvv;

}
