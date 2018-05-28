package FormulaParser;
import Exception.RuntimeErrorException;


public class TreeRoot implements Expression {

	private Expression child1;
	private Expression child2;
	
	public TreeRoot(Expression arg0, Expression arg1) {
		this.child1 = arg0;
		this.child2 = arg1;
	}
	
	@Override
	public String evaluate() throws RuntimeErrorException {
		// TODO Auto-generated method stub
		String unit = child2.evaluate();
		if (unit.equals("void^0")) {
			unit = "";
		} else {
			unit = "[" + unit + "]";
		}
		return child1.evaluate() + unit;
	}

}