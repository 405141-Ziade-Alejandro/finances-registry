package ar.Ziade.personal_finance.services;

import ar.Ziade.personal_finance.dtos.account.AccountDto;
import ar.Ziade.personal_finance.dtos.account.NewAccountDto;

import java.util.List;

public interface AccountService {
    List<AccountDto> getAllAccounts();

    AccountDto getAccountById(long id);

    void deleteAccount(long id);

    AccountDto putAccount(long id, NewAccountDto updatedAccountDto);

    AccountDto postAccount(NewAccountDto accountDto);
}
