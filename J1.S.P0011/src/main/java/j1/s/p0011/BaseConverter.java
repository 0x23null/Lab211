package j1.s.p0011;

/**
 * Lớp tiện ích chứa logic để chuyển đổi giữa các hệ cơ số.
 */
public class BaseConverter {

    /**
     * Chuyển đổi một số từ hệ cơ số này sang hệ cơ số khác.
     * Sử dụng hệ 10 làm trung gian.
     *
     * @param inputValue Giá trị chuỗi đầu vào cần chuyển đổi.
     * @param fromBase   Hệ cơ số của giá trị đầu vào (2, 10, hoặc 16).
     * @param toBase     Hệ cơ số của giá trị đầu ra (2, 10, hoặc 16).
     * @return Chuỗi kết quả sau khi chuyển đổi.
     */
    public static String convert(String inputValue, int fromBase, int toBase) {
        // Bước 1: Chuyển giá trị đầu vào từ hệ cơ số gốc sang hệ 10 (Decimal).
        // Integer.parseInt(string, radix) là một hàm cực mạnh của Java.
        int decimalValue = Integer.parseInt(inputValue, fromBase);

        // Bước 2: Chuyển giá trị hệ 10 sang hệ cơ số đích.
        // Integer.toString(integer, radix) cũng là một hàm rất tiện lợi.
        String result = Integer.toString(decimalValue, toBase);

        // Trả về kết quả, chuyển sang chữ hoa nếu là hệ Hex.
        return (toBase == 16) ? result.toUpperCase() : result;
    }
}