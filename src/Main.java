import Exception.RuntimeErrorException;
import Exception.SyntaxErrorException;
import FormulaParser.Expression;
import FormulaParser.Parser;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Parser parser = new Parser("2[m'g] / 2[m'L] * 3[m]");
			Expression exp = parser.compile();
			System.out.println(exp.evaluate());
		} catch (RuntimeErrorException e) {
			// TODO Auto-generated catch block
			System.out.println("RuntimeError : " + e.getMessage());
		} catch (SyntaxErrorException e) {
			// TODO Auto-generated catch block
			System.out.println("SyntaxError : " + e.getMessage());
		}
	}

}