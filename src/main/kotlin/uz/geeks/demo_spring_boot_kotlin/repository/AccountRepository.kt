package uz.geeks.demo_spring_boot_kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import uz.geeks.demo_spring_boot_kotlin.model.data.Account

@Repository
interface AccountRepository: JpaRepository<Account, Long> {

}