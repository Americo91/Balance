package com.astoppello.balance.mappers;

import com.astoppello.balance.controllers.dto.MonthBalancePost;
import com.astoppello.balance.controllers.dto.MonthBalanceResponse;
import com.astoppello.balance.entities.MonthBalance;
import org.mapstruct.Mapper;

@Mapper
public interface MonthBalanceMapper {

    MonthBalance toEntity(MonthBalancePost post);

    MonthBalanceResponse toDto(MonthBalance entity);
}
