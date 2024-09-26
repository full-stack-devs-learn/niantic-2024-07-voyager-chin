package com.niantic.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product
{
    private int id;
    private String name;
    private int categoryId;
    private String quantityPerUnit;
    private BigDecimal unitPrice;
    private Integer supplierId; // 0
}
