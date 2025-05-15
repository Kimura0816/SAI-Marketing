package llc.cret.util;

import io.micrometer.common.util.StringUtils;

import static java.lang.Integer.parseInt;

public class ConvertUtil {

    /**
     * 「全角数字」を「半角数字」へ変換処理を実施する。
     * @param s 対象文字列
     * @return 変換結果
     */
    public static String toHalfWidthNum(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (0xFF10 <= c && c <= 0xFF19) {
                sb.setCharAt(i, (char) (c - 0xFEE0));
            }
        }
        return sb.toString();
    }

    /**
     * 金額文字列を数値に変換.
     * @param val 金額文字列
     * @return 数値
     */
    public static Integer manyToImteger(String val) {
        if (StringUtils.isEmpty(val)) {
            return 0;
        }
        return parseInt(val.replaceAll(",", ""));
    }
}
