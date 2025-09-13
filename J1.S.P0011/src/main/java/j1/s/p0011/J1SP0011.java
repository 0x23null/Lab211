package j1.s.p0011;

public class J1SP0011 {

    public static void main(String[] args) {
        while (true) {
            // Hiển thị menu và lấy lựa chọn hệ cơ số
            int fromBase = getBaseChoice("Choose the base number input (1=BIN, 2=DEC, 3=HEX): ");
            int toBase = getBaseChoice("Choose the base number output (1=BIN, 2=DEC, 3=HEX): ");

            // Lấy giá trị đầu vào dựa trên hệ cơ số đã chọn
            String inputValue = getInputValueByBase(fromBase);

            // Thực hiện chuyển đổi và in kết quả
            String result = BaseConverter.convert(inputValue, fromBase, toBase);
            System.out.println("Output value: " + result);
            System.out.println("---------------------------------");

            // Hỏi người dùng có muốn tiếp tục không
            String continueChoice = Validator.getInputValue("Do you want to continue (Y/N)? ", "[YyNn]");
            if (continueChoice.equalsIgnoreCase("N")) {
                break; // Thoát khỏi vòng lặp
            }
        }
        System.out.println("Program ended.");
    }

    /**
     * Hiển thị menu và trả về hệ cơ số tương ứng (2, 10, 16).
     * @param message Lời nhắn cho người dùng.
     * @return Hệ cơ số đã chọn.
     */
    private static int getBaseChoice(String message) {
        int choice = Validator.getIntInRange(message, 1, 3);
        switch (choice) {
            case 1:
                return 2; // Binary
            case 2:
                return 10; // Decimal
            case 3:
                return 16; // Hexadecimal
            default:
                // Trường hợp này không bao giờ xảy ra do đã validate
                return 0; 
        }
    }
    
    /**
     * Lấy giá trị cần chuyển đổi, với validation phù hợp.
     * @param fromBase Hệ cơ số đầu vào.
     * @return Chuỗi giá trị hợp lệ.
     */
    private static String getInputValueByBase(int fromBase) {
        switch (fromBase) {
            case 2:
                return Validator.getInputValue("Enter binary value: ", "[01]+");
            case 10:
                return Validator.getInputValue("Enter decimal value: ", "[0-9]+");
            case 16:
                return Validator.getInputValue("Enter hexadecimal value: ", "[0-9A-Fa-f]+");
            default:
                 return "";
        }
    }
}