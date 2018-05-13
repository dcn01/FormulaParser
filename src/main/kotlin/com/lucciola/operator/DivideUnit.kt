package com.lucciola.operator

import java.math.BigDecimal

import com.lucciola.exception.RuntimeErrorException
import com.lucciola.formulaparser.Expression
import com.lucciola.formulaparser.UnitParser

class DivideUnit(arg0: Expression, arg1: Expression): Operator(arg0, arg1) {

    @Throws(RuntimeErrorException::class)
    override fun evaluate(): String {
        val children: ArrayList<Expression> = getChildren()
        var unitMap1: Map<String, String> = UnitParser.createUnitMap(children[0].evaluate())
        val unitMap2: Map<String, String> = UnitParser.createUnitMap(children[1].evaluate())
        val newUnitMap2 = HashMap<String, String>()
        val bondedUnit = HashMap<String, String>()
        val keySet: Set<String>  = unitMap2.keys
        for (str: String in keySet) {
            val tmp: String? = unitMap1[str]
            if (tmp != null) {
                val num: String = BigDecimal(tmp).add(BigDecimal(unitMap2[str]).negate()).toString()
                unitMap1 = unitMap1.filterKeys{ s -> s != str }
                if (num != "0")
                    bondedUnit[str] = num
            } else {
                newUnitMap2[str] = BigDecimal(unitMap2[str]).negate().toString()
            }
        }
        bondedUnit.putAll(unitMap1)
        bondedUnit.putAll(newUnitMap2)
        return UnitParser.createUnitString(bondedUnit)
    }

}
