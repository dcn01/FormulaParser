package com.lucciola.operator

import java.math.BigDecimal

import com.lucciola.exception.RuntimeErrorException
import com.lucciola.formulaparser.Expression

class PluseNumber(arg0: Expression, arg1: Expression ): Operator(arg0, arg1) {

    @Throws(RuntimeErrorException::class)
    override fun evaluate(): String {
        val children: ArrayList<Expression>  = getChildren()
        val child1Decimal = BigDecimal(children[0].evaluate())
        val child2Decimal = BigDecimal(children[1].evaluate())
        return child1Decimal.add(child2Decimal).toString()
    }

}
