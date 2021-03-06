package is.ru.hugb.calc;

import static spark.Spark.*;

public class CalcWeb {
    public static void main(String[] args) {
        port(getHerokuPort());
        get("/", (req, res) -> {
            return "No route specified. Try /add/1,2";
        });
        get(
            "/sub/:input",
            (req, res) -> sub(req.params(":input"))
        );
    }

    static int getHerokuPort() {
        ProcessBuilder psb = new ProcessBuilder();
	if (psb.environment().get("PORT") != null) {
	    return Integer.parseInt(psb.environment().get("PORT"));
	}
	return 4567;
    }

    private static int sub(String input) {
        StringCalculator Calculator = new StringCalculator();
        return Calculator.add(input);
    }
}
