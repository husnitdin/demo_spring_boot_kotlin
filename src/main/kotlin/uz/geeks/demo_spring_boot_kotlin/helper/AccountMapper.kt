package uz.geeks.demo_spring_boot_kotlin.helper

import uz.geeks.demo_spring_boot_kotlin.model.data.Account
import uz.geeks.demo_spring_boot_kotlin.model.dto.AccReqDto

class AccountMapper {

    fun Account.toDTO(): AccReqDto {
        return AccReqDto(
            name = this.name,
            acc_number = this.acc_number)
    }

    fun AccReqDto.toEntity(): Account {
        return Account(
            name = this.name,
            acc_number = this.acc_number
        )
    }

}



