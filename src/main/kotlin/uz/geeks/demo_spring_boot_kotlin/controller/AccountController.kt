package uz.geeks.demo_spring_boot_kotlin.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import uz.geeks.demo_spring_boot_kotlin.model.dto.AccReqDto
import uz.geeks.demo_spring_boot_kotlin.service.impl.AccountServiceImpl

@RestController
@RequestMapping("/api/v1")
class AccountController {

    @Autowired
    lateinit var accountService: AccountServiceImpl

    @PostMapping("/create")
    fun create(@RequestBody acc: AccReqDto): ResponseEntity<AccReqDto> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(accountService.createAccount(acc))
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(accountService.deleteAccount(id))
    }

    @PostMapping("/update/{id}")
    fun update(
        @RequestBody acc: AccReqDto,
        @PathVariable id: Long
    ): ResponseEntity<AccReqDto> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(accountService.updateAccount(acc, id))
    }

    @GetMapping("/get/{id}")
    fun getAcc(@PathVariable id: Long): ResponseEntity<AccReqDto> {
        val account = accountService.findAccountById(id)
        return ResponseEntity.status(HttpStatus.OK).body(account)
    }

    @GetMapping("/get-all")
    fun getAll(): ResponseEntity<List<AccReqDto>> {
        val accounts = accountService.findAllAccounts()
        return ResponseEntity.status(HttpStatus.OK).body(accounts)
    }
}