import java.util.ArrayList;
import java.util.List;

public class ValidParenthesesI {
    public List<String> validParentheses(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        validParentheses(sb, n, 0, 0, result);
        return result;
    }

    private void validParentheses(StringBuilder sb, int n, int left, int right, List<String> result) {
        if (left + right == 2 * n) {
            result.add(new String(sb));
            return;
        }
        if (left < n) {
            sb.append('(');
            validParentheses(sb, n, left + 1, right, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < n && right < left) {
            sb.append(')');
            validParentheses(sb, n, left, right + 1, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
