package uz.geeks.demo_spring_boot_kotlin.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import uz.geeks.demo_spring_boot_kotlin.helper.AccountMapper
import uz.geeks.demo_spring_boot_kotlin.model.dto.AccReqDto
import uz.geeks.demo_spring_boot_kotlin.repository.AccountRepository
import uz.geeks.demo_spring_boot_kotlin.service.AccountService

@Service
class AccountServiceImpl : AccountService {

    @Autowired
    lateinit var accountRepository: AccountRepository

    override fun createAccount(acc: AccReqDto): AccReqDto {

        val newAccount = AccountMapper().run { acc.toEntity() }
        try {
            accountRepository.save(newAccount)
            return acc
        } catch (e: Exception) {
            throw RuntimeException("can not be saved")
        }
    }

    override fun deleteAccount(id: Long): String {
        val ent = accountRepository.findById(id).get()
        try {
            accountRepository.delete(ent)
            return "successfully deleted"
        } catch (e: Exception) {
            throw RuntimeException("can not be deleted")
        }
    }

    override fun updateAccount(acc: AccReqDto, id: Long): AccReqDto {

        val entity = accountRepository.findById(id).get()
        try {
            entity.name = acc.name
            entity.acc_number = acc.acc_number
            accountRepository.save(entity)
            return acc
        } catch (e: Exception) {
            throw RuntimeException("can not be updated")
        }
    }

    override fun findAccountById(id: Long): AccReqDto {
        val acc = accountRepository.findById(id).get()
        val dto = AccountMapper().run { acc.toDTO() }
        return dto
    }

    override fun findAllAccounts(): List<AccReqDto> {

        val listDtos = mutableListOf<AccReqDto>()
        val allAccEntities = accountRepository.findAll()

        for (item in allAccEntities) {
            val dto = AccountMapper().run { item.toDTO() }
            listDtos.add(dto)
        }
        return listDtos
    }
}