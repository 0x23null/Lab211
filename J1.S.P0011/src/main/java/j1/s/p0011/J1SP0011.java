package j1.s.p0011;

public class J1SP0011 {

    public static void main(String[] args) {
        Display display = new Display();
        Validator getdata = new Validator();
        Converter convert = new Converter();
        do {
            display.displayMenu();
            
            int baseInput = getdata.getBase("Enter base input: ", 1, 4, 0);
            
            int baseOutput = getdata.getBase("Enter base output: ", 1, 4, baseInput);
            
            String valueInput = getdata.getInput("Enter value for convert: ", baseInput);
            
            String result = convert.convertValue(valueInput, baseInput, baseOutput);
            
            display.displayResult(result);
        } while (true);
    }
}
