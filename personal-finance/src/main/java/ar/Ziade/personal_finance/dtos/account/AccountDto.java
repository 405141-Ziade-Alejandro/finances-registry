package ar.Ziade.personal_finance.dtos.account;

import ar.Ziade.personal_finance.entities.CurrencyType;
import ar.Ziade.personal_finance.entities.account.AccountType;
import jakarta.validation.constraints.PositiveOrZero;

public record AccountDto(Long id, String name, CurrencyType currency, AccountType accountType, @PositiveOrZero long balanceInCents) {
}
