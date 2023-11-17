package uz.geeks.demo_spring_boot_kotlin.service

import uz.geeks.demo_spring_boot_kotlin.model.data.Account
import uz.geeks.demo_spring_boot_kotlin.model.dto.AccReqDto

interface AccountService {

    fun createAccount(acc: AccReqDto): AccReqDto

    fun deleteAccount(id: Long): String

    fun updateAccount(acc: AccReqDto, id: Long): AccReqDto

    fun findAccountById(id: Long) : AccReqDto

    fun findAllAccounts() : List<AccReqDto>

}