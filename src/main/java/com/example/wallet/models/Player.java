package com.example.wallet.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Wallet wallet;

  @OneToMany(mappedBy = "player")
  private List<Bet> bets;

  @OneToMany(mappedBy = "player")
  private List<Transaction> transactions;

  private String firstName;
  private String lastName;
  private String phone;
  private String email;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
