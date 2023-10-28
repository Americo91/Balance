package com.astoppello.balance.mappers;

import com.astoppello.balance.controllers.dto.YearBalancePost;
import com.astoppello.balance.controllers.dto.YearBalanceResponse;
import com.astoppello.balance.entities.YearBalance;
import org.mapstruct.Mapper;

@Mapper
public interface YearBalanceMapper {

    YearBalance toEntity(YearBalancePost post);

    YearBalanceResponse toDto(YearBalance entity);
}
