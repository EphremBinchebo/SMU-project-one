package com.company.MyLittleGame.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name="processingfee")
public class ProcessingFee {
    @Id
    @Column(name="processingfee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productType;
    private BigDecimal fee;

}
