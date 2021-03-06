package com.lucciola.operator

import java.math.BigDecimal

import com.lucciola.exception.RuntimeErrorException
import com.lucciola.formulaparser.Expression
import com.lucciola.formulaparser.UnitParser
import com.lucciola.termination.Number
import com.lucciola.termination.Unit

class PowUnit(arg0: Unit, arg1: Number): Operator(arg0, arg1) {

    @Throws(RuntimeErrorException::class)
    override fun evaluate(): String {
        val children: List<Expression> = getChildren()
        val unitMap: Map<String, String> = UnitParser.createUnitMap(children[0].evaluate())
        val newUnitMap: HashMap<String, String> = HashMap()
        val index: String = children[1].evaluate()
        for (key: String in unitMap.keys) {
            newUnitMap[key] = BigDecimal(unitMap[key]).multiply(BigDecimal(index)).toString()
        }
        return UnitParser.createUnitString(newUnitMap)
    }

}

class PowNumber(arg0: Number, arg1: Number): Operator(arg0, arg1) {

    @Throws(RuntimeErrorException::class)
    override fun evaluate(): String {
        val children: List<Expression> = getChildren()
        val child1Decimal: Double = children[0].evaluate().toDouble()
        val child2Decimal: Double = children[1].evaluate().toDouble()
        return Math.pow(child1Decimal, child2Decimal).toString()
    }

}
