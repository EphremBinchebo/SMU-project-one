package com.company.MyLittleGame.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name="console")
public class Console {
    @Id
    @Column(name="consoleId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String manufacturer;
    private String memoryAmount;
   private String processor;
   private BigDecimal price;
    private int quantity;
}
