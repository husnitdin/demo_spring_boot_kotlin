package uz.geeks.demo_spring_boot_kotlin.model.data

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank

@Entity
data class Account(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var name: String? = null,

    @Column(nullable = false, unique = true)
    var acc_number: String? = null

)
