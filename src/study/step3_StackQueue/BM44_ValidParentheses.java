package study.step3_StackQueue;

import java.util.Stack;

/**
 * BM44 有效括号序列
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 *
 * 使用栈（stack）来匹配括号：
 * 遍历字符串：
 * 如果是左括号 '('、'['、'{'，就入栈。
 * 如果是右括号 ')'、']'、'}'，判断栈顶元素是否为对应的左括号：
 * 是：弹出栈顶。
 * 否：直接返回 false。
 *
 * 遍历完后，若栈为空，则匹配成功；否则失败。
 */
public class BM44_ValidParentheses {
    public boolean isValid (String s) {
        char[] chars = s.toCharArray();
        Stack<Character> charStack=new Stack<>();
        for(char cc:chars){
            if(cc=='(' || cc=='[' || cc=='{'){
                charStack.push(cc);
            }else{
                if(!charStack.isEmpty()){
                    char dd=charStack.pop();
                    if(!((cc==')' && dd=='(') || (cc==']' && dd=='[') || (cc=='}' && dd=='{'))){
                        return false;
                    }
                }else{
                    return false;
                }

            }
        }
        if(!charStack.isEmpty()){
            return false;
        }
        return true;
    }
}
