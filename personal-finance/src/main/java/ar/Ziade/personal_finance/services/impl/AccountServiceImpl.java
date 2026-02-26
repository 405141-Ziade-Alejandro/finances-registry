package ar.Ziade.personal_finance.services.impl;

import ar.Ziade.personal_finance.dtos.account.AccountDto;
import ar.Ziade.personal_finance.dtos.account.NewAccountDto;
import ar.Ziade.personal_finance.repositories.AccountRepository;
import ar.Ziade.personal_finance.services.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public List<AccountDto> getAllAccounts() {
        return List.of();
    }

    @Override
    public AccountDto getAccountById(long id) {
        return null;
    }

    @Override
    public void deleteAccount(long id) {

    }

    @Override
    public AccountDto putAccount(long id, NewAccountDto updatedAccountDto) {
        return null;
    }

    @Override
    public AccountDto postAccount(NewAccountDto accountDto) {
        return null;
    }
}
