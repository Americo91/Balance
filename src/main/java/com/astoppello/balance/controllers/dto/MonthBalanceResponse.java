package com.astoppello.balance.controllers.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MonthBalanceResponse extends MonthBalancePost {
    private UUID id;
}
