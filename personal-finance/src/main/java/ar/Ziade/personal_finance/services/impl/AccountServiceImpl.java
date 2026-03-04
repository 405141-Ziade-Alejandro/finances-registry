package ar.Ziade.personal_finance.services.impl;

import ar.Ziade.personal_finance.dtos.account.AccountDto;
import ar.Ziade.personal_finance.dtos.account.NewAccountDto;
import ar.Ziade.personal_finance.entities.account.AccountEntity;
import ar.Ziade.personal_finance.mapper.AccountMapper;
import ar.Ziade.personal_finance.repositories.AccountRepository;
import ar.Ziade.personal_finance.services.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public List<AccountDto> getAllAccounts() {
        List<AccountEntity> accountEntities = accountRepository.findAll();
        List<AccountDto> accountDtos = new ArrayList<>();
        for (AccountEntity accountEntity : accountEntities) {
            AccountDto accountDto = accountMapper.toDto(accountEntity);
            accountDtos.add(accountDto);
        }

        return accountDtos;
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
        Optional<AccountEntity> optionalAccountEntity = accountRepository.findByName(accountDto.name());
        if (optionalAccountEntity.isPresent()) {
            throw new IllegalArgumentException("Account already exists");
        }
        AccountEntity accountEntity = accountMapper.toEntity(accountDto);

        AccountEntity savedAccountEntity = accountRepository.save(accountEntity);


        return accountMapper.toDto(savedAccountEntity);
    }
}
