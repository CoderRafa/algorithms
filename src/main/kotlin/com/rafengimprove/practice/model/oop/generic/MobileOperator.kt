package com.rafengimprove.practice.model.oop.generic

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

class MobileOperator {
}

data class Sms(
    val fromNumber: String,
    val toNumber: String,
    val message: String,
    val operator: Operator
)

enum class Operator {
    MTS, BILINE, ROSTELECOM
}

interface SendSms {
    fun send(sms: Sms): Boolean
}
@Service
class SendSmsImpl : SendSms {

    private val log = LoggerFactory.getLogger(SendSmsImpl::class.java)
    override fun send(sms: Sms): Boolean {
        log.debug("An sms was sent with operator {}", sms.operator)
        return true
    }
}

