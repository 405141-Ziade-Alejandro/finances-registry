package ar.Ziade.personal_finance.services.impl;

import ar.Ziade.personal_finance.dtos.account.AccountDto;
import ar.Ziade.personal_finance.dtos.account.NewAccountDto;
import ar.Ziade.personal_finance.entities.account.AccountEntity;
import ar.Ziade.personal_finance.exceptions.AccountAlreadyExistException;
import ar.Ziade.personal_finance.mapper.AccountMapper;
import ar.Ziade.personal_finance.repositories.AccountRepository;
import ar.Ziade.personal_finance.services.AccountService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * service class that help with the crud of accounts
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;


    @Override
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    public AccountDto getAccountById(long id) {
        Optional<AccountEntity> optionalAccountEntity = accountRepository.findById(id);
        if (optionalAccountEntity.isEmpty()) {
            throw new EntityNotFoundException("Account not found with id: " + id);
        }

        return accountMapper.toDto(optionalAccountEntity.get());
    }

    @Override
    public void deleteAccount(long id) {
        Optional<AccountEntity> optionalAccountEntity = accountRepository.findById(id);
        if (optionalAccountEntity.isEmpty()) {
            throw new EntityNotFoundException("Account not found with id: " + id);
        }
        accountRepository.deleteById(id);
    }

    @Transactional
    @Override
    public AccountDto putAccount(long id, NewAccountDto updatedAccountDto) {
        Optional<AccountEntity> optionalAccountEntity = accountRepository.findById(id);
        if (optionalAccountEntity.isEmpty()) {
            throw new EntityNotFoundException("Account not found with id: " + id);
        }

        //updates the manage entity
        accountMapper.updateAccount(updatedAccountDto,optionalAccountEntity.get());

        // No need to call save() explicitly if inside @Transactional
        // Hibernate dirty checking will detect changes

        return accountMapper.toDto(optionalAccountEntity.get());
    }

    @Override
    public AccountDto postAccount(NewAccountDto accountDto) {
        Optional<AccountEntity> optionalAccountEntity = accountRepository.findByName(accountDto.name());
        if (optionalAccountEntity.isPresent()) {
            throw new AccountAlreadyExistException(accountDto.name());
        }
        AccountEntity accountEntity = accountMapper.toEntity(accountDto);

        AccountEntity savedAccountEntity = accountRepository.save(accountEntity);


        return accountMapper.toDto(savedAccountEntity);
    }
}
