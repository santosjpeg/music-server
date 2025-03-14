package com.aaronsantos.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;          // For marking this class as a JPA entity
import javax.persistence.Table;           // To specify the table name
import javax.persistence.Id;              // To mark the primary key field
import javax.persistence.GeneratedValue;  // For auto-generation of primary key values
import javax.persistence.GenerationType;  // To specify the strategy for generating primary keys

@Entity
@Table(name = "users")
public class User 
{
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;

  @Column(name = "password_hash", nullable=false)
  private String passwordHash;

  public Long getId() {
       return id;
  }

  public void setId(Long id) {
      this.id = id;
  }

  public String getUsername() {
      return username;
  }

  public void setUsername(String username) {
      this.username = username;
  }

  public String getPasswordHash()
  {
    return this.passwordHash;
  }

  public void setPasswordHash(String passwordHash)
  {
    this.passwordHash = passwordHash;
  }
}
