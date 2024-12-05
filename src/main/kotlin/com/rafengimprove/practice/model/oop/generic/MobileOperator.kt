package com.rafengimprove.practice.model.oop.generic

import com.rafengimprove.practice.model.oop.generic.Operator
import com.rafengimprove.practice.model.oop.generic.Operator.*
import org.slf4j.LoggerFactory

open class Sms(
    val fromNumber: String,
    val toNumber: String,
    val message: String,
    val operator: Operator
)

class CustomSms(
    fromNumber: String,
    toNumber: String,
    message: String,
    operator: Operator,
    val extensionTitle: String
): Sms(fromNumber, toNumber, message, operator)

enum class Operator {
    MTS, BEELINE, ROSTELECOM
}

interface OperatorSendSms<T: Sms> {
    fun send(sms: T): Boolean
    fun type(): Operator
}
class OperatorSendSmsManager(private val operators: List<OperatorSendSms<Sms>>) {

    private val operatorsByType: Map<Operator, List<OperatorSendSms<Sms>>> = operators.groupBy { it.type() }

    private val log = LoggerFactory.getLogger(OperatorSendSmsManager::class.java)
    fun send(sms: Sms): Boolean {
        log.debug("An sms was sent with operator {}", sms.operator)
        return operatorsByType[sms.operator]?.map { it.send(sms) }?.any { it } ?: false
    }
}

class MtsMobileOperatorImpl: OperatorSendSms<Sms> {
    private val log = LoggerFactory.getLogger(MtsMobileOperatorImpl::class.java)
    override fun send(sms: Sms): Boolean {
        log.debug("Send a message: {} by the MTS operator", sms.message)
        return true
    }

    override fun type(): Operator {
        return MTS
    }

}

class CustomMtsMobileOperatorImpl: OperatorSendSms<Sms> {
    private val log = LoggerFactory.getLogger(MtsMobileOperatorImpl::class.java)
    override fun send(sms: Sms): Boolean {
        return if (sms is CustomSms) {
            log.debug("Send a message: {} by the MTS operator", sms.message)
            true
        } else false
    }

    override fun type(): Operator {
        return MTS
    }

}

class BeelineMobileOperatorImpl: OperatorSendSms<Sms> {
    private val log = LoggerFactory.getLogger(BeelineMobileOperatorImpl::class.java)
    override fun send(sms: Sms): Boolean {
        log.debug("Send a message: {} by the Beeline operator", sms.message)
        return true
    }

    override fun type(): Operator {
        return BEELINE
    }

}

class RostelecoMMobileOperatorImpl: OperatorSendSms<Sms> {
    private val log = LoggerFactory.getLogger(RostelecoMMobileOperatorImpl::class.java)
    override fun send(sms: Sms): Boolean {
        log.debug("Send a message: {} by the ROSTELECOM operator", sms.message)
        return true
    }

    override fun type(): Operator {
        return ROSTELECOM
    }

}

