package ar.Ziade.personal_finance.controllers;

import ar.Ziade.personal_finance.dtos.account.AccountDto;
import ar.Ziade.personal_finance.dtos.account.NewAccountDto;
import ar.Ziade.personal_finance.services.AccountService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/all")
    public ResponseEntity<List<AccountDto>> getAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable long id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @PostMapping("")
    public ResponseEntity<AccountDto> createAccount(@RequestBody NewAccountDto accountDto) {
        return ResponseEntity.ok(accountService.postAccount(accountDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable long id, @RequestBody NewAccountDto updatedAccountDto) {
        return ResponseEntity.ok(accountService.putAccount(id,updatedAccountDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

}
